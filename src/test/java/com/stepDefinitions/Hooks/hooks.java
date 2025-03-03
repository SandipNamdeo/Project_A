package com.stepDefinitions.Hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utilities.commonUtilities.CommonUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class hooks {

    private static final Logger logger = LogManager.getLogger(hooks.class);

    // Static WebDriver instance
    public static WebDriver driver;

    // This will run before the test class starts
    @BeforeAll
    public static void BeforeAll() throws FileNotFoundException {

        try {
            Properties properties = new Properties();
            FileInputStream propertyFile = new FileInputStream("./src/test/resources/config.properties");
            properties.load(propertyFile);
            String sBrowser = properties.getProperty("browser");
            String sUserName = properties.getProperty("username");
            String sPwd = properties.getProperty("password");


            System.out.println("Setting up WebDriver for ...." + sBrowser);
            switch (sBrowser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();  // Automatically downloads the ChromeDriver
                    ChromeOptions options = new ChromeOptions();
                    driver = new ChromeDriver(options);
//                    driver = new ChromeDriver();  // Initialize ChromeDriver
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();  // Automatically downloads the ChromeDriver
                    driver = new FirefoxDriver();  // Initialize ChromeDriver
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();  // Automatically downloads the ChromeDriver
                    driver = new EdgeDriver();  // Initialize ChromeDriver
                    break;
                case "internetexplorer":
                    WebDriverManager.iedriver().setup();  // Automatically downloads the ChromeDriver
                    driver = new InternetExplorerDriver();  // Initialize ChromeDriver
                    break;
                default:
                    WebDriverManager.chromedriver().setup();  // Automatically downloads the ChromeDriver
                    driver = new ChromeDriver();  // Initialize ChromeDriver
                    break;
            }
            driver.manage().window().maximize();
            System.out.println("WebDriver is set up and maximized.");
        } catch (IOException e) {
            logger.info(e);
        }
    }

    // This will run after all tests are completed in the class
    @AfterAll
    public static void AfterAll() {
        if (driver != null) {
            driver.quit();  // Quit the WebDriver instance
            driver = null;  // Nullify the driver after quitting
            System.out.println("WebDriver is quit.");
        }
    }
}
