package com.qa.fdc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.fdc.utils.ElementUtil;

public class SearchResultPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private By searchProduct = By.className("product-thumb");
	private By product=By.xpath("//div/h4/a");
	private By serchProduct1=By.xpath("//*[@id=\"content\"]//a//img");

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public int getSearchProductCount() {
		int productsSize = driver.findElements(searchProduct).size();
		System.out.println("Search Products  Size: " + productsSize);
		return productsSize;
	}

	public String getSearchProdutName() {
		WebElement product = eleUtil.getElement(searchProduct);
		System.out.println("Search Products : " + product);

		return product.getText();
	}

	public String getCurrentURL() {
		String url = eleUtil.GetCurrentURL();
		System.out.println("Search Url : " + url);
		return url;
	}

	public String getTitle() {
		String title = eleUtil.waitForTitleIs("Search - Samsung", 5);
		System.out.println("Search Title : " + title);
		return title;
	}
	
	public String getProductInfo(String produt1) {
		String product = eleUtil.waitForElementVisible(By.linkText(produt1), 5).getText();
		System.out.println("Click Product : " + product);
		return product;
	}

	public int getSerchProductCount(String produt1) {
		int count=eleUtil.getElementSize(serchProduct1);
		System.out.println("SearchProductCount : " + count);
		return count;
	}
	
	public ProductInfoPage selectProduct(String produt1) {
		eleUtil.waitForElementVisible(By.linkText(produt1), 5).click();;
		return new ProductInfoPage(driver);
	}
	
}
