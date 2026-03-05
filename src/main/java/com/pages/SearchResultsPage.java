package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
	
	private WebDriver driver;
	
	private By searchHeader = By.xpath("//h1[contains(text(),'Search')]");
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String checkSearchedItemHeader() {
		String header = driver.findElement(searchHeader).getText();
		return header;
	}
	
	public String getSearchPageTitle() {
		return driver.getTitle();
	}
			

}
