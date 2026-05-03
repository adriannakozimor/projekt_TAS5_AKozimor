package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.pages.HomePage;
import com.tricentis.demowebshop.pages.RegisterResultPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegistrationTests extends BaseTest {

    @Test
    public void positiveRegistrationTest() {
        SoftAssert softAssert = new SoftAssert();
        RegisterResultPage registerResultPage = new HomePage(driver)
                .openRegisterPage()
                .registerNewUser("Test",
                        "User",
                        "TestUser" + System.currentTimeMillis() + "@example.com",
                        "Password123");
        softAssert.assertEquals(registerResultPage.getPageTitleText(), "Register");
        softAssert.assertEquals(registerResultPage.getRegistrationResultMessage().getText(), "Your registration completed");
        softAssert.assertTrue(registerResultPage.getContinueButton().isEnabled());
        softAssert.assertAll();
    }
}
