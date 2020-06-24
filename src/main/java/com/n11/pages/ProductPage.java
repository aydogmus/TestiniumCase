package com.n11.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProductPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver,30);

    @FindBy(xpath = "//span[@class='pr-nm']")
    private WebElement productName;

    @FindBy(css = "div.pd-app-container div.pr-cn:nth-child(2) div.pr-cn-in div.pr-in-w div.pr-in-cn div:nth-child(3) div.pr-bx-w div.pr-bx-nm.with-org-prc > span.prc-slg")
    private WebElement productPagePrice;

    @FindBy(xpath = "//div[@class='add-to-bs-tx']")
    private WebElement basketButton;

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductPagePrice() {
        wait.until(ExpectedConditions.visibilityOf(productPagePrice));
        return productPagePrice;
    }

    public void waitForClickAddToBasket() {
        this.waitForExpectedElementByXPath("//div[@class='add-to-bs-tx']");
    }

    public void clickAddToBasket() {
        basketButton.click();

    }

        public ProductPage(WebDriver driver) {
            super(driver);
        }


    }

