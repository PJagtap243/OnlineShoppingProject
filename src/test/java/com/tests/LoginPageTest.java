package com.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.utils.ExcelUtil;

public class LoginPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String loginTitle = lpage.getLoginPageTitle();
		Assert.assertEquals(loginTitle, "Account Login");
	}
	
	@Test(priority = 2)
	public void forgottenPasswordLinkAvailabelityTest() {
		boolean flag = lpage.checkForgottenPasswordLinkDispplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginWithValidCredTest() {
		hPage = lpage.loginWithValidCredentials("jagtapprashant841@gmail.com", "Test@123");
		String title = hPage.getHomePageTitle();
		Assert.assertEquals(title, "My Account");
	}
	
//	@DataProvider
//	public Object[][] userData() {
//		return new Object[][] {
//			{"abc@gmail.com","Test123"},
//			{"abc@gmail.com",""},
//			{"","abc"},
//		};
//	}
	@DataProvider
	public Object[][] getDataFromSheet() {
		return ExcelUtil.getData("Register");
	}
	
	
	@Test(dataProvider = "getDataFromSheet")
	public void loginWithInvalidCredTest(String uname, String password) {
		lpage.loginWithValidCredentials(uname, password);
		String errorMessage = lpage.getErrorMessageOnLogin();
		Assert.assertEquals(errorMessage, "Warning: No match for E-Mail Address and/or Password.");
	}
}
