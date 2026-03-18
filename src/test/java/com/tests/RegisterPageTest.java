package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void registrationSetup() {
		rPage = lpage.checkRegisterationPageLink();
	}
	
	@Test(priority = 1)
	public void registerPageHeaderTest() {
		String header = rPage.checkRegisterHeading();
		Assert.assertEquals(header, "Register Account");
	}
	
	@Test(priority = 2)
	public void registerUserTest() {
		String message = rPage.registerUser("Prashant", "Jagtap", "test1167@gmail.com", "1234567899", "test2233", true);
		Assert.assertEquals(message, "Your Account Has Been Created!");
	}
	


	
}
