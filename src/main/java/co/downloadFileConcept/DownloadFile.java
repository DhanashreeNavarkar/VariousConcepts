package co.downloadFileConcept;


import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DownloadFile {
	
	WebDriver driver;
	File folder;
	
	@BeforeMethod
	public void setup() {
		//UUID- random number
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		
		//chrome
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(cap);
 
	}
	
	@Test
	public void downloadFileTest() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		
		//wait for 2 sec to download the file
		Thread.sleep(2000);
		File listFiles[] =folder.listFiles();
		
		//make sure directory is not empty
		//Assert.assertEquals(listFiles.length, is(not(0)));
		Assert.assertTrue(listFiles.length>0);
		
		for(File file : listFiles) {
			//make sure downloaded file is not empty
			//Assert.assertEquals(file.length(), is(not((int)0)));
			Assert.assertTrue(file.length()>0);
		}
	}
	

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		for(File file: folder.listFiles()) {
			file.delete();
		}
		folder.delete();
	}

}
