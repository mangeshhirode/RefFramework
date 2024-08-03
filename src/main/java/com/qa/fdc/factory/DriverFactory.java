package com.qa.fdc.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory{
	static WebDriver driver;
	Properties prop;
	OptionManager optionManager;

	public WebDriver initDriver(Properties prop) throws Exception {

		
		
		String browserName = prop.getProperty("browser");
		optionManager = new OptionManager(prop);
		// String browserName = System.getProperty("browser");
		System.out.println("browser name is : " + browserName);

		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(optionManager.getChromeOptions());
			break;
		case "firefox":
			driver = new FirefoxDriver(optionManager.getfirefoxOptions());
			break;
		case "edge":
			driver = new EdgeDriver(optionManager.getEdgeOptions());
			break;
		default:
			// System.out.println("plz pass the right browser...." + browserName);

			throw new Exception("NO BROWSER FOUND..." + browserName);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		return driver;
	}

	public Properties initProp()  {
		FileInputStream fis=null;
		prop = new Properties();

		String envName = System.getProperty("env");
try {
	if(envName==null) {
		System.out.println("EnvName is Null... hence we ran on QA");
		fis = new FileInputStream("./src.test.resources/config/config.qa.properties");
	}
	else {
		switch (envName.toLowerCase().trim()) {
		case "qa":
			fis = new FileInputStream("./src.test.resources/config/config.qa.properties");
			break;
		case "dev":
		fis = new FileInputStream("./src.test.resources/config/config.dev.properties");
			break;
		case "uat":
			 fis = new FileInputStream("./src.test.resources/config/config.uat.properties");
			break;
		default:
			System.out.println("Please provide right Env Name");
			throw new Exception("Please provide right Env Name");
		}}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		} 
try {
		prop.load(fis);}
catch (IOException e) {
	e.printStackTrace();
}
		return prop;

	}


	/**
	 * take screenshot
	 */

	public static String getScreenshot(String methodName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);// temp directory
		String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + System.currentTimeMillis()
				+ ".png";

		File destination = new File(path);

		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
	
}
