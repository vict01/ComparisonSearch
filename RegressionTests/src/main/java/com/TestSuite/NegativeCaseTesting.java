package com.TestSuite;

import com.pageobjects.CreditComparison;
import com.testFramework.core.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class NegativeCaseTesting extends BaseTest {

    CreditComparison creditComparison;

    @Before
    public void prepare() {
        creditComparison = new CreditComparison(getDriver());
        maximiseWindow(getDriver());
    }

    @Test()
    public void doComparisonSearchWithAmountInBlank() {
        creditComparison.openCreditComparison();
        creditComparison.enterAmount("");
        creditComparison.selectDuration(creditComparison.duration36Months);
        creditComparison.selectPurpose(creditComparison.purposeTravel);
        creditComparison.selectFilter(creditComparison.filterAllBank);
        creditComparison.selectSort(creditComparison.sortLowestMonthlyRate);
    }

}
