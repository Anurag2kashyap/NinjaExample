package com.qa.ninja.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ninja.base.TestBase;
import com.qa.ninja.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage lpage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		lpage = new LoginPage();
	}

	@Test
	public void verifyLoginPage()
	{
		lpage.loginPage();
	}
}
