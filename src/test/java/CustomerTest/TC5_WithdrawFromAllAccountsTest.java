package CustomerTest;

import BaseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TC5_WithdrawFromAllAccountsTest extends BaseTest {

    final String FIRST_NAME = "Ivan" + Util.getDateAndTimeFormatted();
    final String LAST_NAME = "Ivan";
    final String POST_CODE = Util.getDateAndTimeFormatted();
    final String DEPOSIT = "1901"; //todo


    @Before
    public void Before() throws InterruptedException {
        createCustomer(FIRST_NAME, LAST_NAME, POST_CODE);
        loginPage.openLoginPage()
                .clickOnBankManagerLogin()
                .checkIsRedirectManagerPage()
                .getManagerHeaderElements().clickOnOpenAccount()
                .checkIsRedirectOpenAccountPage()
                .selectNameOfCustomerInDD(FIRST_NAME)
                .selectCurrencyInDD("Dollar")
                .clickOnProcessButton()
                // create first account
                .selectNameOfCustomerInDD(FIRST_NAME)
                .selectCurrencyInDD("Pound")
                .clickOnProcessButton()
                // create second account
                .selectNameOfCustomerInDD(FIRST_NAME)
                .selectCurrencyInDD("Rupee")
                .clickOnProcessButton()
                // create third account
                .getManagerHeaderElements().clickOnCustomers()
                .enterTextInSearch(POST_CODE)
                .checkNumberOfAccountWasCreated(FIRST_NAME, 3);

        loginPage.openLoginPage()
                .clickOnCustomerLoginButton()
                .checkIsRedirectCustomerPage()
                .selectCustomerNameFromDD(FIRST_NAME)
                .clickOnLogin()
                .checkAccountCurrency("Dollar")
                .getAccountHeaderElements().clickOnDepositButton()
                .inputAmountOfDeposit(DEPOSIT)
                .clickOnDepositSubmitButton()
                .checkSuccessfulMessage()
                .getAccountHeaderElements().clickOnTransactionButton()
                .checkIsRedirectTransactionPage()
                .checkTransactionData(DEPOSIT, "Credit")
                .clickOnBack()
                // first deposit to account
                .getAccountHeaderElements().selectNextAccountInDD()
                .checkAccountCurrency("Pound")
                .getAccountHeaderElements().clickOnDepositButton()
                .inputAmountOfDeposit(DEPOSIT)
                .clickOnDepositSubmitButton()
                .checkSuccessfulMessage()
                .getAccountHeaderElements().clickOnTransactionButton()
                .checkIsRedirectTransactionPage()
                .checkTransactionData(DEPOSIT, "Credit")
                .clickOnBack()
                // second deposit to account
                .getAccountHeaderElements().selectNextAccountInDD()
                .checkAccountCurrency("Rupee")
                .getAccountHeaderElements().clickOnDepositButton()
                .inputAmountOfDeposit(DEPOSIT)
                .clickOnDepositSubmitButton()
                .checkSuccessfulMessage()
                .getAccountHeaderElements().clickOnTransactionButton()
                .checkIsRedirectTransactionPage()
                .checkTransactionData(DEPOSIT, "Credit")
        // third deposit to account
        ;
    }

    @Test
    public void withdrawFromAllAccountsTest() throws InterruptedException {
        loginPage.openLoginPage()
                .clickOnCustomerLoginButton()
                .checkIsRedirectCustomerPage()
                .selectCustomerNameFromDD(FIRST_NAME)
                .clickOnLogin()
                .checkIsCustomerLogIn(FIRST_NAME, LAST_NAME)

                .checkAccountCurrency("Dollar")
                .getAccountHeaderElements().clickOnWithdrawButton()
                .checkIsRedirectWithdrawPage()
                .inputAmountOfWithdraw(DEPOSIT)
                .clickOnWithdrawSubmitButton()
                .checkSuccessfulMessage()
                .getAccountHeaderElements().clickOnTransactionButton()
                .checkIsRedirectTransactionPage()
                .checkTransactionData(DEPOSIT, "Debit")
                .clickOnBack()

                .getAccountHeaderElements().selectNextAccountInDD()

                .checkAccountCurrency("Pound")
                .getAccountHeaderElements().clickOnWithdrawButton()
                .checkIsRedirectWithdrawPage()
                .inputAmountOfWithdraw(DEPOSIT)
                .clickOnWithdrawSubmitButton()
                .checkSuccessfulMessage()
                .getAccountHeaderElements().clickOnTransactionButton()
                .checkIsRedirectTransactionPage()
                .checkTransactionData(DEPOSIT, "Debit")
                .clickOnBack()

                .getAccountHeaderElements().selectNextAccountInDD()

                .checkAccountCurrency("Rupee")
                .getAccountHeaderElements().clickOnWithdrawButton()
                .checkIsRedirectWithdrawPage()
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
