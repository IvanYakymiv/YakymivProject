package ManagerTest;

import BaseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TC2_CreateAccountTest extends BaseTest {

    final String FIRST_NAME = "Ivan";
    final String LAST_NAME = "Ivan";
    final String POST_CODE = Util.getDateAndTimeFormatted();
    final String CURRENCY = "Dollar";


    @Before
    public void Before() {
        loginPage.openLoginPage()
                .clickOnBankManagerLogin()
                .clickOnAddCustomer()
                .enterTextToFirstNameInput(FIRST_NAME)
                .enterTextToLastNameInput(LAST_NAME)
                .enterTextToPostCodeInput(POST_CODE)
                .clickOnAddCustomer()
                .clickOnCustomers()
                .enterTextInSearch(POST_CODE)
                .checkAccountWasCreated(POST_CODE)
//                .getTextFromAlert()
        ;

    }

    @Test
    public void createAccount(){
        loginPage.openLoginPage()
                .clickOnBankManagerLogin()
                .clickOnOpenAccount()
                .selectNameOfCustomerInDD(FIRST_NAME)
                .selectCurrencyInDD(CURRENCY)
                .clickOnProcessButton()

                ;


    }

    @After
    public void After() {
        loginPage.openLoginPage()
                .clickOnBankManagerLogin()
                .clickOnAddCustomer()
                .clickOnCustomers()
                .enterTextInSearch(POST_CODE)
                .deleteAccountWithPostCode(POST_CODE);
    }
}

