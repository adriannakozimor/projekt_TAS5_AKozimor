package com.tricentis.demowebshop.tests;
import com.tricentis.demowebshop.pages.HomePage;
import com.tricentis.demowebshop.pages.RegisterResultPage;
import lombok.Getter;
import lombok.SneakyThrows;
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

    private String firstName = "Adrianna";
    private String lastName = "Testowa";
    private String password = "Password123";
    private String email = "adraiannatest@example.com";

    @SneakyThrows
    @BeforeSuite
    public void registerUserOnce() {
        WebDriver tempDriver = DriverFactory.createDriver("chrome");
        tempDriver.get(BASE_URL);
        RegisterResultPage registerResultPage = new HomePage(tempDriver)
                .openRegisterPage()
                .registerNewUser(PropertyReader.getProperty("validFirstName"),
                        PropertyReader.getProperty("validLastName"),
                        PropertyReader.getProperty("validEmail"),
                        PropertyReader.getProperty("validPassword"));
        sleep(500);
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

