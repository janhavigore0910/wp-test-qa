package com.example.pageobjects;

import com.example.utils.WebElementFunctions;
import com.example.utils.Constants;
import org.openqa.selenium.By;

public class HomePage extends WebElementFunctions {
    /**
     * Locators will be mentioned here
     */
    private final By loginButton = By.xpath("//button[contains(text(),'Login')]");

    private final By loginInput = By.name("login");

    private final By passwordInput = By.name("password");

    private final By popularMakeLink = By.xpath("//*[contains(text(),'Popular Make')]/parent::div//a");

    private final By popularModelLink = By.xpath("//*[contains(text(),'Popular Model')]/parent::div//a");

    private final By overallRating = By.xpath("//*[contains(text(),'Overall Rating')]/parent::div//a");

    private final By overallRatingDetails = By.xpath("//*[contains(text(),'Overall Rating')]/parent::" +
            "div//div[@class='card-block']//h3");

    private final By popularMakeDetails = By.xpath("//*[contains(text(),'Popular Model')]/parent::" +
            "div//div[@class='card-block']//h3");

    private final By popularModelDetails = By.xpath("//*[contains(text(),'Popular Make')]/parent::" +
            "div//div[@class='card-block']//h3");

    /**
     * All functions related to behavior will follow now
     */
    public boolean verifyHomePageIsDisplayed() {
        return elementIsPresent(loginButton);
    }

    public void enterLoginName(String login) {
        sendKeysForElement(loginInput, login);
    }

    public void enterPassword(String password) {
        sendKeysForElement(passwordInput, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public void clickOnPopularMakeLink() {
        clickOnElement(popularMakeLink);
    }

    public void clickOnPopularModelLink() {
        clickOnElement(popularModelLink);
    }

    public void clickOnOverallRatingLink() {
        clickOnElement(overallRating);
    }

    public boolean verifyLinksDisplayedWithDetails(){
        boolean linkResult = elementIsPresent(popularMakeLink) && elementIsPresent(popularModelLink)
                && elementIsPresent(overallRating);
        boolean linkDetails = elementIsPresent(popularMakeDetails) && elementIsPresent(popularModelDetails)
                && elementIsPresent(overallRatingDetails);

        return linkDetails && linkResult;
    }

    public void clickOnLinkGivenByUser(String link){
        switch (link.toUpperCase().replace(" ", "_")) {
            case Constants.POPULAR_MAKE_LINk:
                clickOnPopularMakeLink();
                break;
            case Constants.POPULAR_MODEL_LINk:
                clickOnPopularModelLink();
                break;
            case Constants.OVERALL_RATING_LINK:
                clickOnOverallRatingLink();
                break;
        }
    }

    public String getDetailsOfPopularMake(){
        return getTextOfElement(popularMakeDetails);
    }
}