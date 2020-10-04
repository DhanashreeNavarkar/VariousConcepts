package co.pdfreader;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PDFReadeTest {
	
	@Test
	public void readPdfTest() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.learnunwired.com/pdf/Selenium-Interview-Question.pdf");
		String currentUrl=  driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		URL url = new URL(currentUrl);
		
		InputStream is = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(is);
		PDDocument document = null;
		
		document= PDDocument.load(fileParse);
		String pdfContent = new PDFTextStripper().getText(document);
		
		System.out.println(pdfContent);
		
		Assert.assertTrue(pdfContent.contains("WebDriver"));
		
		driver.quit();
		
	}

}
