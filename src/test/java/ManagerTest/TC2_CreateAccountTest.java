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
        loginPage.openLoginPage()
                .clickOnBankManagerLogin()
                .checkIsRedirectManagerPage()
                .clickOnAddCustomer()
                .checkIsRedirectAddCustomerPage()
                .enterTextToFirstNameInput(FIRST_NAME)
                .enterTextToLastNameInput(LAST_NAME)
                .enterTextToPostCodeInput(POST_CODE)
                .clickOnAddCustomerSubmit()
                .clickOnCustomers()
                .checkIsRedirectCustomersPage()
                .enterTextInSearch(POST_CODE)
                .checkCustomerWasCreated(POST_CODE);
    }

    @Test
    public void createAccount() {
        loginPage.openLoginPage()
                .clickOnBankManagerLogin()
                .checkIsRedirectManagerPage()
                .clickOnOpenAccount()
                .checkIsRedirectOpenAccountPage()
                .selectNameOfCustomerInDD(FIRST_NAME)
                .selectCurrencyInDD(CURRENCY)
                .clickOnProcessButton()
                .clickOnCustomers()
                .enterTextInSearch(POST_CODE)
                .checkAccountWasCreated(FIRST_NAME);
    }

    @After
    public void After() {
        loginPage.openLoginPage()
                .clickOnBankManagerLogin()
                .checkIsRedirectManagerPage()
                .clickOnCustomers()
                .checkIsRedirectCustomersPage()
                .enterTextInSearch(POST_CODE)
                .deleteAccountWithPostCode(POST_CODE)
                .checkCustomerWasDeleted(POST_CODE);
    }
}

