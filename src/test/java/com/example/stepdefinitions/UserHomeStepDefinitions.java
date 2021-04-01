package com.example.stepdefinitions;

import com.example.pageobjects.*;
import com.example.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserHomeStepDefinitions {
    private final UserHomePage userHomePage = new UserHomePage();
    private final HomePage homePage = new HomePage();
    private final CarModelPage carModelPage = new CarModelPage();
    private final PopularMakePage popularMakePage = new PopularMakePage();
    private final OverallRatingPage overallRatingPage = new OverallRatingPage();
    public String popularMakeDetails = null;

    @Given("^User is on the Home Page$")
    public void userIsOnTheHomePage() {
        Assert.assertTrue(userHomePage.verifyUserHomePageIsDisplayed());
    }

    @When("^All the links and details are displayed correctly$")
    public void allTheLinksAndDetailsAreDisplayedCorrectly() {
        Assert.assertTrue(homePage.verifyLinksDisplayedWithDetails());
        popularMakeDetails = homePage.getDetailsOfPopularMake();
    }

    @Then("^User clicks on \"([^\"]*)\"$")
    public void userClicksOn(String link) {
        homePage.clickOnLinkGivenByUser(link);
    }

    @And("Verifies the {string} page is loaded correctly")
    public void verifiesThePageIsLoadedCorrectly(String link) {
        switch (link.toUpperCase().replace(" ", "_")) {
            case Constants.POPULAR_MAKE_LINk:
                Assert.assertTrue(popularMakePage.verifyPopularMakePageIsDisplayed(popularMakeDetails));
                break;
            case Constants.POPULAR_MODEL_LINk:
                Assert.assertTrue(carModelPage.verifyPopularModelPageIsDisplayed());
                break;
            case Constants.OVERALL_RATING_LINK:
                Assert.assertTrue(overallRatingPage.verifyOverallRatingsPageIsDisplayed());
                break;
        }

    }
}
