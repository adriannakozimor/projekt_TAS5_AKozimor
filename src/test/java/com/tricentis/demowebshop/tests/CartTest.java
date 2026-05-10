package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.pages.ComputingAndInternetPage;
import com.tricentis.demowebshop.pages.HomePage;
import com.tricentis.demowebshop.pages.LoginPage;
import com.tricentis.demowebshop.pages.ShoppingCartPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.PropertyReader;

public class CartTest extends BaseTest{

    @Test
    public void addProductToCartTest() {
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
        softAssert.assertEquals(shoppingCartPage.getPageTitleText(), "Shopping cart");
        softAssert.assertEquals(shoppingCartPage.getComputingAndInternetLink().getText(), "Computing and Internet");
        shoppingCartPage.clickRemoveBookFromCart();
        softAssert.assertEquals(shoppingCartPage.getEmptyCartMessageText(), "Your Shopping Cart is empty!");
    }

}
