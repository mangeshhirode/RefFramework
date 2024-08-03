package com.qa.fdc.pages;

import java.sql.Driver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.fdc.utils.ElementUtil;


public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By productMetadata=By.xpath("(//*[@id=\"content\"]/div/div[2]/ul)[1]/li");
	private By imagesNum= By.cssSelector(" a.thumbnail img");
    private Map<String,String> productMap=new HashMap<String, String>();
	private By productPricedata=By.xpath("//*[@id=\"content\"]/div/div[2]/ul[2]/li");
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getHeader(String productName) {
		String header=eleUtil.waitForElementVisible(By.linkText(productName), 5).getText();
		return header;
	}
	
	public int imageCount() {
		return eleUtil.getElementSize(imagesNum);
	}
	
	public void getproductdata() {
		List<WebElement> metaList=eleUtil.getElements(productMetadata);
		for(WebElement w: metaList) {
			String completeText=w.getText();
			String metaKey=completeText.split(":")[0].trim();
			String metaValue=completeText.split(":")[0].trim();
          productMap.put(metaKey, metaValue);
		}
	}
	
	public void getproductPrice() {
		List<WebElement> priceList=eleUtil.getElements(productPricedata);
        String priceValue=priceList.get(0).getText();
        String EXTaxpriceValue=priceList.get(1).getText().split(":")[1].trim();
       productMap.put("productPrice", priceValue);
       productMap.put("ExTaxPrice", EXTaxpriceValue);
	}
	
	public Map<String,String> getProductDetails() {
		productMap.put("Header", getHeader("Samsung Galaxy Tab 10.1"));
		productMap.put("imageCount", String.valueOf(imageCount()));
		return productMap;
	}
	
	
}
