package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utility.TestUtility;
import com.crm.qa.utility.WebEventListener;

public class TestBase {
	public static Properties prop;
	public static FileInputStream file;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener e_listener;
	public TestBase() {
		 prop = new Properties();
		 try {
			file = new FileInputStream("C:\\Users\\alef1\\eclipse-workspace\\POMFrameworkApproach\\src\\main\\java\\com\\crm"
			 		+ "\\qa\\configaration\\configaration.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		try {
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		}
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\WebDriver\\chromedriver_win32 (1)\\chromedriver.exe");
			driver= new ChromeDriver();
		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\WebDriver\\chromedriver_win32 (1)\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
	   e_driver = new EventFiringWebDriver(driver);
	   //now create an object of WebEventListener to register it with EventFiringWebDriver. 
	   e_listener= new WebEventListener();
	   e_driver.register(e_listener);
	   driver= e_driver;
		
		
		
		
	driver.manage().timeouts().pageLoadTimeout(TestUtility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtility.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
	}

}
