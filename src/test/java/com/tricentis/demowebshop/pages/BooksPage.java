package com.tricentis.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BooksPage extends BasePage {

    public BooksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-title a[href='/computing-and-internet']")
    private WebElement computingAndInternetLink;

    public ComputingAndInternetPage openComputingAndInternetPage() {
        wait.until(ExpectedConditions.elementToBeClickable(computingAndInternetLink));
        computingAndInternetLink.click();
        return new ComputingAndInternetPage(driver);
    }

}
