package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class SearchPageTest extends BaseTest{
	
	@BeforeClass
	public void SearchPageSetup() {
		hPage = lpage.loginWithValidCredentials("jagtapprashant841@gmail.com", "Test@123");
		sPage = hPage.searchProduct("macbook");
	}
	
	@Test
	public void searchPageTitleTest() {
		String title = sPage.getSearchPageTitle();
		Assert.assertTrue(title.contains("Search - "));
	}
}
