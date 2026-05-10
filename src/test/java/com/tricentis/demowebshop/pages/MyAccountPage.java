package com.tricentis.demowebshop.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "page-title")
    private WebElement pageTitle;
    @Getter
    @FindBy(id = "gender-female")
    private WebElement genderFemaleRadioButton;
    @Getter
    @FindBy(id = "gender-male")
    private WebElement genderMaleRadioButton;
    @FindBy(id = "FirstName")
    private WebElement firstNameInput;
    @FindBy(id = "LastName")
    private WebElement lastNameInput;
    @FindBy(id = "Email")
    private WebElement emailInput;

    public String getTitleText() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

    public String getFirstNameValue() {
        return firstNameInput.getAttribute("value");
    }

    public String getLastNameValue() {
        return lastNameInput.getAttribute("value");
    }

    public String getEmailValue() {
        return emailInput.getAttribute("value");
    }
}


