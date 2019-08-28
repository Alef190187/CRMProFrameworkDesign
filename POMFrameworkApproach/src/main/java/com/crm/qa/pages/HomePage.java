package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Alif Uddin')]")
	WebElement correctUsername;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement newDeals;

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Task')]")
	WebElement newTask;
	
	
	@FindBy(xpath="//a[contains(text(),'Cases')]")
	WebElement casesLink;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String checkHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean correctUsername() {
		return correctUsername.isDisplayed();
	}
	
	public ContactsPage clickoncontactsLink() {
		contactLink.click();
		return new ContactsPage();
	}
	
	public TasksPage clickontasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public DealsPage clickondealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public CasesPage clickoncasesLink() {
		casesLink.click();
		return new CasesPage();
	}
	public void clickOnNewdealsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		newDeals.click();
		
	}
	public void clickOnNewtasksLink() {
		Actions action = new Actions(driver);
		action.moveToElement(tasksLink).build().perform();
		newTask.click();
	}

}
