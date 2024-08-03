package com.qa.fdc.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;
import com.qa.fdc.factory.DriverFactory;
import com.qa.fdc.pages.AccountPage;
import com.qa.fdc.pages.LoginPage;
import com.qa.fdc.pages.ProductInfoPage;
import com.qa.fdc.pages.ProductInfoPage;
import com.qa.fdc.pages.SearchResultPage;

public class BaseTest{
	
	WebDriver driver;
	DriverFactory df;
	 protected Properties prop;
	protected LoginPage loginPage;
	protected AccountPage accountPage;
	protected SearchResultPage searchResultPage;
	protected ProductInfoPage productInfoPage;
	protected SoftAssert softAssert;
	
	//@Parameters({"browser"})
	@BeforeTest
	public void setup() {
		df=new DriverFactory();
			prop=df.initProp();
			
			/*
			 * if(browserName!=null) { prop.setProperty("browser", browserName); }
			 */
			try {
				driver=df.initDriver(prop);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			loginPage=new LoginPage(driver);
	        softAssert=new SoftAssert();
			
	}
	

	
	@AfterTest
	public void tearDown() {
	   driver.quit();
	}

}

