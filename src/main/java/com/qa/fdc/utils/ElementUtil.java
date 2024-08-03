package com.qa.fdc.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;

	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String GetCurrentURL() {
		return driver.getCurrentUrl();
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}

	public boolean isElementDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public WebElement waitForElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}

	
	
	public void nullBlankCheck(String value) throws Exception {
		if (value == null || value.length() == 0) {
			throw new Exception("text cannot be null or blank");
		}
	}

	public void doSendKeys(By locator, String value) throws Exception {
		nullBlankCheck(value);
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	

	public List<WebElement> getElements(By locator) {
	 return driver.findElements(locator);
	}
	
	public String waitForTitleIs(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			if (wait.until(ExpectedConditions.titleIs(title))) {

				return driver.getTitle();
			} else {

			}
		} catch (Exception e) {
			System.out.println("Title is ot found within :" + timeout);
			e.printStackTrace();
		}
		return driver.getTitle();

	}
	
	public int getElementSize(By locator) {
		return driver.findElements(locator).size();
	}
	
}
