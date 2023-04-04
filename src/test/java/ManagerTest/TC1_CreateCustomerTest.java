package ManagerTest;

import BaseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Test;

public class TC1_CreateCustomerTest extends BaseTest {
    final String FIRST_NAME = "Ivan" + Util.getDateAndTimeFormatted();
    ;
    final String LAST_NAME = "Ivan";
    final String POST_CODE = Util.getDateAndTimeFormatted();


    @Test
    public void createCustomer() {
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
