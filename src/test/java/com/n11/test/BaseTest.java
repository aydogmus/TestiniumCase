package com.n11.test;
 
 
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class BaseTest {
	protected static WebDriver driver;


	@BeforeClass
	public static void before(){
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36");

		// Burada chrome driver'inizin absolute path'ini belirtmeniz gerekiyor.
		System.setProperty("webdriver.chrome.driver", "");
		driver = new ChromeDriver(opts);


	}
	@AfterClass
	public static void after() throws InterruptedException{
		Thread.sleep(3000);
	} 
	
	public WebDriver getDriver(){
		return driver;
	}
}
