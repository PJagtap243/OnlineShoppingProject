package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;
	
	private By myAccountHeading = By.xpath("//h2[text()='My Account']");
	private By logoutLink = By.linkText("Logout");
	private By searchTextfield = By.name("search");
	private By searchBtn = By.xpath("//button[@type='button' and @class='btn btn-default btn-lg']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean checkMyAccountHeading() {
		return driver.findElement(myAccountHeading).isDisplayed();
	}
	
	public boolean checkLogoutLink() {
		return driver.findElement(logoutLink).isDisplayed();
	}
	
	public SearchResultsPage searchProduct(String product) {
		driver.findElement(searchTextfield).sendKeys(product);
		driver.findElement(searchBtn).click();
		return new SearchResultsPage(driver);
	}
	
}
