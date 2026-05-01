package com.tricentis.demowebshop.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class RegisterResultPage extends BasePage{

    public RegisterResultPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "page-title")
    private WebElement pageTitle;
    @FindBy(className = "result")
    private WebElement registrationResultMessage;
    @FindBy(className = "register-continue-button")
    private WebElement continueButton;

    public String getPageTitleText() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

     public HomePage clickContinueButton() {
        continueButton.click();
        return new HomePage(driver);
    }


}
