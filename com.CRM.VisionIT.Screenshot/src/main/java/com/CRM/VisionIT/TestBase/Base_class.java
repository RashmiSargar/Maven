package com.CRM.VisionIT.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Base_class 
{
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	public Base_class() 
	{

		File f=new File("D:\\Rashmi\\eclipse\\com.CRM.VisionIT.Screenshot\\src\\main\\java\\com\\CRM\\VisonIT\\Config\\Config_File.properties");	
		
		try {
			fis = new FileInputStream(f);
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		 prop=new Properties();
		try 
		{
			prop.load(fis);
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	/*public void startbrowser(String brrname,String url)
	{
		System.setProperty("webdriver.chrome.driver","D:\\Rashmi\\Selenium\\Selenium3\\Chrome\\chromedriver.exe");

		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}*/
	public static void startBrowser(String brrName, String url_name)
	{

		if (brrName.equals("Firefox"))
		{

			System.setProperty("webdriver.gecko.driver", "D://Rashmi//Selenium//Selenium3//gecko.exe");

			driver = new FirefoxDriver();

		}
		if (brrName.equals("Chrome")) 
		{

			System.setProperty("webdriver.chrome.driver","D:\\Rashmi\\Selenium\\Selenium3\\Chrome\\chromedriver.exe");

			driver = new ChromeDriver();
		} 
		else if (brrName.equals("IE")) 
		{
			System.setProperty("webdriver.ie.driver", "D://Rashmi//Selenium//Selenium3//IEDriverServer.exe");

			driver = new InternetExplorerDriver();

		} else 
		{

			System.out.println("Browser not able to fetch and hence we are not navigating to respected browser");
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url_name);




	}
}
