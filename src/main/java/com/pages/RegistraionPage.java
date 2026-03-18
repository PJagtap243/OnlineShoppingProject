package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistraionPage {
	
	private WebDriver driver;
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By emailAdd = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribeYesRadioBtn = By.xpath("//label[normalize-space()='Yes']");
	private By subscribeNoRadioBtn = By.xpath("//label[normalize-space()='No']");
	private By agreeBtn = By.xpath("//input[@name='agree']");
	private By registerPageHeading = By.xpath("//h1[text()='Register Account']");
	private By continueBtn = By.xpath("//input[@value='Continue']");
	private By successMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");
	private By continueBt = By.linkText("Continue");
	
	public RegistraionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String checkRegisterHeading() {
		return driver.findElement(registerPageHeading).getText();
	}
	
	public String registerUser(String fname, String lname, String email, String tele, String pwd, boolean subscribe) {
		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(emailAdd).sendKeys(email);
		driver.findElement(telephone).sendKeys(tele);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(confirmPassword).sendKeys(pwd);
		
		if(Boolean.toString(subscribe).equals("Yes")) {
			driver.findElement(subscribeYesRadioBtn).click();
		}else {
			driver.findElement(subscribeNoRadioBtn).click();
		}
		driver.findElement(agreeBtn).click();
		driver.findElement(continueBtn).click();
		return driver.findElement(successMessage).getText();
	}
	
	public HomePage checkContinueBtnOnSuccessPage() {
		driver.findElement(continueBt).click();
		return new HomePage(driver);
	}
}
