package com.stepDefinitions.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.commonUtilities.BaseClass;
import utilities.commonUtilities.CommonUtilities;

public class stepDefinitions extends BaseClass {
    private static final Logger logger = LogManager.getLogger(stepDefinitions.class);
    CommonUtilities commonUtilities = new CommonUtilities();

    @Given("User opens {string} website")
    public void userOpensWebsite(String sURL) throws InterruptedException {
        commonUtilities.openLogin(sURL);
    }

    @Then("User verifies if homepage is opened or not with {string}")
    public void userVerifiesIfHomepageIsOpenedOrNotWith(String tabTitle) throws InterruptedException {
        commonUtilities.validateBrowserTabText(tabTitle);
    }

    @When("User click on {string} button")
    public void userClickOnButton(String sButtonName) {
        commonUtilities.clickButton(sButtonName);
    }

    @When("User enters value in {string} text field as {string}")
    public void userEntersAsTestExampleComInInputbox(String sTBName, String sValue) throws Throwable {
        commonUtilities.enterText(sTBName, sValue);// Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    }

    @Then("User verifies the {string} text is displayed")
    public void userVerifiesIfTextIsDisplayed(String text) throws InterruptedException {
        commonUtilities.validateText(text);
    }
}
