package com.TestSuite;

import com.pageobjects.CreditComparison;
import com.testFramework.core.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class HappyPathTesting extends BaseTest {

    CreditComparison creditComparison;

    @Before
    public void prepare() {
        creditComparison = new CreditComparison(getDriver());
        maximiseWindow(getDriver());
    }

    @Test()
    public void doComparisonSearch() {
        creditComparison.openCreditComparison();
        creditComparison.enterAmount("350");
        creditComparison.selectDuration(creditComparison.duration36Months);
        creditComparison.selectPurpose(creditComparison.purposeTravel);
        creditComparison.selectFilter(creditComparison.filterAllBank);
        creditComparison.selectSort(creditComparison.sortLowestMonthlyRate);
    }

    @Test()
    public void validateSearchResult() {
        creditComparison.openCreditComparison();
        creditComparison.clickCreditDetails();
        creditComparison.clickConditionOverview();
        creditComparison.isTheDurationDisplayedCorrect();
        creditComparison.isTheAmountDisplayedCorrect();
    }

}
