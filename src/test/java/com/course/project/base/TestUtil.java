package com.course.project.base;

import com.course.project.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {
    public WebDriver driver;
    private String url;
    private int implicitWait;
    private String browser;


    @BeforeSuite
    public void readConfigProperties() {
        try (FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void setUp() {
        setUpBrowserDriver();
        loadUrl();
    }

    private void loadUrl() {

        driver.get(url);
    }

    private void setUpBrowserDriver() {
        switch (browser) {
            case "chrome":
                driver = DriverFactory.getChromeDriver(implicitWait);
                break;
            case "firefox":
                driver = DriverFactory.getFirefoxDriver(implicitWait);
                break;
            default:
                throw new IllegalStateException("Unsupported browser");
        }
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}

