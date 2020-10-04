package co.singletonPattern;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	//singleton - ensures only single object gets created
	
	public static WebDriver driver = null;
	
	public static void init() {
		
		//singleton pattern
		
		if(driver==null) {
			if(Constants.browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(Constants.browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Setups\\Selenium\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.url);
	}
	
	public static void quit() {
		System.out.println("Close the browser");
		driver.close();
		driver= null;
	}

}
