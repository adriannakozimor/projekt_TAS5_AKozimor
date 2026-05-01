package com.tricentis.demowebshop.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Core;
import utils.DriverFactory;

import java.time.Duration;

public class BaseTest extends Core {
    protected final String BASE_URL = "https://demowebshop.tricentis.com/";

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

