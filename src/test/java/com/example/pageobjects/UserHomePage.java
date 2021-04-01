package com.example.pageobjects;

import com.example.utils.WebElementFunctions;
import org.openqa.selenium.By;

public class UserHomePage extends WebElementFunctions {
    /**
     * Locators will be mentioned here
     */
    private final By profileLink = By.xpath("//a[contains(text(),'Profile')]");

    private final By logoutLink = By.xpath("//a[contains(text(),'Logout')]");

    /**
     * All functions related to behavior will follow now
     */
    public boolean verifyUserHomePageIsDisplayed() {
        return elementIsPresent(profileLink);
    }

    public void clickOnLogoutLink(){
        clickOnElement(logoutLink);
    }

    public void clickOnProfileLink(){
        clickOnElement(profileLink);
    }
}
