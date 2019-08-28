package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class TasksPage extends TestBase {
	
	@FindBy(xpath="//input[@value='New Task']")
	WebElement newTask;
	
	@FindBy(xpath="//input[@value='Show All Tasks']")
	WebElement showTask;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement tle;
	
	@FindBy(xpath="//select[@name='status']")
	WebElement statusdropdown;
	
	@FindBy(xpath="//select[@name='task_type']")
	WebElement typedropdown;
	
	@FindBy(xpath="//select[@name='priority']")
	WebElement prioritydropdown;
	
	@FindBy(xpath="//input[@type='text' and @name='prospect_lookup']")
	WebElement dealfield;
	
	@FindBy(xpath="//input[@type='text' and @name='case_lookup']")
	WebElement casefield;
	
	@FindBy(xpath="  //*[@id=\"taskForm\"]/table/tbody/tr[1]/td/input")
	WebElement saveBtn ;
	

	
	public TasksPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkNewTaskText() {
		return newTask.isDisplayed();
	}
	
	public boolean checkShowTaskText() {
		return showTask.isDisplayed();
	}
	
	public void createNewTasks(String title, String status, String type, String priority, String deal, String cases ) {
		
		tle.sendKeys(title);
		Select select = new Select(statusdropdown);
		select.selectByVisibleText(status);
		Select select1 = new Select(typedropdown);
		select1.selectByVisibleText(type);
		Select select2 = new Select(prioritydropdown);
		select2.selectByVisibleText(priority);
		dealfield.sendKeys(deal);
		casefield.sendKeys(cases);
		
		//Actions action = new Actions(driver);
		//action.moveToElement(saveBtn).click().build().perform();
		//driver.switchTo().frame("mainpanel");
		saveBtn.click();
		
		
	}
}
