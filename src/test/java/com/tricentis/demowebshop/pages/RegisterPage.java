package com.tricentis.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    private WebElement genderMaleRadioButton;
    @FindBy(id = "gender-female")
    private WebElement genderFemaleRadioButton;
    @FindBy(id = "FirstName")
    private WebElement firstNameInput;
    @FindBy(id = "LastName")
    private WebElement lastNameInput;
    @FindBy(id = "Email")
    private WebElement emailInput;
    @FindBy(id = "Password")
    private WebElement passwordInput;
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordInput;
    @FindBy(id = "register-button")
    private WebElement registerButton;

    public RegisterResultPage registerNewUser(String firstName, String lastName, String email, String password) {
        genderMaleRadioButton.click();
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        registerButton.click();
        return new RegisterResultPage(driver);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

}
