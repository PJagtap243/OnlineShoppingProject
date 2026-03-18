package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By error = By.xpath("//div[contains(@class,'alert-danger')]");
	private By registerPageLink = By.linkText("Register");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean checkForgottenPasswordLinkDispplayed() {
		return driver.findElement(By.linkText("Forgotten Password")).isDisplayed();
	}
	
	public HomePage loginWithValidCredentials(String uname, String pwd) {
		WebElement name = driver.findElement(username);
		name.clear();
		name.sendKeys(uname);
		WebElement pd = driver.findElement(password);
		pd.clear();
		pd.sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new HomePage(driver);
	}
	
	public String getErrorMessageOnLogin() {
		return driver.findElement(error).getText();
	}
	
	public RegistraionPage checkRegisterationPageLink() {
		driver.findElement(registerPageLink).click();
		return new RegistraionPage(driver);
	}

}
