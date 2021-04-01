package com.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

public class WebElementFunctions extends DriverFactory{

    public void clickOnElement(By webElement){
        waitVar.until(ExpectedConditions.elementToBeClickable(webElement));
        scrollDownAction(webElement);
        driver.findElement(webElement).click();
    }

    public boolean elementIsPresent(By webElement){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(webElement));
        return driver.findElement(webElement).isDisplayed();
    }

    public String getTextOfElement(By webElement){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(webElement));
        return driver.findElement(webElement).getText();
    }

    public void sendKeysForElement(By webElement,String value){
        waitVar.until(ExpectedConditions.presenceOfElementLocated(webElement));
        driver.findElement(webElement).sendKeys(value);
    }

    public void scrollDownAction(By webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(webElement));
    }

    public void clickOnElementPassStringInXpath(String value){
        String xpath = "//a[contains(text(),'"+value+"')]/parent::td/parent::tr//td[7]//a";
        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean verifyDetailsInTable(String author, String comment){

        String xpathForRowsInTable = "//table//tbody//tr";
        String xpathForAuthorInTable = "";
        String xpathForCommentInTable = "";

        String authorValue = "";
        String commentValue = "";

        boolean authorResult = false;
        boolean commentResult = false;

        boolean result = false;

        int rows = driver.findElements(By.xpath(xpathForRowsInTable)).size();

        for(int rowCount = 1; rowCount < rows; rowCount++){
            xpathForAuthorInTable = "//table//tbody//tr[" + rowCount +"]//td[2]";
            xpathForCommentInTable = "//table//tbody//tr[" + rowCount +"]//td[3]";
            
            waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathForAuthorInTable)));
            authorValue = driver.findElement(By.xpath(xpathForAuthorInTable)).getText();
            commentValue = driver.findElement(By.xpath(xpathForCommentInTable)).getText();

            authorResult = authorValue.toUpperCase().replace(" ","").
                    contains(author.toUpperCase().
                    replace(" ",""));
            commentResult = commentValue.toUpperCase().replace(" ","").
                    equals(comment.toUpperCase().
                    replace(" ",""));


            if(authorResult && commentResult){
                result = true;
                break;
            }

        }
        return result;
    }
}
