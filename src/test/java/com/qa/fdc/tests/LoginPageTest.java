package com.qa.fdc.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.fdc.base.BaseTest;
import com.qa.fdc.constants.AppContstants;
import com.qa.fdc.error.AppErrorClass;
import com.qa.fdc.pages.LoginPage;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitle() {

		System.out.println("Title Test..................");
		String title = loginPage.loginPageTitle();
		System.out.println("Current page Title : " + title);
		Assert.assertTrue(title.contains(AppContstants.LOGIN_PAGE_TITLE),AppErrorClass.TITLE_NOT_FOUND);
	}

	@Test(priority = 2)
	public void currentPageURLTest() {

		System.out.println("Current page Url Test..................");
		String currentURL = loginPage.getLoginPageURL();
		System.out.println("Current page URL : " + currentURL);
		Assert.assertTrue(currentURL.contains(AppContstants.LOGIN_PAGE_URL_FRACTION),AppErrorClass.URL_NOT_FOUND);
	}

	@Test(priority = 3)
	public void forgotPwdLinkTest() {

		System.out.println("Forgot Link Test..................");
		Boolean forgopwdlink = loginPage.isForgotLinkExist();
		System.out.println("forgopwdlink : " + forgopwdlink);
	}

	@Test(priority = 4)
	public void loginTest() throws Exception {
	System.out.println("Current page Url Test..................");
	accountPage=loginPage.doLogin(prop.getProperty("user"),prop.getProperty("pass"));
		Assert.assertEquals(accountPage.getAccountPageTitle(), AppContstants.ACCOUNT_PAGE_TITLE);
	}

}
