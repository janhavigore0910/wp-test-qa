package com.example.stepdefinitions;

import com.example.pageobjects.CarModelPage;
import com.example.pageobjects.OverallRatingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class VoteAndCommentStepDefinitions {

    private final OverallRatingPage overallRatingPage = new OverallRatingPage();
    private final CarModelPage carModelPage = new CarModelPage();

    String votesBefore = "";

    @When("^User selects buggy car \"([^\"]*)\"$")
    public void user_selects_buggy_car(String car){
        overallRatingPage.clickOnCar(car);
    }

    @And("^User enter comment \"([^\"]*)\"$")
    public void userEnterComment(String comment) {
        Assert.assertTrue(carModelPage.verifyPopularModelPageIsDisplayed());
        carModelPage.enterValueInComments(comment);
    }

    @And("^User clicks on vote$")
    public void userClicksOnVote() {
        votesBefore = carModelPage.getVotesCount();
        carModelPage.clickOnVoteButton();
    }

    @Then("User verifies the comment {string}")
    public void userVerifiesTheComment(String comment) {
        Assert.assertTrue(carModelPage.verifyCarVotesAfterUserHasVoted(votesBefore));
        Assert.assertTrue(carModelPage.verifyCommentAddedForTheProductByUser(comment));
    }

    @Then("^User verifies the vote$")
    public void userVerifiesTheVote() {
        Assert.assertTrue(carModelPage.verifyCarVotesAfterUserHasVoted(votesBefore));
    }
}
