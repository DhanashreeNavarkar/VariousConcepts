package co.webdriver.manager.api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerAPI {
	
	// WebDriverManagerAPI - no need to set system property for browsers
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		//	WebDriverManager.chromedriver().browserVersion("2.2").setup();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void test() {
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void tearDOwn() {
		driver.quit();
	}

}
