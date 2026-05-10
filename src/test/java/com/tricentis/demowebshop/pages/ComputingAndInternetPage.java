package com.tricentis.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComputingAndInternetPage extends BasePage {

    public ComputingAndInternetPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "add-to-cart-button-13")
    private WebElement addToCartButton;

    @FindBy(xpath = "(//span[@class='cart-label'])[1]")
    private WebElement shoppingCartLink;

    public ComputingAndInternetPage clickAddToCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
        return this;
    }

    public ShoppingCartPage clickShoppingCartLink() {
        shoppingCartLink.click();
        return new ShoppingCartPage(driver);
    }
}
