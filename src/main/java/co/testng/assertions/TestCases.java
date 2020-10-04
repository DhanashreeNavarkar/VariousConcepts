package co.testng.assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCases {
	
	//Hard Assertion - if one line fails, immediately execution is terminated and next line wont be executed
	//				 - if a hard assertion is getting failed --> immediately test case will be marked failed and tc will be terminated
	
	//Soft Assertion - if a soft assertion is getting failed --> test case will be not be marked failed, also next line will be executed
	//assertAll()	 - to mark test case failed , if soft assertion is getting failed
	
	SoftAssert softAssert = new SoftAssert();		//we can also create softassert locally
	
	@Test
	public void test1() {
		System.out.println("Open browser");
		Assert.assertEquals(true, true);				//hard assert
		
		System.out.println("Enter username");
		System.out.println("Enter password");
		System.out.println("Click on sign in button");
		Assert.assertEquals(true, true);				//hard assert
		
		System.out.println("Validate home page");
		softAssert.assertEquals(true, false, "Home page titile missing");			//soft assert
		
		System.out.println("Go to deals page");
		System.out.println("Create a deal");
		softAssert.assertEquals(true, false, "Not able to create a deal");			//soft assert
		
		System.out.println("Go to contacts page");
		System.out.println("Create a contact");
		softAssert.assertEquals(true, false,  "Not able to create a contact");			//soft assert
	
		softAssert.assertAll(); 						//it will fail the test case which are failing but are shown pass due to softAssert
		
	}
	
	@Test
	public void test2() {
		System.out.println("Logout");
		softAssert.assertEquals(true, false, "Not able to logout");
		
		softAssert.assertAll();
	}
	
//	@AfterClass
//	public void teardown() {
//		softAssert.assertAll();
//	}

}
