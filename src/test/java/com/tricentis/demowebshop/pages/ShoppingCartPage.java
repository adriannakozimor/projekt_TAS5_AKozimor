package com.tricentis.demowebshop.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (className = "page-title")
    private WebElement pageTitle;
    @Getter
    @FindBy (css = "a[href='/computing-and-internet']")
    private WebElement computingAndInternetLink;
    @FindBy (name = "removefromcart")
    private WebElement removeFromCartCheckbox;
    @FindBy (name = "updatecart")
    private WebElement updateCartButton;
    @FindBy (className = "order-summary-content")
    private WebElement orderSummaryContent;

    public String getPageTitleText() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

    public void clickRemoveBookFromCart() {
        removeFromCartCheckbox.click();
        updateCartButton.click();
    }

    public String getEmptyCartMessageText() {
        wait.until(ExpectedConditions.visibilityOf(orderSummaryContent));
        return orderSummaryContent.getText();
    }
}
