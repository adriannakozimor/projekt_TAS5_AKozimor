package com.tricentis.demowebshop.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Core {
    protected WebDriver driver;

    protected void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    protected String takeErrorScreenshot(String fileName) {
        String screenshotPath = Path.of(ConfigPath.IMAGE_ERROR_PATH, fileName).toString();
        saveScreenshot(driver, screenshotPath);
        return screenshotPath;
    }

    private void saveScreenshot(WebDriver activeDriver, String path) {
        if (activeDriver == null) {
            return;
        }

        File destination = new File(path);
        File parent = destination.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }

        try {
            File source = ((TakesScreenshot) activeDriver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source, destination);
        } catch (IOException ex) {
            Reporter.log(ex.getMessage(), true);
        }
    }
}
