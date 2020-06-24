package com.n11.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; 
 

public class HomePage extends BasePage  {
		
	  private static String webUrl="https://www.trendyol.com/";
	 
	  
	  @FindBy(id = "accountBtn")
	  private WebElement accountBtn;
	  
	  @FindBy(xpath= "//a[@id='loginSubmit']")
	  private  WebElement  loginButton;

	 /* @FindBy(className = "closeBtn")
	  private  WebElement  closeButton;*/


	  public HomePage(WebDriver driver) {
	        super(driver);
	  }
	 
	 public void getLoginPage(){
		 //closeButton.click();
		 wait.until(elementClickableById(accountBtn));
		 accountBtn.click();
		 wait.until(elementClickableById(loginButton));
	 }
	 public String getUrl(){
			return webUrl;
	 }
	
	  
}
