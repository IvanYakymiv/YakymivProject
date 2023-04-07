package CustomerTest;

import BaseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TC3_CreateDepositTest extends BaseTest {

    final String FIRST_NAME = "Ivan" + Util.getDateAndTimeFormatted();
    final String LAST_NAME = "Ivan";
    final String POST_CODE = Util.getDateAndTimeFormatted();
    final String CURRENCY = "Dollar";
    final String DEPOSIT = "1901";


    @Before
    public void Before() {
        createCustomer(FIRST_NAME, LAST_NAME, POST_CODE);
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

    @Test
    public void createDepositTest() throws InterruptedException {
        loginPage.openLoginPage()
                .clickOnCustomerLoginButton()
                .checkIsRedirectCustomerPage()
                .selectCustomerNameFromDD(FIRST_NAME)
                .clickOnLogin()
                .checkIsCustomerLogIn(FIRST_NAME, LAST_NAME)
                .getAccountHeaderElements().clickOnDepositButton()
                .inputAmountOfDeposit(DEPOSIT)
                .clickOnDepositSubmitButton()
                .checkSuccessfulMessage()
                .checkAccountBalance(DEPOSIT)
                .getAccountHeaderElements().clickOnTransactionButton()
                .checkIsRedirectTransactionPage()
                .checkTransactionData(DEPOSIT,"Credit")
        ;
    }


    @After
    public void After() {
        deleteCustomer(POST_CODE);
    }
}
