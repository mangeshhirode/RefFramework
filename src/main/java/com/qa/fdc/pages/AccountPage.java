package com.qa.fdc.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.fdc.utils.ElementUtil;

public class AccountPage {

	WebDriver driver;
	private ElementUtil util;
	private By search = By.name("search");
	private By searchButton = By.cssSelector("div#search button");
    private By accountlinkExist=By.linkText("My Account");
	private By logoutLink=By.linkText("Logout");
	private By headers=By.xpath("//div[@class='col-sm-9']/h2");
	
	
	
    public AccountPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}

    public String getAccountPageTitle() {
    String title=	util.waitForTitleIs("My Account", 5);
    System.out.println("Account page title is  :"+title);
    return title;
    }
    
    
	public String getAccountPageURL() {
     String url = util.GetCurrentURL();
     System.out.println("Account Page URL is : "+url);
     return url;
	}

	public void searchbar() throws Exception {
		util.doSendKeys(search, "samsung");
	}

	public boolean myAccountLinkExist() {
		boolean linkExist=util.waitForElementVisible(accountlinkExist, 5).isDisplayed();
		return linkExist;
	}
	

	public boolean logoutLinkExist() {
		boolean linkDisplayed= util.waitForElementVisible(logoutLink, 5).isDisplayed();
		System.out.println("Logput Link is displayed or not : "+linkDisplayed);
		return linkDisplayed; 
	}
	
	public List<String> getAccountPageHeaders() {
		List<WebElement>webEle=util.getElements(headers);
		List<String> headerList=new ArrayList<String>();
		for(WebElement e:webEle) {
			String header=e.getText();
			headerList.add(header);
		}
		return headerList;
	}
	
	public String getAccountPAgeUrl() {
		return util.GetCurrentURL();
	}
	
	
	public SearchResultPage doSearch(String product) {
			try {
				util.doSendKeys(search,product);
			} catch (Exception e) {
				e.printStackTrace();
			}
		util.doClick(searchButton);
		return new SearchResultPage(driver);
	}
	
	public SearchResultPage clickOnSerch() {
		util.doClick(searchButton);
		return new SearchResultPage(driver);
	}
	
	
	
}
