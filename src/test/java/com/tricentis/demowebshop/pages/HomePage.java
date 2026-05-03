package com.tricentis.demowebshop.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "ico-register")
    private WebElement registerLink;
    @FindBy(className = "ico-cart")
    private WebElement shoppingCardLink;
    @Getter
    @FindBy(className = "ico-logout")
    private WebElement logOutLink;
    @Getter
    @FindBy(className = "ico-login")
    private WebElement logInLink;

    public RegisterPage openRegisterPage() {
        registerLink.click();
        return new RegisterPage(driver);
    }

    public LoginPage openLoginPage() {
        logInLink.click();
        return new LoginPage(driver);
    }

    public ShoppingCartPage openShoppingCartPage() {
        shoppingCardLink.click();
        return new ShoppingCartPage(driver);
    }

    public void clickLogOut() {
        logOutLink.click();
    }
}
