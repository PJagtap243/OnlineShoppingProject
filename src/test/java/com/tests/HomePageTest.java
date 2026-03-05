package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class HomePageTest extends BaseTest{
	
	@BeforeClass
	public void homePageSetup() {
		hPage = lpage.loginWithValidCredentials("jagtapprashant841@gmail.com", "Test@123");
	}
	
	@Test
	public void homePageTitleTest() {
		String title = hPage.getHomePageTitle();
		Assert.assertEquals(title, "My Account");
	}
	
	@Test
	public void logoutLinkPresenceTest() {
		boolean flag = hPage.checkLogoutLink();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void accountHeadingPresenceTest() {
		boolean flag = hPage.checkMyAccountHeading();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void searchProductTest() {
		sPage = hPage.searchProduct("macbook");
		String searchedProduct = sPage.checkSearchedItemHeader();
		Assert.assertTrue(searchedProduct.contains("macbook"));
	}
}
