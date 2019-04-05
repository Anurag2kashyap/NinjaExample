package com.qa.ninja.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ninja.base.TestBase;
import com.qa.ninja.util.TestUtil;

public class LoginPage extends TestBase {
	
	TestUtil ts = new TestUtil();

	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement login;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailAdress;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pass;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBttn;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginPage()
	{
		myAccount.click();
		login.click();
		ts.readExcelFile();
		String user_Name = ts.userName;
		emailAdress.sendKeys(user_Name);
		String password = ts.pwd;
		pass.sendKeys(password);
		
		loginBttn.click();
		
		
	}
	

}
