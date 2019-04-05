package com.qa.ninja.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.Status;
import com.qa.ninja.util.TestUtil;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	
	TestUtil ts = new TestUtil();
	
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
		
		ts.extentHtmlReport();
		
		ts.test.log(Status.INFO, "Browser is maximised");
		driver.manage().window().maximize();
		ts.test.log(Status.INFO, "Deleted all the cookies");
		driver.manage().deleteAllCookies();
		ts.test.log(Status.INFO, "Navigated to the URL");
		driver.get(prop.getProperty("url"));
	}
	
	
}
