package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.utility.TestUtility;

public class CRMHomePageTest extends TestBase {
	LoginPage loginpage;
	SignUpPage signupPage;
	HomePage homepage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	CasesPage casesPage;
	TestUtility testUtil;
	public CRMHomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
	    loginpage = new LoginPage();
	    testUtil = new TestUtility();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@Test(priority=1)
	public void verifyhomePageTitleTest() {
		String title = homepage.checkHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "homepage title dose not match");
		
	}
	
	@Test(priority=2)
	public void verifycorrectUserNameTest() {
	testUtil.switchToFrame();
	boolean name =homepage.correctUsername();
	Assert.assertTrue(name);
	}
	
	@Test(priority=3)
	public void clickOnContactLinkTest() {
	testUtil.switchToFrame();
	contactsPage = homepage.clickoncontactsLink();
	}
	
	@Test(priority=4)
	public void clickOnDealsLinkTest() {
	testUtil.switchToFrame();
	dealsPage = homepage.clickondealsLink();
	}
	
	@Test(priority=5)
	public void clickOntasksLinkTest() {
		
	testUtil.switchToFrame();
    tasksPage = homepage.clickontasksLink();
	}
	
	@Test(priority=6)
	public void clickOnCasesLinkTest() {
    testUtil.switchToFrame();
	casesPage = homepage.clickoncasesLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
