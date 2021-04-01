package com.example.pageobjects;

import com.example.utils.WebElementFunctions;
import org.openqa.selenium.By;

public class PopularMakePage extends WebElementFunctions {
    /**
     * Locators will be mentioned here
     */
    private final By pageHeader = By.xpath("//*[@class='card-header']");
    /**
     * All functions related to behavior will follow now
     */
    public boolean verifyPopularMakePageIsDisplayed(String details) {
         return details.contains(getTextOfElement(pageHeader));
    }
}


