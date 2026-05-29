package com.tricentis.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By pageTitle = By.className("page-title");
    @FindBy(name = "billing_address_id")
    private WebElement billingAddressDropdown;
    @FindBy(name = "BillingNewAddress.Company")
    private WebElement companyNameInput;
    @FindBy(name = "BillingNewAddress.CountryId")
    private WebElement countryDropdown;
    @FindBy(name = "BillingNewAddress.City")
    private WebElement cityInput;
    @FindBy(name = "BillingNewAddress.Address1")
    private WebElement address1Input;
    @FindBy(name = "BillingNewAddress.ZipPostalCode")
    private WebElement zipPostalCodeInput;
    @FindBy(name = "BillingNewAddress.PhoneNumber")
    private WebElement phoneNumberInput;
    @FindBy(name = "BillingNewAddress.FaxNumber")
    private WebElement faxNumberInput;
    @FindBy(css = "#billing-buttons-container input[title='Continue']")
    private WebElement billingContinueButton;
    @FindBy(css = "#shipping-buttons-container input[value='Continue']")
    private WebElement shippingContinueButton;
    @FindBy(css = "#payment-method-buttons-container input[value='Continue']")
    private WebElement paymentMethodContinueButton;
    @FindBy(css = "#payment-info-buttons-container input[value='Continue']")
    private WebElement paymentInfoContinueButton;
    @FindBy(css = "#confirm-order-buttons-container input[value='Confirm']")
    private WebElement confirmOrderButton;
    @FindBy(id = "PickUpInStore")
    private WebElement pickUpInStoreCheckbox;
    @FindBy(name = "shipping_address_id")
    private WebElement shippingAddressDropdown;
    @FindBy(css = "label[for='shipping-address-select']")
    private WebElement shippingAddressLabel;
    @FindBy(css = "label[for='PickUpInStore']")
    private WebElement pickUpInStoreLabel;
    @FindBy(id = "paymentmethod_0")
    private WebElement creditCashOnDeliveryPaymentMethodRadioButton;
    @FindBy(css = ".payment-details label[for='paymentmethod_0']")
    private WebElement creditCashOnDeliveryPaymentMethodLabel;
    @FindBy(css = "#checkout-step-payment-info p")
    private WebElement paymentInformationText;
    @FindBy(css = ".billing-info .name")
    private WebElement billingInfoName;
    @FindBy(css = ".billing-info .email")
    private WebElement billingInfoEmail;
    @FindBy(css = ".billing-info .country")
    private WebElement billingInfoCountry;
    @FindBy(css = ".billing-info .payment-method")
    private WebElement paymentInfoPaymentMethod;
    @FindBy(css = ".shipping-info .shipping-method")
    private WebElement shippingInfoShippingMethod;
    @FindBy(css = "a.product-name[href='/computing-and-internet']")
    private WebElement computingAndInternetProductName;


    public boolean isCheckoutPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
    }

    public CheckoutPage selectNewBillingAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressDropdown));
        Select select = new Select(billingAddressDropdown);
        select.selectByVisibleText("New Address");
        return this;
    }

    public CheckoutPage enterAddress(String companyName, String country, String city, String address1, String address2, String zipPostalCode, String phoneNumber, String faxNumber) {
        companyNameInput.sendKeys(companyName);
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
        cityInput.sendKeys(city);
        address1Input.sendKeys(address1);
        address1Input.sendKeys(address2);
        zipPostalCodeInput.sendKeys(zipPostalCode);
        phoneNumberInput.sendKeys(phoneNumber);
        faxNumberInput.sendKeys(faxNumber);
        return this;
    }

    public void clickBillingContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(billingContinueButton)).click();
    }

    public void clickShippingContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(shippingContinueButton)).click();
    }

    public void clickPaymentMethodContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinueButton)).click();
    }

    public void clickPaymentInfoContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinueButton)).click();
    }

    public CheckoutCompletedPage clickConfirmOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton)).click();
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/checkout/completed/"));
        return new CheckoutCompletedPage(driver);
    }

    public boolean isShippingAddressDropdownDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(shippingAddressDropdown)).isDisplayed();
    }

    public String getShippingAddressLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(shippingAddressLabel)).getText();
    }


    public String getPickUpInStoreLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(pickUpInStoreLabel)).getText();
    }

    public void clickPickUpInStoreCheckbox() {
        pickUpInStoreCheckbox.click();
        wait.until(ExpectedConditions.elementToBeSelected(pickUpInStoreCheckbox));
    }

    public String getCreditCashOnDeliveryPaymentMethodLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(creditCashOnDeliveryPaymentMethodLabel)).getText();
    }

    public boolean isCreditCashOnDeliveryPaymentMethodSelected() {
        return wait.until(ExpectedConditions.elementToBeSelected(creditCashOnDeliveryPaymentMethodRadioButton));
    }

    public String getPaymentInformationText() {
        return wait.until(ExpectedConditions.visibilityOf(paymentInformationText)).getText();
    }

    public String getBillingInfoNameText() {
        return wait.until(ExpectedConditions.visibilityOf(billingInfoName)).getText();
    }

    public String getBillingInfoEmailText() {
        return wait.until(ExpectedConditions.visibilityOf(billingInfoEmail)).getText();
    }

    public String getPaymentMethodText() {
        return wait.until(ExpectedConditions.visibilityOf(paymentInfoPaymentMethod)).getText();
    }

    public String getShippingMethodText() {
        return wait.until(ExpectedConditions.visibilityOf(shippingInfoShippingMethod)).getText();
    }

    public boolean isComputingAndInternetProductNameVisible() {
        return wait.until(ExpectedConditions.visibilityOf(computingAndInternetProductName)).isDisplayed();
    }

}
