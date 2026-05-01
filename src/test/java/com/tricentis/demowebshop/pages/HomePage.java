package com.tricentis.demowebshop.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "ico-register")
    private WebElement registerLink;
    @FindBy(className = "ico-login")
    private WebElement loginLink;
    @FindBy(className = "ico-logout")
    private WebElement logoutLink;
    @FindBy(className = "ico-cart")
    private WebElement shoppingCardLink;

    public RegisterPage openRegisterPage() {
        registerLink.click();
        return new RegisterPage(driver);
    }

    public LoginPage openLoginPage() {
        loginLink.click();
        return new LoginPage(driver);
    }

    public ShoppingCartPage openShoppingCartPage() {
        shoppingCardLink.click();
        return new ShoppingCartPage(driver);
    }

}
