package com.tricentis.demowebshop.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RegisterPage extends BasePage {

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
    @Getter
    @FindBy(className = "validation-summary-errors")
    private WebElement emailExistsErrorMessage;
    @FindBy(className = "field-validation-error")
    private List<WebElement> validationErrorMessages;

    public RegisterResultPage registerNewUser(String gender, String firstName, String lastName, String email, String password) {
        selectGender(gender);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        registerButton.click();
        return new RegisterResultPage(driver);
    }

    public RegisterPage registerNewUserWithInvalidData(String gender, String firstName, String lastName, String email, String password) {
        selectGender(gender);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        registerButton.click();
        return this;
    }

    public String getEmailExistsErrorMessageText() {
        wait.until(ExpectedConditions.visibilityOf(emailExistsErrorMessage));
        return emailExistsErrorMessage.getText();
    }

    public String getValidationErrorMessageText(int i) {
        wait.until(ExpectedConditions.visibilityOf(validationErrorMessages.get(0)));
        return validationErrorMessages.get(i).getText();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }


    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            genderMaleRadioButton.click();
        } else if (gender.equalsIgnoreCase("female")) {
            genderFemaleRadioButton.click();
        }
    }

}
