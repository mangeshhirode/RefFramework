package com.qa.fdc.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.fdc.base.BaseTest;
import com.qa.fdc.constants.AppContstants;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("user"), prop.getProperty("pass"));
	}

	@Test
	public void acountPageURLTest() {
		String url = accountPage.getAccountPageURL();
		org.testng.Assert.assertTrue(url.contains(AppContstants.ACCOUNT_PAGE_URL_FRACTION));
	}

	/*
	 * @Test public void titleTest() { String
	 * title=accountPage.getAccountPageTitle(); Assert.assertEquals(title,
	 * "My Account"); }
	 */

	@Test
	public void logoutLinkTest() {
		Boolean linkExixt = accountPage.logoutLinkExist();
		Assert.assertTrue(linkExixt);
	}

	@Test
	public void linkExistTest() {
		Boolean linkExixt = accountPage.myAccountLinkExist();
		Assert.assertTrue(linkExixt);
	}

	@Test
	public void headerListTest() {
		List<String> headerList = accountPage.getAccountPageHeaders();
		System.out.println("Header List is : " + headerList);
	}

	public void SerchTest() {
		try {
			accountPage.doSearch("Samsung");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
