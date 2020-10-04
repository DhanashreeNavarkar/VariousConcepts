package co.java8.selenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverJava8 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("Size : "+list.size());
		
		//1. for each
		//list.forEach(ele -> System.out.println(ele.getText()));
		
		//2. 
		List<String> link = list.stream()
				.filter(ele -> !ele.getText().equals(""))
				.map(ele -> ele.getText())
				.collect(Collectors.toList());
		link.forEach(ele -> System.out.println(ele));
		
		//3.
		String firstLink = list.stream()
				.filter(ele -> !ele.getText().equals(""))
				.findFirst().get().getText();
		System.out.println("First Link: "+firstLink);
		
		
		driver.quit();

	}

}
