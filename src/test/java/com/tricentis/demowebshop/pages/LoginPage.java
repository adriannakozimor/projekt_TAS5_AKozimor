package com.tricentis.demowebshop.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
//TODO: zmiana z getterów na String getcośtamtext()
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    private WebElement emailInput;
    @FindBy(id = "Password")
    private WebElement passwordInput;
    @Getter
    @FindBy(id = "RememberMe")
    private WebElement rememberMeCheckbox;
    @FindBy(className = "login-button")
    private WebElement loginButton;
    @FindBy(css = ".validation-summary-errors > span")
    private WebElement errorMessage;
    @FindBy(css = ".validation-summary-errors > ul > li")
    private WebElement secondErrorMessage;
    @FindBy(css = "span[for='Email']")
    private WebElement emailErrorMessage;


    public LoginPage enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage clickRememberMeCheckbox() {
        rememberMeCheckbox.click();
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
        new HomePage(driver);
    }

    public String getErrorMessageText() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public String getSecondErrorMessageText() {
        wait.until(ExpectedConditions.visibilityOf(secondErrorMessage));
        return secondErrorMessage.getText();
    }

    public String getEmailErrorMessageText() {
        wait.until(ExpectedConditions.visibilityOf(emailErrorMessage));
        return emailErrorMessage.getText();
    }

    public LoginPage clickLoginButtonWithInvalidCredentials() {
        loginButton.click();
        return this;
    }
}
