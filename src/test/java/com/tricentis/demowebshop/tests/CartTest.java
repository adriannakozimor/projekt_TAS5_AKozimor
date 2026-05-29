package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.models.Address;
import com.tricentis.demowebshop.pages.*;
import com.tricentis.demowebshop.utils.PropertyReader;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest {

    @Test
    public void addAndRemoveProductTest() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new HomePage(driver)
                .openLoginPage()
                .enterEmail(PropertyReader.getProperty("validEmail"))
                .enterPassword(PropertyReader.getProperty("validPassword"));
        loginPage.clickLoginButton();
        ShoppingCartPage shoppingCartPage = new HomePage(driver)
                .openBooksPage()
                .openComputingAndInternetPage()
                .clickAddToCart()
                .clickShoppingCartLink();
        Assert.assertEquals(shoppingCartPage.getPageTitleText(), "Shopping cart");
        softAssert.assertTrue(shoppingCartPage.isComputingAndInternetProductVisible());
        shoppingCartPage.clickRemoveBookFromCartAndUpdate();
        softAssert.assertEquals(shoppingCartPage.getEmptyCartMessageText(), "Your Shopping Cart is empty!");
        softAssert.assertAll();
    }

    @Test
    public void completeCheckoutSuccessfullyTest() {
        SoftAssert softAssert = new SoftAssert();
        Address randomAddress = randomAddress();
        LoginPage loginPage = new HomePage(driver)
                .openLoginPage()
                .enterEmail(PropertyReader.getProperty("validEmail"))
                .enterPassword(PropertyReader.getProperty("validPassword"));
        loginPage.clickLoginButton();
        ShoppingCartPage shoppingCartPage = new HomePage(driver)
                .openBooksPage()
                .openComputingAndInternetPage()
                .clickAddToCart()
                .clickShoppingCartLink();
        Assert.assertEquals(shoppingCartPage.getPageTitleText(), "Shopping cart");
        softAssert.assertTrue(shoppingCartPage.isComputingAndInternetProductVisible());
        CheckoutPage checkoutPage = shoppingCartPage
                .clickTermsOfServiceAndCheckout();
        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
        checkoutPage.selectNewBillingAddress()
                .enterAddress(randomAddress.getCompanyName(),
                        randomAddress.getCountry(),
                        randomAddress.getCity(),
                        randomAddress.getAddress1(),
                        randomAddress.getAddress2(),
                        randomAddress.getZipPostalCode(),
                        randomAddress.getPhoneNumber(),
                        randomAddress.getFaxNumber())
                .clickBillingContinueButton();
        Assert.assertTrue(checkoutPage.isShippingAddressDropdownDisplayed());
        softAssert.assertEquals(checkoutPage.getShippingAddressLabelText(), "Select a shipping address from your address book or enter a new address.");
        softAssert.assertEquals(checkoutPage.getPickUpInStoreLabelText(), "In-Store Pickup");
        checkoutPage.clickPickUpInStoreCheckbox();
        checkoutPage.clickShippingContinueButton();
        Assert.assertEquals(checkoutPage.getCreditCashOnDeliveryPaymentMethodLabelText(), "Cash On Delivery (COD) (7.00)");
        softAssert.assertTrue(checkoutPage.isCreditCashOnDeliveryPaymentMethodSelected());
        checkoutPage.clickPaymentMethodContinueButton();
        Assert.assertEquals(checkoutPage.getPaymentInformationText(), "You will pay by COD");
        checkoutPage.clickPaymentInfoContinueButton();
        softAssert.assertEquals(checkoutPage.getBillingInfoNameText(), PropertyReader.getProperty("validFirstName") + " " + PropertyReader.getProperty("validLastName"));
        softAssert.assertEquals(checkoutPage.getBillingInfoEmailText(), "Email: " + PropertyReader.getProperty("validEmail"));
        softAssert.assertEquals(checkoutPage.getPaymentMethodText(), "Cash On Delivery (COD)");
        softAssert.assertEquals(checkoutPage.getShippingMethodText(), "In-Store Pickup");
        softAssert.assertTrue(checkoutPage.isComputingAndInternetProductNameVisible());
        CheckoutCompletedPage checkoutCompletedPage = checkoutPage
                .clickConfirmOrderButton();
        Assert.assertEquals(checkoutCompletedPage.getOrderCompletedTitleText(), "Your order has been successfully processed!");
        softAssert.assertAll();

    }

    private Address randomAddress() {
        Faker faker = new Faker();
        String companyName = faker.company().name();
        String country = faker.options().option(
                "Poland",
                "Germany",
                "France",
                "Austria",
                "United Kingdom",
                "Australia",
                "Italy",
                "Spain",
                "Netherlands",
                "Sweden",
                "Norway",
                "Denmark",
                "Finland"
        );
        String city = faker.address().city();
        String address1 = faker.address().streetAddress();
        String address2 = faker.address().secondaryAddress();
        String zipPostalCode = faker.address().zipCode();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        String faxNumber = faker.phoneNumber().phoneNumber();
        return new Address(
                companyName,
                country,
                city,
                address1,
                address2,
                zipPostalCode,
                phoneNumber,
                faxNumber
        );
    }

}
