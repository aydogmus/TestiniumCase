package com.n11.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;


public class BasePage {
	WebDriverWait wait;
	protected WebDriver driver;

	public BasePage(WebDriver driver){
        this.driver = driver;
        wait= new WebDriverWait(this.driver , 500);
        PageFactory.initElements(driver, this);
    }
    public ExpectedCondition<WebElement> elementClickableById(WebElement element){
		ExpectedCondition<WebElement> clickable=ExpectedConditions.elementToBeClickable(element);
		return clickable;
    }
    public ExpectedCondition<WebElement>  elementClickableByXpath(WebElement element) {
		ExpectedCondition<WebElement> clickable=ExpectedConditions.elementToBeClickable((element));
		return clickable;
	}
   
    public void waitForPageLoad() {
	    Wait<WebDriver> wait = new WebDriverWait(driver, 10);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}

	public void waitForExpectedElementByXPath(String element) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	}

	public void waitForExpectedElementByCSSSelector(String element) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
	}

}
