package com.n11.pages;

import com.n11.helper.CSVFileOps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class LoginPage extends BasePage {

	public static String webUrl = "https://www.trendyol.com/butik/liste/kadin?e=login";

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//a[@id='loginSubmit']")
	private WebElement loginSubmit;
	
	@FindBy(xpath = "//a[@class='mainLink user']")
	private WebElement userName;

	private String emailAddressCredential;
	private String passwordCredential;

	public void setEmailAddressCredential(String _emailAddressCredential) {
		this.emailAddressCredential = _emailAddressCredential;
	}

	public String getEmailAddressCredential(){
		return this.emailAddressCredential;
	}

	public void setPasswordCredential(String _passwordCredential) {
		this.passwordCredential = _passwordCredential;
	}

	public String getPasswordCredential(){
		return this.passwordCredential;
	}

	public LoginPage(WebDriver driver) {
		super(driver);
		CSVFileOps fops = new CSVFileOps(System.getProperty("user.dir") + "\\src\\main\\java\\com\\n11\\pages\\example.csv");
		fops.readFile();
		this.setEmailAddressCredential(fops.getEmail());
		this.setPasswordCredential(fops.getPassword());
	}

	public String getUrl(){
		return webUrl;
	}


	//Login formunu doldurmak için 
	public void enterLoginForm() throws InterruptedException {
		//Thread.sleep(4000);
		this.email.click();
		this.email.sendKeys(this.getEmailAddressCredential());
		//Thread.sleep(4000);
		this.password.click();
		this.password.sendKeys(this.getPasswordCredential());
		//Thread.sleep(4000);
		this.loginSubmit.click();
		//Thread.sleep(4000);
	}



	public void submit() throws InterruptedException {
		this.loginSubmit.click();
	}
	 public String getUserName(){
			return userName.getText();
	 }


}
