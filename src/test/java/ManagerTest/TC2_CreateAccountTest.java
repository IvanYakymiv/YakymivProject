package ManagerTest;

import BaseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TC2_CreateAccountTest extends BaseTest {

    final String FIRST_NAME = "Ivan" + Util.getDateAndTimeFormatted();
    final String LAST_NAME = "Ivan";
    final String POST_CODE = Util.getDateAndTimeFormatted();
    final String CURRENCY = "Dollar";


    @Before
    public void Before() {
        createCustomer(FIRST_NAME, LAST_NAME, POST_CODE);
    }

    @Test
    public void createAccountTest() {
        loginPage.openLoginPage()
                .clickOnBankManagerLogin()
                .checkIsRedirectManagerPage()
                .getManagerHeaderElements().clickOnOpenAccount()
                .checkIsRedirectOpenAccountPage()
                .selectNameOfCustomerInDD(FIRST_NAME)
                .selectCurrencyInDD(CURRENCY)
                .clickOnProcessButton()
                .getManagerHeaderElements().clickOnCustomers()
                .enterTextInSearch(POST_CODE)
                .checkNumberOfAccountWasCreated(FIRST_NAME,1);
    }

    @After
    public void After() {
        deleteCustomer(POST_CODE);
    }
}

