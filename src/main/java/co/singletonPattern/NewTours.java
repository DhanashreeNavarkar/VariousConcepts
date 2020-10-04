package co.singletonPattern;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class NewTours {
	
	@BeforeMethod
	public void setUp() {
		TestBase.init();
	}
	
	@Test
	public void verifyTitle() {
		
		String title = TestBase.driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Welcome: Mercury Tours", title);
		
	}
	@Test 
	public void verifyText() {
		Assert.assertEquals(TestBase.driver.findElement(By.xpath("//a[contains(text(),'CONTACT')]")).isDisplayed(), true);
	}
	
	@AfterMethod
	public void tearDown() {
		TestBase.quit();
	}

}
