package com.example.pageobjects;

import com.example.utils.WebElementFunctions;
import org.openqa.selenium.By;

public class OverallRatingPage extends WebElementFunctions {
    /**
     * Locators will be mentioned here
     */
    private final By carsTable = By.xpath("//table[contains(@class,'cars')]");

    /**
     * All functions related to behavior will follow now
     */
    public boolean verifyOverallRatingsPageIsDisplayed() {
        return elementIsPresent(carsTable);
    }

    public void clickOnCar(String car){
        clickOnElementPassStringInXpath(car);
    }
}
