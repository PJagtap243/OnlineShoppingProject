package com.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.factory.DriverFactory;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.RegistraionPage;
import com.pages.SearchResultsPage;
import com.tests.LoginPageTest;

public class BaseTest {

	protected WebDriver driver;
	protected DriverFactory driverFactory;
	protected LoginPage lpage;
	protected HomePage hPage;
	protected SearchResultsPage sPage;
	protected RegistraionPage rPage;
	protected Properties prop;
	
	@BeforeTest
	public void setup() {
		driverFactory = new DriverFactory();
		prop = driverFactory.getProperty();
		driver = driverFactory.initialization(prop);
		lpage = new LoginPage(driver);
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
