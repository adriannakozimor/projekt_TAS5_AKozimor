package com.tricentis.demowebshop.pages;

import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.Thread.sleep;

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
    @FindBy (className = "cart-qty")
    private WebElement cartQuantity;

    public String getPageTitleText() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

    @SneakyThrows
    public void clickRemoveBookFromCartAndUpdate() {
        removeFromCartCheckbox.click();
        wait.until(ExpectedConditions.elementToBeSelected(removeFromCartCheckbox));
        updateCartButton.click();
    }

    public String getEmptyCartMessageText() {
        wait.until(ExpectedConditions.visibilityOf(orderSummaryContent));
        return orderSummaryContent.getText();
    }
}
