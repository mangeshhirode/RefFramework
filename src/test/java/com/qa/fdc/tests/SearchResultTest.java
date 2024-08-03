package com.qa.fdc.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.fdc.base.BaseTest;
import com.qa.fdc.constants.AppContstants;
import com.qa.fdc.pages.SearchResultPage;
import com.qa.fdc.utils.ExcelUtil;

public class SearchResultTest extends BaseTest {

	@BeforeClass
	public void SearchResultPageTest() {
		accountPage = loginPage.doLogin(prop.getProperty("user"), prop.getProperty("pass"));
	}

	@Test(priority = 1)
	public void urlTest() {
		searchResultPage = accountPage.doSearch("Samsung");
		String url = searchResultPage.getCurrentURL();
		AssertJUnit.assertTrue(url.contains("search"));
	}

	@DataProvider
 public Object[][] getproductCountdata(){
	 return new Object[][]{
			 {"Samsung",2},
			 {"imac",1},
			 {"macbook",3}
	 };
 }
	@DataProvider
 public Object[][] getproductdatafromExcel(){
	return ExcelUtil.getTestData(AppContstants.REGISTER_SHEET_NAME);
	
	}
	
	
	
	
	
	
	
	
	@Test(dataProvider = "getproductCountdata")
	public void searchResultCountTest(String searchKey,int count) {
		searchResultPage = accountPage.doSearch(searchKey);
		int count1=searchResultPage.getSearchProductCount();
		Assert.assertEquals(count1,count);
	}
	
	
	@Test(priority = 3)
	public void searchResultPageTest() {
		String prductNme = searchResultPage.getSearchProdutName();
		AssertJUnit.assertTrue(prductNme.contains("Samsung SyncMaster 941BW"));
	}

	@Test(priority = 2)
	public void titleTest() {
		String title = searchResultPage.getTitle();
		AssertJUnit.assertEquals(title, "Search - Samsung");
	}

	@Test(priority = 4)
	public void productsCountTest() {
		int prductsNum = searchResultPage.getSearchProductCount();
		AssertJUnit.assertEquals(prductsNum, 2);
	}

}
