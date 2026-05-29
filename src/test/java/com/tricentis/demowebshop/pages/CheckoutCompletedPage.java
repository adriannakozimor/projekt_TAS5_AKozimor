package com.tricentis.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletedPage extends BasePage {
    public CheckoutCompletedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".order-completed .title")
    private WebElement orderCompletedTitle;

    public String getOrderCompletedTitleText() {
        wait.until(ExpectedConditions.visibilityOf(orderCompletedTitle));
        return orderCompletedTitle.getText();
    }


}
