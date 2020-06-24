package com.n11.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver,30);

    @FindBy(xpath = "//a[@class='pb-basket-item-details']")
    private WebElement basketProduct;

    @FindBy(css = "div.wrapper div.col-lg-12.col-md-12.col-xs-12:nth-child(47) section.row div.col-lg-10.col-md-10.col-xs-10.no-padding div.emptyBasketInfoBox.col-lg-12.col-md-12.col-xs-12.grid-pad-30 div.col-lg-8.col-md-8.col-xs-8 p:nth-child(1) > span:nth-child(1)")
    private WebElement text;

    @FindBy(xpath = "//a[@class='removeitem']")
    private WebElement trash;

    @FindBy(xpath = "//button[@class='btn-item btn-remove']")
    private WebElement confirmationDelete;

    @FindBy(xpath = "//div[contains(text(),'yla güncellendi')]")
    private WebElement succesPush;

    @FindBy(xpath = "//li[@id='myBasketListItem']//div[@class='icon-container']//a")
    private WebElement basket;

    @FindBy(css = "div.wrapper div.col-lg-12.col-md-12.col-xs-12:nth-child(47) section.row aside:nth-child(3) div:nth-child(1) div.col-lg-12.col-md-12.col-xs-12.shoppingReview.grid-pad-20:nth-child(2) dl:nth-child(2) > dd:nth-child(2)")
    private WebElement basketProductPrice;

    @FindBy(className = "counter-content")
    private WebElement counterContent;

    public void  waitForClickBasketPage(){


        this.waitForExpectedElementByXPath("//li[@id='myBasketListItem']//div[@class='icon-container']//a");

    }

    public void clickBasketPage(){
        basket.click();
    }



    public void clickBasketProduct(){
        basket.click();
    }

    public WebElement  getBasketPrice(){
        wait.until(ExpectedConditions.visibilityOf(basketProductPrice));
        return basketProductPrice;

    }

    public void  waitForClickCount(){
        this.waitForExpectedElementByXPath("//a[@class='goBasket']");

    }
    public void clickCount(){

        this.counterContent.clear();
        //this.counterContent.sendKeys(counterContent);
        counterContent.sendKeys(String.valueOf(2));
        //element.sendKeys(String.valueOf(number))
    }

    public WebElement getCount(){
        return counterContent;

    }

   /* public String writeCount(){
       return  counterContent.getText();
    }*/
    public WebElement succesIkon(){
        return succesPush;

    }

    public void  waitForClickTrash(){
        this.waitForExpectedElementByXPath("///i[@class='i-trash']");
        //this.waitForExpectedElementByCSSSelector("button[ng-click=\"removeFromBasket(item)\"");
    }

    public WebElement clickTrash(){
         return trash;

    }
    public void  waitForConfirmationDelete(){
        this.waitForExpectedElementByXPath("//button[@class='btn-item btn-remove']");
    }
    public WebElement clickConfirmationDelete(){
        return confirmationDelete;
    }


    public WebElement getConfirmationMesage(){
        return text;
    }

    public BasketPage(WebDriver driver) {
        super(driver);
    }
}
