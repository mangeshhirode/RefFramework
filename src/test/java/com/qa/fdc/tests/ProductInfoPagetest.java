package com.qa.fdc.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.fdc.base.BaseTest;
import com.qa.fdc.pages.ProductInfoPage;

public class ProductInfoPagetest extends BaseTest{

	@BeforeClass
	public void accSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("user"), prop.getProperty("pass"));
	}
	
	@Test	
	public void headerTest() {
		searchResultPage=accountPage.doSearch("samsung");
		productInfoPage=searchResultPage.selectProduct("Samsung Galaxy Tab 10.1");
		String productHeader=productInfoPage.getHeader("Samsung Galaxy Tab 10.1");
		System.out.println("product Header  : "+productHeader);
		Assert.assertEquals(productHeader, "Samsung Galaxy Tab 10.1");
	}
	
	@Test
	public void imageCounTest() {
		searchResultPage=accountPage.doSearch("samsung");
		productInfoPage=searchResultPage.selectProduct("Samsung Galaxy Tab 10.1");
	   int imageNumbers=productInfoPage.imageCount();
		System.out.println("product image Numbers  : "+imageNumbers);
	   Assert.assertEquals(imageNumbers, 7);
	}
	
	@Test
	public void productInfoTest() {
		searchResultPage=accountPage.doSearch("Samsung");
		productInfoPage=searchResultPage.selectProduct("Samsung Galaxy Tab 10.1");
		Map<String,String> productDetailsMap=productInfoPage.getProductDetails();
	     softAssert.assertEquals(productDetailsMap.get("Header"),"Samsung Galaxy Tab 10.1");
	     softAssert.assertEquals(productDetailsMap.get("imageCount"),"7");

        softAssert.assertAll();
	}
	
	
	
	
	
}
