package com.example.stepdefinitions;

import com.example.ConfigFileReader;
import com.example.pageobjects.HomePage;
import com.example.pageobjects.UserHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginLogoutStepDefinitions {

    private final HomePage homePage = new HomePage();
    private final UserHomePage userHomePage = new UserHomePage();
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Given("^Buggy Cars Rating Home Page is visible to user$")
    public void buggy_cars_rating_home_page_is_visible_to_user(){
        Assert.assertTrue(homePage.verifyHomePageIsDisplayed());
    }

    @When("^User submits Username and password$")
    public void userSubmitsUsernameAndPassword() {
        homePage.enterLoginName(configFileReader.getUsername());
        homePage.enterPassword(configFileReader.getPassword());
        homePage.clickOnLoginButton();
    }

    @Then("^User should be logged in$")
    public void userShouldBeLoggedIn() {
        Assert.assertTrue(userHomePage.verifyUserHomePageIsDisplayed());
    }

    @And("^User should logout$")
    public void userShouldLogout() {
        userHomePage.clickOnLogoutLink();
    }
}
