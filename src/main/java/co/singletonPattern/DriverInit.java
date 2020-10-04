package co.singletonPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInit {
	
	public static DriverInit instance_driver =null;
	private WebDriver driver;
	
	private DriverInit() {
		
	}
	
	public WebDriver openBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public static DriverInit getInstance() {
		if(instance_driver==null)
			instance_driver = new DriverInit();
		return instance_driver;
	}

}
