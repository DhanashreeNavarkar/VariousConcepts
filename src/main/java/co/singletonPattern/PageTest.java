package co.singletonPattern;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		DriverInit instanceDriver =DriverInit.getInstance();
		driver = instanceDriver.openBrowser();
	}
	
	@Test
	public void test() {
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
