package com.qa.ninja.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	
	
	public TestBase()
	{
		try
		{
			String projectPath = System.getProperty("user.dir");
			FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\com\\qa\\ninja\\config\\config.properties");
			prop = new Properties();
			prop.load(fis);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void initialization()
	{
		String browserName =prop.getProperty("browser");
		if(browserName.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
	
	
}
