package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[@src='https://d3lh3kd7bj2evy.cloudfront.net/img/logo.png']")
	WebElement crmLoginpageLogo;
	
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	 public String validateLoginpageTitle() {
		 return driver.getTitle();
	 }
	 
	 public boolean validatecrmLogo() {
		return crmLoginpageLogo.isDisplayed();
	 }
	 
	 public SignUpPage clickOnSingupBtn() {
		 //click on the signup button .
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", signUpBtn);
		 
//		 Actions action = new Actions(driver);
//		 action.moveToElement(signUpBtn).build().perform();
		 //signUpBtn.click();
		 return new SignUpPage();
	 }
	 
	 public HomePage login(String un, String pw) {
		 
		 username.sendKeys(un);
		 password.sendKeys(pw);
		 //move to the element.
		 
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", loginBtn);
//		 Actions action = new Actions(driver);
//		 action.moveToElement(loginBtn).build().perform();
//		 loginBtn.click();
		 return new HomePage();
		 
		 
	 }
	
    
	
}
