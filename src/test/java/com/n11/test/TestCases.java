package com.n11.test;

import com.n11.pages.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCases  extends  BaseTest{
	/**
	 * <https://www.trendyol.com/> sitesine gelecek ve anasayfanin acildigini onaylayacak
	 */


	@Test
	public void test_1_1_homePageControl(){ 
		HomePage homePage=new HomePage(driver);
		driver.get(homePage.getUrl());
		driver.manage().window().maximize();
		homePage.waitForPageLoad();
		driver.get(homePage.getUrl());
		try{
			Assert.assertEquals(homePage.getUrl(), driver.getCurrentUrl());
			System.out.println("Navigated to correct webpage");
		}
		catch(Throwable pageNavigationError){
			System.out.println("Didn't navigate to correct webpage");
		}
	}
	
	/**
	 * Login ekranini acip, bir kullanici ile login olacak ( daha once siteye uyeliginiz varsa o olabilir )
	 */
	@Test
	public void test_1_2_loginPage(){ 
		HomePage homePage=new HomePage(driver);
		homePage.getLoginPage();
		System.out.println("Page was opened successfully for user login...");
	}
	
	/**
	 * Bir kullanici ile login olacak ( daha once siteye uyeliginiz varsa o olabilir )
	 * Burada kullanıcı adını ve şifreyi değiştiribilirsiniz.
	 */

	@Test
	public void test_1_3_signIn() throws InterruptedException, FileNotFoundException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterLoginForm();
		loginPage.submit();
		driver.get(loginPage.getUrl());
		try {
			Assert.assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
			System.out.println("Navigated to correct webpage");
		} catch (Throwable pageNavigationError) {
			System.out.println("Didn't navigate to correct webpage");
		}
		driver.get(loginPage.getUrl());
		driver.manage().window();


	}



	
	/**
	 * Ekranin ustundeki Search alanina 'bilgisayar' yazip Ara butonuna tiklayacak
	 * Gelen sayfada samsung icin sonuc bulundugunu onaylayacak 
	 * @throws InterruptedException
	 */
	@Test
		public void test_1_4_dataSearch () throws InterruptedException{
		SearchPage searchPage =new SearchPage(driver);			 
		searchPage.enterDataForSearch("bilgisayar");
		Thread.sleep(200); //Minumum bekleme ile arada oluşabilecek hata önlenmektedir.
		searchPage.submitForSearch();
		searchPage.waitForPageLoad();
		//Assert.assertTrue(!searchPage.getCountResult().equals(""));
		System.out.println("Bilgisayar için sonuç bulundu");
	 
	}


	/*
	 * Arama sonuclarindan 2. ürüne tiklayacak
	 * @throws InterruptedException
	 */

	@Test
	public void test_1_5_clickSecondProduct () throws InterruptedException{

		Thread.sleep(200); //Minumum bekleme ile arada oluşabilecek hata önlenmektedir.
		SearchPage searchPage =new SearchPage(driver);
		System.out.println("burdaaa2");
		searchPage.waitForSecondProduct();
		searchPage.clickSecondProduct();
		System.out.println(searchPage.getUrlId());
		searchPage.waitForPageLoad();

		System.out.println("2.Product successfully opened...");
	 
	}
	@Test
	public void test_1_6_writeProductNameAndPrice() throws IOException {
		ProductPage productPage= new ProductPage(driver);
		File file = new File("C:/Users/User/Downloads/SeleniumTestApp-master/src/main/java/com/n11/pages/product_details.txt");
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(fileWriter);


		writer.write(productPage.getProductName().getText());
		writer.newLine();
		writer.write(productPage.getProductPagePrice().getText());
		writer.close();
		System.out.println(productPage.getProductName().getText());
		System.out.println(productPage.getProductPagePrice().getText());
	}




	@Test
	public  void test_1_7_addToBasket() {
		ProductPage productPage = new ProductPage(driver);

		productPage.clickAddToBasket();
		productPage.waitForPageLoad();

		System.out.println("added to basket...");
	}

	@Test
	public void test_1_8_clickBasketPage() throws InterruptedException {
		//Thread.sleep(200);
		BasketPage basketPage = new BasketPage(driver);
		basketPage.waitForClickBasketPage();
		basketPage.clickBasketPage();
		//basketPage.waitForPageLoad();
		//Thread.sleep(200);
		System.out.println("open basketPage...");}



	@Test
	public void test_1_91_priceIsEqual() throws InterruptedException {

		ProductPage productPage1=new ProductPage(driver);
		BasketPage basketPageForPrice= new BasketPage(driver);
		Thread.sleep(300);

		String priceBasket=(basketPageForPrice.getBasketPrice().getText());
		Thread.sleep(4000);
		String priceForProduct=(productPage1.getProductPagePrice().getText());
		Assert.assertEquals(priceBasket,priceForProduct);

		System.out.println(basketPageForPrice.getBasketPrice().getText());
		System.out.println(productPage1.getProductPagePrice().getText());

		}




	@Test
	public  void test_1_92_addCount(){
		BasketPage basketPage= new BasketPage(driver);
		basketPage.waitForClickCount();
		basketPage.clickCount();
		System.out.println(basketPage.succesIkon().getText());
	}


	@Test
	public void test_1_93_deleteProduct(){
		BasketPage basketPage=new BasketPage(driver);
		basketPage.waitForClickCount();
		basketPage.clickTrash().click();
		basketPage.clickConfirmationDelete();
		basketPage.clickConfirmationDelete().click();
		Assert.assertTrue(basketPage.getConfirmationMesage().equals("Sepetinizde ürün bulunmamaktadır."));
		System.out.println("Deleted succesfully");
	}

}
