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
                .getAccountHeaderElements().clickOnWithdrawButton()
                .checkIsRedirectWithdrawPage()
                .inputErrorAmountOfWithdraw(DEPOSIT)
                .clickOnWithdrawSubmitButton()
                .checkErrorMessage()
                .inputAmountOfWithdraw(DEPOSIT)
                .clickOnWithdrawSubmitButton()
                .checkSuccessfulMessage()
                .getAccountHeaderElements().clickOnTransactionButton()
                .checkIsRedirectTransactionPage()
                .checkTransactionData(DEPOSIT, "Debit")
        ;
    }


    @After
    public void After() {
        deleteCustomer(POST_CODE);
    }

}
