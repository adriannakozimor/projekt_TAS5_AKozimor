package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.pages.HomePage;
import com.tricentis.demowebshop.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.PropertyReader;

public class LoginTests extends BaseTest {


    @Test
    public void logInAndLogOutValidDataTest() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new HomePage(driver)
                .openLoginPage()
                .enterEmail(PropertyReader.getProperty("validEmail"))
                .enterPassword(PropertyReader.getProperty("validPassword"))
                .clickRememberMeCheckbox();
        softAssert.assertTrue(loginPage.getRememberMeCheckbox().isSelected());
        loginPage.clickLoginButton();
        softAssert.assertTrue(homePage.getLogOutLink().isDisplayed());
        homePage.clickLogOut();
        softAssert.assertTrue(homePage.getLogInLink().isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void logInWithoutDataTest() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new HomePage(driver)
                .openLoginPage()
                .clickLoginButtonWithInvalidCredentials();
        softAssert.assertEquals(loginPage.getErrorMessageText(), "Login was unsuccessful. Please correct the errors and try again.");
        softAssert.assertEquals(loginPage.getSecondErrorMessageText(), "No customer account found");
        softAssert.assertAll();
    }

    @Test
    public void logInWithInvalidEmailTest() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new HomePage(driver)
                .openLoginPage()
                .enterEmail("InvalidEmail")
                .enterPassword(PropertyReader.getProperty("validPassword"))
                .clickLoginButtonWithInvalidCredentials();
        softAssert.assertEquals(loginPage.getEmailErrorMessageText(), "Please enter a valid email address.");
        softAssert.assertAll();
    }


}