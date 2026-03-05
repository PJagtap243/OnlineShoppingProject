package com.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public Properties prop;
	public WebDriver driver;
	OptionManager op;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initialization(Properties prop) {
		String browserName = prop.getProperty("browser");
		op = new OptionManager(prop);
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			tlDriver.set(new ChromeDriver(op.getChromeOptions()));
			break;
		case "edge":
			tlDriver.set(new EdgeDriver(op.getEdgeOptions()));
			break;
		case "firefox":
			tlDriver.set(new FirefoxDriver(op.getFireFoxOptions()));
			break;

		default:
			System.out.println("Please pass the right browser..");
			break;
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public Properties getProperty() {
		
		prop = new Properties();
		try {
			FileInputStream fp = new FileInputStream("C:\\Users\\prash\\eclipse-workspace\\OnlineShopping\\src\\resources\\com\\config\\config.properties");
			prop.load(fp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return prop;
	}

}
