package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.models.User;
import com.tricentis.demowebshop.pages.HomePage;
import com.tricentis.demowebshop.pages.MyAccountPage;
import com.tricentis.demowebshop.pages.RegisterPage;
import com.tricentis.demowebshop.pages.RegisterResultPage;
import net.datafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.PropertyReader;

public class RegistrationTests extends BaseTest {

    @DataProvider(name = "userWithInvalidEmailTestData")
    public Object[][] userData() {
        return new Object[][]{
                {new User("Female", "Wiktoria", "Kowalska", "wiktoria@.pl", "Haslo123")},
                {new User("Female", "Anna", "Nowak", "@test.pl", "Haslo123")},
                {new User("Male", "Olaf", "Zima", "olaf.test.pl", "Haslo123")}
        };
    }

    @Test
    public void positiveRegistrationTest() {
        User randomUser = randomUser();
        SoftAssert softAssert = new SoftAssert();
        RegisterResultPage registerResultPage = new HomePage(driver)
                .openRegisterPage()
                .registerNewUser(randomUser.getGender(),
                        randomUser.getFirstName(),
                        randomUser.getLastName(),
                        randomUser.getEmail(),
                        randomUser.getPassword());
        softAssert.assertEquals(registerResultPage.getRegistrationResultMessageText(), "Your registration completed");
        registerResultPage.clickContinueButton();
        MyAccountPage myAccountPage = new HomePage(driver).openMyAccountPage();
        softAssert.assertEquals(myAccountPage.getTitleText(), "My account - Customer info");
        if (randomUser.getGender().equalsIgnoreCase("female")) {
            softAssert.assertTrue(myAccountPage.getGenderFemaleRadioButton().isSelected());
        } else if (randomUser.getGender().equalsIgnoreCase("male")) {
            softAssert.assertTrue(myAccountPage.getGenderMaleRadioButton().isSelected());
        }
        softAssert.assertEquals(myAccountPage.getFirstNameValue(), randomUser.getFirstName());
        softAssert.assertEquals(myAccountPage.getLastNameValue(), randomUser.getLastName());
        softAssert.assertEquals(myAccountPage.getEmailValue(), randomUser.getEmail());
        softAssert.assertAll();
    }

    @Test
    public void createdUserRegistrationTest() {
        SoftAssert softAssert = new SoftAssert();
        RegisterPage registerPage = new HomePage(driver)
                .openRegisterPage()
                .registerNewUserWithInvalidData(
                        PropertyReader.getProperty("validGender"),
                        PropertyReader.getProperty("validFirstName"),
                        PropertyReader.getProperty("validLastName"),
                        PropertyReader.getProperty("validEmail"),
                        PropertyReader.getProperty("validPassword"));
        softAssert.assertEquals(registerPage.getEmailExistsErrorMessageText(), "The specified email already exists");
        softAssert.assertAll();
    }

    @Test
    public void createUserWithoutDataTest() {
        SoftAssert softAssert = new SoftAssert();
        RegisterPage registerPage = new HomePage(driver)
                .openRegisterPage();
        registerPage.clickRegisterButton();
        softAssert.assertEquals(registerPage.getValidationErrorMessageText(0), "First name is required.");
        softAssert.assertEquals(registerPage.getValidationErrorMessageText(1), "Last name is required.");
        softAssert.assertEquals(registerPage.getValidationErrorMessageText(2), "Email is required.");
        softAssert.assertEquals(registerPage.getValidationErrorMessageText(3), "Password is required.");
        softAssert.assertEquals(registerPage.getValidationErrorMessageText(4), "Password is required.");
        softAssert.assertAll();
    }

    @Test(dataProvider = "userWithInvalidEmailTestData")
    public void createUserWithInvalidEmailTest(User user) {
        SoftAssert softAssert = new SoftAssert();
        RegisterPage registerPage = new HomePage(driver)
                .openRegisterPage()
                .registerNewUserWithInvalidData(
                        user.getGender(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getPassword());
        softAssert.assertEquals(registerPage.getValidationErrorMessageText(0), "Wrong email");
        softAssert.assertAll();
    }

    private User randomUser() {
        Faker faker = new Faker();
        String timestamp = String.valueOf(System.currentTimeMillis());
        String randomGender = faker.options().option("Male", "Female");
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        return new User(
                randomGender,
                firstName,
                lastName,
                "adauser" + timestamp + "@example.com",
                "Password123"
        );
    }
}
