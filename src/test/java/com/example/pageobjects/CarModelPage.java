package com.example.pageobjects;

import com.example.utils.WebElementFunctions;
import org.openqa.selenium.By;

public class CarModelPage extends WebElementFunctions {
    /**
     * Locators will be mentioned here
     */
    private final By specificationLabel = By.xpath("//*[contains(text(),'Specification')]");

    private final By commentsSection = By.id("comment");

    private final By voteButton = By.xpath("//button[contains(text(),'Vote')]");

    private final By profileNameLabel = By.xpath("//li[contains(@class,'nav-item')]/span");

    private final By votesLabel = By.xpath("//*[contains(text(),'Votes')]//strong");

    private final By thankYouLabel = By.xpath("//p[contains(text(),'Thank you')]");

    /**
     * All functions related to behavior will follow now
     */
    public boolean verifyPopularModelPageIsDisplayed() {
        return elementIsPresent(specificationLabel);
    }

    public void enterValueInComments(String comment){
        sendKeysForElement(commentsSection,comment);
    }

    public void clickOnVoteButton(){
        clickOnElement(voteButton);
        elementIsPresent(thankYouLabel);
    }

    public boolean verifyCommentAddedForTheProductByUser(String comment){
        String profileName = getTextOfElement(profileNameLabel);
        return verifyDetailsInTable(profileName.substring(4,profileName.length()),comment);
    }

    public String getVotesCount(){
        return getTextOfElement(votesLabel);
    }

    public boolean verifyCarVotesAfterUserHasVoted(String votes){
        String votesAfter = getTextOfElement(votesLabel);
        return (Integer.parseInt(votesAfter) == (Integer.parseInt(votes) + 1));
    }
}
