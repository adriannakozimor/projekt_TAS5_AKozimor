package com.tricentis.demowebshop.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    @FindBy(className = "account")
    private WebElement myAccountLink;
    @FindBy(css = "a[href*='books']")
    private WebElement booksLink;

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

    public MyAccountPage openMyAccountPage() {
        myAccountLink.click();
        return new MyAccountPage(driver);
    }

    public BooksPage openBooksPage() {
        wait.until(ExpectedConditions.visibilityOf(booksLink));
        booksLink.click();
        return new BooksPage(driver);
    }

    public void clickLogOut() {
        logOutLink.click();
    }
}
