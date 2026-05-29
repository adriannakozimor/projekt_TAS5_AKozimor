package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.pages.HomePage;
import com.tricentis.demowebshop.utils.Core;
import com.tricentis.demowebshop.utils.DriverFactory;
import com.tricentis.demowebshop.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest extends Core {
    protected final String BASE_URL = "https://demowebshop.tricentis.com/";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    @BeforeSuite
    public void registerUserOnce() {
        Reporter.log("Registering test user", true);
        WebDriver tempDriver = DriverFactory.createDriver("headless chrome");
        tempDriver.get(BASE_URL);
        new HomePage(tempDriver)
                .openRegisterPage()
                .registerNewUser(PropertyReader.getProperty("validGender"),
                        PropertyReader.getProperty("validFirstName"),
                        PropertyReader.getProperty("validLastName"),
                        PropertyReader.getProperty("validEmail"),
                        PropertyReader.getProperty("validPassword"));
        //Weryfikacja, czy użytkownik istnieje, czy został zarejestrowany poprawnie, czy wystąpił inny błąd
        boolean isAdded = tempDriver.getCurrentUrl().contains("/registerresult");
        boolean isError = tempDriver.findElements(By.cssSelector(".validation-summary-errors")).size() > 0;
        if (isAdded) {
            Reporter.log("User registered successfully", true);
        } else if (isError) {
            Reporter.log("User already exists", true);
        } else {
            Reporter.log("Other error occurred during registration", true);
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
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            String timestamp = LocalDateTime.now().format(DATE_FORMAT);
            String testName = result.getMethod().getMethodName();
            String screenshotName = result.getMethod().getMethodName() + "_" + timestamp + ".png";

            String screenshotPath = takeErrorScreenshot(screenshotName);
            String screenshotUri = Path.of(screenshotPath).toUri().toString();

            Reporter.log("Screenshot saved for failed test: " + testName, true);
            Reporter.log("Open screenshot: " + screenshotUri, true);
        }
        quitDriver();
    }
}

