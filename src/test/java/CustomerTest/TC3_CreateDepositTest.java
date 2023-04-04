package CustomerTest;

import BaseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TC3_CreateDepositTest extends BaseTest {

    final String FIRST_NAME = "Ivan";
    final String LAST_NAME = "Ivan";
    final String POST_CODE = Util.getDateAndTimeFormatted();
    final String CURRENCY = "Dollar";
    final String DEPOSIT = "1901";


    @Before
    public void Before(){
        loginPage.openLoginPage()
                .clickOnBankManagerLogin()
                .clickOnAddCustomer()
                .enterTextToFirstNameInput(FIRST_NAME)
                .enterTextToLastNameInput(LAST_NAME)
                .enterTextToPostCodeInput(POST_CODE)
                .clickOnAddCustomerSubmit()
                .clickOnCustomers()
                .enterTextInSearch(POST_CODE)
                .checkAccountWasCreated(POST_CODE);
        loginPage.openLoginPage()
                .clickOnBankManagerLogin()
                .clickOnOpenAccount()
                .selectNameOfCustomerInDD(FIRST_NAME)
                .selectCurrencyInDD(CURRENCY)
                .clickOnProcessButton();
    }


    @Test
    public void createDeposit(){
        loginPage.openLoginPage()
                .clickOnCustomerLoginButton()
                .selectCustomerNameFromDD(FIRST_NAME)
                .clickOnLogin()
                .clickOnDepositButton()
                .inputAmountOfDeposit(DEPOSIT)
                .clickOnDepositButton()
                .checkSuccessfulMessage()

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
