package com.stepDefinitions.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.commonUtilities.BaseClass;
import utilities.commonUtilities.CommonUtilities;

public class stepDefinitions extends BaseClass {

    CommonUtilities commonUtilities = new CommonUtilities();

    @Given("User opens {string} website")
    public void userOpensWebsite(String sURL) {
        commonUtilities.openLogin(sURL);
    }

    @When("User verifies if homepage is opened or not with {string}")
    public void userVerifiesIfHomepageIsOpenedOrNotWith(String tabTitle) {
        commonUtilities.validateText(tabTitle);
    }

    @Then("User enters {string} and {string} to login")
    public void userEntersAndToLogin(String arg0, String arg1) {
    }
}
