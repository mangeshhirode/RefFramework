package com.qa.fdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.fdc.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
    private By username=By.id("input-email");
    private By password=By.id("input-password");
    private By loginButton=By.xpath("//input[@value='Login']");
	private By forgotPWdLink=By.linkText("Forgotten Password");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String loginPageTitle() {
		String title = eleUtil.getTitle();
		return title;
	}

	public String getLoginPageURL() {
		String title=eleUtil.GetCurrentURL();
		return title;
	}
	
	public Boolean isForgotLinkExist() {
		Boolean title=eleUtil.isElementDisplayed(forgotPWdLink);
		return title;
	}
	
	public AccountPage doLogin(String user,String pass) {
		eleUtil.waitForElementVisible(username, 5).sendKeys(user);
		try {
			eleUtil.doSendKeys(password, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eleUtil.doClick(loginButton);
		return new AccountPage(driver);
		
		
	}
	
}
