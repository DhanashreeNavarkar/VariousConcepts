package co.failedtestcase.screenshots;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class ScreeenShotTest extends Base{
	
	@BeforeMethod
	public void setUp() {
		intializtion();
	}
	
	@Test(priority = 1)
	public void takeScreenShotTest1() {
		
		Assert.assertEquals(false, true);
	}
	
	@Test(priority = 2)
	public void takeScreenShotTest2() {
		
		Assert.assertEquals(false, true);
	}
	
	@Test(priority = 3)
	public void takeScreenShotTest3() {
		
		Assert.assertEquals(false, true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
