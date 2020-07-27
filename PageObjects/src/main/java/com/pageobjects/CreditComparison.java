package com.pageobjects;

import com.testFramework.core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreditComparison extends BasePage {

    String url = "https://kredit.check24.de/vergleich";

    @FindBy(how = How.CSS, using = ".howMuch > input")
    public WebElement howMuchTxt;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'calculator')]/div")
    public WebElement infoEntered;

    @FindBy(how = How.ID, using = "duration")
    public WebElement durationDrop;

    @FindBy(how = How.ID, using = "purpose")
    public WebElement purposeDrop;

    @FindBy(how = How.CSS, using = ".howLong .ng-star-inserted:nth-child(4)")
    public WebElement duration36Months;

    @FindBy(how = How.CSS, using = ".forWhat .ng-star-inserted:nth-child(10)")
    public WebElement purposeTravel;

    @FindBy(how = How.CSS, using = ".openFilter")
    public WebElement filterLnk;

    @FindBy(how = How.CSS, using = ".ng-tns-c28-1:nth-child(1) > .ng-tns-c28-1 > .radio > .radioText")
    public WebElement filterCHECK24;

    @FindBy(how = How.CSS, using = ".ng-tns-c28-1:nth-child(2) > .ng-tns-c28-1 > .radio > .box")
    public WebElement filterAllBank;

    @FindBy(how = How.CSS, using = ".openSort")
    public WebElement sortLnk;

    @FindBy(how = How.CSS, using = ".ng-tns-c28-1:nth-child(1) > .ng-star-inserted:nth-child(1) > .ng-tns-c28-1 > .ng-tns-c28-1")
    public WebElement sortLowestAPR;

    @FindBy(how = How.CSS, using = ".ng-tns-c28-1 > .ng-star-inserted:nth-child(2) > .ng-tns-c28-1 > .ng-tns-c28-1")
    public WebElement sortLowestMonthlyRate;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'productDetails underline ng-tns-c50-0 ng-star-inserted')]")
    public WebElement creditDetails;

    @FindBy(how = How.XPATH, using = "//div[@id='c24-content']/div/app-comparison/div[2]/div/app-results/section/app-products/div/app-product-details/div/div/ul/li[2]")
    public WebElement conditionOverview;

    @FindBy(how = How.CSS, using = ".row:nth-child(1) > div:nth-child(4)")
    public WebElement creditAmount;

    @FindBy(how = How.CSS, using = ".row:nth-child(3) > div:nth-child(4)")
    public WebElement creditDuration;

    @FindBy(how = How.CSS, using = ".productDetailsTab > .ng-tns-c48-5 > .ng-tns-c48-5:nth-child(3)")
    public WebElement creditTime;


    public CreditComparison(WebDriver driver) {
        super(driver);
    }

    public void openCreditComparison() {
        myDriver.get(url);
    }

    public void enterAmount(String amount) {
        waitForElementToBePresent(howMuchTxt);
        howMuchTxt.click();
        howMuchTxt.sendKeys(amount);
    }

    public String getAmountEntered() {
        waitForElementToBePresent(howMuchTxt);
        return howMuchTxt.getAttribute("value");
    }

    public String getDurationEntered() {
        waitForElementToBePresent(infoEntered);
        return infoEntered.getText().substring(61, 70);
    }

    public void selectDuration(WebElement opt) {
        waitForElementToBeLoaded(durationDrop);
        durationDrop.click();
        waitForElementToBePresent(opt);
        opt.click();
    }

    public void selectPurpose(WebElement opt) {
        waitForElementToBeLoaded(purposeDrop);
        purposeDrop.click();
        waitForElementToBePresent(opt);
        opt.click();
    }

    public void selectFilter(WebElement opt) {
        waitForElementToBeLoaded(filterLnk);
        filterLnk.click();
        waitForElementToBePresent(opt);
        opt.click();
    }

    public void selectSort(WebElement opt) {
        waitForElementToBeLoaded(sortLnk);
        sortLnk.click();
        waitForElementToBePresent(opt);
        opt.click();
    }

    public void clickCreditDetails() {
        waitForElementToBeLoaded(creditDetails);
        JavascriptExecutor executor = (JavascriptExecutor) myDriver;
        executor.executeScript("arguments[0].click();", creditDetails);
    }

    public void clickConditionOverview() {
        waitForElementToBeLoaded(conditionOverview);
        conditionOverview.click();
    }

    public String getAmountDetail() {
        waitForElementToBePresent(creditAmount);
        String amountResult = creditAmount.getText();
        int index = amountResult.indexOf(",");
        amountResult = amountResult.substring(0, index);
        return amountResult;
    }

    public String getDurationDetail() {
        waitForElementToBePresent(creditDuration);
        return creditDuration.getText();
    }

    public void isTheDurationDisplayedCorrect() {
        assert getDurationEntered().equals(getDurationDetail());
    }

    public void isTheAmountDisplayedCorrect() {
        assert getAmountEntered().equals(getAmountDetail());
    }

}