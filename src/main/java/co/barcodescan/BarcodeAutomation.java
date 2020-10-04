package co.barcodescan;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import co.singletonPattern.Constants;

public class BarcodeAutomation {

	@Test
	public void barcodeTest() throws IOException, NotFoundException {
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://barcode.tec-it.com/en/");
		
		String barcodeURL = driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(barcodeURL);
		
		URL url = new URL(barcodeURL);
		BufferedImage bufferedImage= ImageIO.read(url);
		
		LuminanceSource luminanceSource=new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		Result result =new MultiFormatReader().decode(binaryBitmap);
		
		System.out.println(result.getText());
		driver.quit();
		
	}

}
