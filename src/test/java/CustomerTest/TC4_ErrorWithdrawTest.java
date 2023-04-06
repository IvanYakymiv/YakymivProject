package CustomerTest;

import BaseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TC4_ErrorWithdrawTest extends BaseTest {

    final String FIRST_NAME = "Ivan" + Util.getDateAndTimeFormatted();
    final String LAST_NAME = "Ivan";
    final String POST_CODE = Util.getDateAndTimeFormatted();
    final String CURRENCY = "Dollar";
    final String DEPOSIT = "1901";


    @Before
    public void Before() throws InterruptedException {
        createCustomer(FIRST_NAME, LAST_NAME, POST_CODE);
        createAccount(FIRST_NAME, CURRENCY, POST_CODE);
        loginPage.openLoginPage()
                .clickOnCustomerLoginButton()
                .checkIsRedirectCustomerPage()
                .selectCustomerNameFromDD(FIRST_NAME)
                .clickOnLogin()
                .checkIsCustomerLogIn(FIRST_NAME, LAST_NAME)
                .clickOnDepositButton()
                .inputAmountOfDeposit(DEPOSIT)
                .clickOnDepositButton()
                .checkSuccessfulMessage()
                .checkAccountBalance(DEPOSIT)
                .clickOnTransactionButton()
                .checkIsRedirectTransactionPage()
                .checkTransactionData(DEPOSIT, "Credit")
                ;
    }


    @Test
    public void errorWithdrawTest() throws InterruptedException {
        loginPage.openLoginPage()
                .clickOnCustomerLoginButton()
                .checkIsRedirectCustomerPage()
                .selectCustomerNameFromDD(FIRST_NAME)
                .clickOnLogin()
                .checkIsCustomerLogIn(FIRST_NAME, LAST_NAME)
                .clickOnWithdrawButton()
                .checkIsRedirectWithdrawlPage()
                .inputErrorAmountOfWithdraw(DEPOSIT)
                .clickOnWithdrawButton()
                .checkErrorMessage()
                .inputAmountOfWithdraw(DEPOSIT)
                .clickOnWithdrawButton()
                .checkSuccessfulMessage()
                .clickOnTransactionButton()
                .checkIsRedirectTransactionPage()
                .checkTransactionData(DEPOSIT, "Debit")
        ;
    }


    @After
    public void After() {
        deleteCustomer(POST_CODE);
    }

}
