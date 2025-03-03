package utilities.commonUtilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.stepDefinitions.Hooks.hooks.driver;

public class CommonUtilities {
    private static final Logger logger = LogManager.getLogger(CommonUtilities.class);

    // Open the login URL
    public void openLogin(String sURL) {
        if (driver != null) {
            driver.get(sURL);
            logger.info("Navigating to...: " + sURL);
        } else {
            logger.error("Driver is not initialized");
        }
    }

    // Validate the title and interact with the 'Sign in with Google' button
    public void validateText(String tabTitle) {
        try {
            WebElement loginButton = driver.findElement(By.xpath("//div[text()='Sign in with Google']"));
            Assert.assertTrue(loginButton.isDisplayed());
            if (driver.getTitle().equalsIgnoreCase(tabTitle)) {
                logger.info("Page title is: " + driver.getTitle());
            } else {
                logger.warn("Title mismatch. Expected: " + tabTitle + ", Found: " + driver.getTitle());
            }

            loginButton = driver.findElement(By.xpath("//div[text()='Sign in with Google']"));
            loginButton.click();
        } catch (Exception e) {
            logger.error("Error during validateText: " + e.getMessage());
        }
    }

    // Empty method - might want to implement functionality or remove it
    public void enterText(String text) {
        // Example implementation:
        // WebElement inputField = driver.findElement(By.id("someFieldId"));
        // inputField.sendKeys(text);
    }
}
