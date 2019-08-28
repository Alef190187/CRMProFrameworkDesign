package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

public class CRMTasksPageTest extends TestBase  {
	LoginPage loginpage;
	SignUpPage signupPage;
	HomePage homepage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	CasesPage casesPage;
	TestUtility testUtil;
	//String sheetname="Tasks_data";
	
	public CRMTasksPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
	    loginpage = new LoginPage();
	    testUtil = new TestUtility();
	    
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		tasksPage = homepage.clickontasksLink();
	}
	
	
	@Test(priority=1)
	public void verifyNewtaskTextTest() {
		boolean flag = tasksPage.checkNewTaskText();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void verifyshowtaskTextTest() {
		Assert.assertTrue(tasksPage.checkShowTaskText());
	}
	
	@Test(priority=3)
	public void clickOntasksLinkTest() {
		homepage.clickontasksLink();
	}
	
	@DataProvider()
	public Object[][] getCRMTaskData() {
		Object [][]data = TestUtility.getTestData("Tasks_data");
		return data;
		
	}
//	@Test(priority=4)//insert data hardcode.
//	public void createNewtasksTest() {
//		homepage.clickOnNewtasksLink();
//		tasksPage.createNewTasks("Mr", "Open", "Call", "High", "Humper", "Primary");
//	}
	
	@Test(priority=4, dataProvider="getCRMTaskData")//insert data from excel sheet.
	public void createNewtasksTest(String title, String status, String type,
			String priority, String deal, String cases) {
		homepage.clickOnNewtasksLink();
		tasksPage.createNewTasks(title, status, type, priority, deal, cases);
	}
	
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
