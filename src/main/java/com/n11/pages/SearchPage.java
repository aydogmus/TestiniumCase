package com.n11.pages;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class SearchPage  extends BasePage{
	//public static String webUrl = "https://www.trendyol.com/apple/10-2-ipad-7-nesil-wi-fi-32gb-space-gray-mw742tu-a-tablet-p-32001713?boutiqueId=492047&merchantId=106664";
	public static String productId="32001713";
	//@FindBy(xpath ="//i[@class='search-icon']")

	@FindBy(className = "search-icon")
	private WebElement searchIkon;

	@FindBy(id = "searchData")
	private WebElement searchData;
	
	@FindBy(className = "search-box")
	private WebElement searchBox;
	
	//Arama sonucu
	@FindBy(xpath = "//div[@class='dscrptn']")
	private WebElement countResult;
	
	//Arama sayfasındaki 2. ürün
	@FindBy(xpath = "//body//div[@class='srch-prdcts-cntnr']//div//div[2]//div[1]//a[1]")
	private WebElement secondProduct;


	//Arama sonuçlarından listedeki 3. ürün
	//@FindBy(xpath="//div[@id='container']//div[3]//div[1]//a[1]//div[1]//div[1]//img[1]")
	//private WebElement thirdProductInList;

	//3.ürün isimi
	@FindBy(xpath = "//body/div[@id='container']/div[@id='search-app']/div[@class='search-app-container']/div[@class='srch-rslt-cntnt']/div[@class='srch-prdcts-cntnr']/div/div[@class='prdct-cntnr-wrppr']/div[3]/div[1]/a[1]/div[3]/div[1]/div[1]")
	private WebElement thirdProductName;

	//3.ürünün sepete ekle buttonu
	@FindBy(xpath = "//div[@id='p-420784032']//div[@class='proDetail']//ins")
	private WebElement addButtonBox;
			
	public SearchPage(WebDriver driver) {
		super(driver); 
	}
	
	//Arama kısmına veri girmek için
	public void enterDataForSearch(String data) {
		this.searchBox.clear();
		this.searchBox.sendKeys(data);
	}
	
	//Arama yapmak için
	public void submitForSearch() {
		searchIkon.click();
	}
	
	//Arama sonucu
	public String getCountResult()
	{
		return countResult.getText();
	}

	//Arama sayfasının 2. ürüne tıklaması

	public void waitForSecondProduct() {
		this.waitForExpectedElementByXPath("//body//div[@class='srch-prdcts-cntnr']//div//div[2]//div[1]//a[1]");
	}

	public void clickSecondProduct() {
		secondProduct.click();
	}
	public String getUrlId(){
		return productId;
	}
	

}
