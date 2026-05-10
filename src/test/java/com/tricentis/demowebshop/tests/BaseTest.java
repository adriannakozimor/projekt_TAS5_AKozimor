package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.pages.HomePage;
import com.tricentis.demowebshop.pages.RegisterPage;
import com.tricentis.demowebshop.pages.RegisterResultPage;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.Core;
import utils.DriverFactory;
import utils.PropertyReader;

import static java.lang.Thread.sleep;

@Getter
public class BaseTest extends Core {
    protected final String BASE_URL = "https://demowebshop.tricentis.com/";

    @SneakyThrows
    @BeforeSuite
    public void registerUserOnce() {
        //TODO: przygotować do raportu

        WebDriver tempDriver = DriverFactory.createDriver("chrome");
        tempDriver.get(BASE_URL);
        RegisterPage registerPage = new HomePage(tempDriver)
                .openRegisterPage();
        RegisterResultPage registerResultPage = new RegisterPage(tempDriver)
                .registerNewUser(PropertyReader.getProperty("validGender"),
                        PropertyReader.getProperty("validFirstName"),
                        PropertyReader.getProperty("validLastName"),
                        PropertyReader.getProperty("validEmail"),
                        PropertyReader.getProperty("validPassword"));
        sleep(1000);
        //Weryfikacja, czy użytkownik istnieje, czy został zarejestrowany poprawnie, czy wystąpił inny błąd
        boolean isAdded = tempDriver.findElements(By.cssSelector(".result")).size() > 0;
        boolean isError = tempDriver.findElements(By.cssSelector(".validation-summary-errors")).size() > 0;
        if (isAdded) {
            System.out.println("User registered successfully");
        } else if (isError) {
            System.out.println("User already exists");
        } else {
            System.out.println("Other error occurred during registration");
        }
        tempDriver.quit();
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        quitDriver();
    }
}

