package com.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.UserDataHandler;

public class TestBase {

	public static  WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		prop=new Properties();
		try {
			FileInputStream fin=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/amazon/config/config.properties");
			prop.load(fin);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void initializeBrowser()
	{
		String browserName=prop.getProperty("Browser");
		 if(browserName.equals("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Desktop\\chromedriver.exe");
			 driver=new ChromeDriver();
		 }
		
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 driver.get(prop.getProperty("URL"));	 
		
	}
}
