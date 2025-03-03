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
    public void openLogin(String sURL) throws InterruptedException {
        if (driver != null) {
            driver.navigate().to(sURL);
            Thread.sleep(5000);
            logger.info("Navigating to...: " + sURL);
        } else {
            logger.error("Driver is not initialized");
        }
    }

    // Validate the title
    public void validateBrowserTabText(String tabTitle) throws InterruptedException {

        if (driver.getTitle().equalsIgnoreCase(tabTitle)) {
            logger.info("Page title is: " + driver.getTitle());
        } else {
            System.out.println(driver.getTitle());
            logger.info("Title mismatch. Expected: " + tabTitle + ", Found: " + driver.getTitle());
        }
    }

    public void enterText(String stextBoxName, String sText) {
        WebElement inputField = driver.findElement(By.xpath("//input[@name='" + stextBoxName + "' or text()='" + stextBoxName + "']"));
        inputField.sendKeys(sText);
    }

    public void clickButton(String sbuttonName) {
        WebElement loginButton = driver.findElement(By.xpath("//*[@value='" + sbuttonName + "' or text()='" + sbuttonName + "']"));
        Assert.assertTrue(loginButton.isDisplayed());
        loginButton = driver.findElement(By.xpath("//*[@value='" + sbuttonName + "' or text()='" + sbuttonName + "']"));
        loginButton.click();
    }

    public void validateText(String text) throws InterruptedException {

        WebElement w = driver.findElement(By.xpath("//h1[text()='Error!']/following-sibling::p"));
        String errorText = w.getText();
        WebElement textArea = driver.findElement(By.xpath("//*[text()='" + errorText + "']"));
        if (textArea.isDisplayed()) {
            logger.info("Text " + text + " is displayed as expected");
            Assert.assertEquals(errorText, text);
        } else {
            logger.info("Text " + text + " is not displayed");
        }
    }
}
