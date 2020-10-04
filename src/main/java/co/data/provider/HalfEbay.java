package co.data.provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HalfEbay {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?rv4=1");
	}
	
	@DataProvider
	public Iterator<Object[]> getData() {
		
		ArrayList<Object[]> testData = TestUtil.getExcelData();
		return testData.iterator();
		
	}
	
	@Test(dataProvider = "getData")
	public void loginTest(String firstName, String lastName, String eMail, String password) {
		
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys(firstName);
		
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys(lastName);
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(eMail);
		
		driver.findElement(By.id("PASSWORD")).clear();
		driver.findElement(By.id("PASSWORD")).sendKeys(password);
		

	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
