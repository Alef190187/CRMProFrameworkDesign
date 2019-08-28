package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;

public class CRMLoginPageTest extends TestBase {
	LoginPage loginpage;
	SignUpPage signupPage;
	HomePage homepage;
	public CRMLoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
	    loginpage = new LoginPage();
	}
	 
	@Test(priority =1)
	public void verifycrmloginPageTitleTest() {
		String title =loginpage.validateLoginpageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void verifycrmLogoTest() {
		boolean logo = loginpage.validatecrmLogo();
		Assert.assertEquals(logo, true);
	}
	
	@Test(priority=3)
	public void clickonSignupBtn() {
	signupPage = loginpage.clickOnSingupBtn();
	}
	@Test(priority=4)
	public void clickOnLoginBtn() {
	 homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
