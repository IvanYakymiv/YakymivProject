package CustomerTest;

import BaseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TC5_WithdrawFormAllAccountsTest extends BaseTest {

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
                .clickOnOpenAccount()
                .checkIsRedirectOpenAccountPage()
                .selectNameOfCustomerInDD(FIRST_NAME)
                .selectCurrencyInDD("Dollar")
                .clickOnProcessButton()
                .selectNameOfCustomerInDD(FIRST_NAME)
                .selectCurrencyInDD("Pound")
                .clickOnProcessButton()
                .selectNameOfCustomerInDD(FIRST_NAME)
                .selectCurrencyInDD("Rupee")
                .clickOnProcessButton()
                .clickOnCustomers()
                .enterTextInSearch(POST_CODE)
                .checkThreeAccountWasCreated(FIRST_NAME);
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
                .checkTransactionData(DEPOSIT,"Credit")
                .clickOnBack()
                .selectNextAccountInDD()
                .checkChangingAccount("Pound")
                .clickOnDepositButton()
                .inputAmountOfDeposit(DEPOSIT)
                .clickOnDepositButton()
                .checkSuccessfulMessage()
                .clickOnTransactionButton()
                .clickOnBack()
                .selectNextAccountInDD()
                .checkChangingAccount("Rupee")
                .clickOnDepositButton()
                .inputAmountOfDeposit(DEPOSIT)
                .clickOnDepositButton()
                .checkSuccessfulMessage()
                .clickOnTransactionButton()
                .clickOnBack();
                ;
    }

    @Test
    public void withdrawFormAllAccountsTest() throws InterruptedException {
        loginPage.openLoginPage()
                .clickOnCustomerLoginButton()
                .checkIsRedirectCustomerPage()
                .selectCustomerNameFromDD(FIRST_NAME)
                .clickOnLogin()
                .checkIsCustomerLogIn(FIRST_NAME, LAST_NAME)
                .clickOnWithdrawButton()
                .checkIsRedirectWithdrawlPage()
                .inputAmountOfWithdraw(DEPOSIT)
                .clickOnWithdrawButton()
                .checkSuccessfulMessage()
                .clickOnTransactionButton()//todo
                .clickOnBack()
                .selectNextAccountInDD()
                .checkChangingAccount("Pound")
                .clickOnWithdrawButton()
                .checkIsRedirectWithdrawlPage()
                .inputAmountOfWithdraw(DEPOSIT)
                .clickOnWithdrawButton()
                .checkSuccessfulMessage()
                .clickOnTransactionButton()//todo
                .clickOnBack()
                .selectNextAccountInDD()
                .checkChangingAccount("Rupee")
                .clickOnWithdrawButton()
                .checkIsRedirectWithdrawlPage()
                .inputAmountOfWithdraw(DEPOSIT)
                .clickOnWithdrawButton()
                .checkSuccessfulMessage()
                .clickOnTransactionButton()//todo
                .clickOnBack()
                ;

    }


    @After
    public void After() {
        deleteCustomer(POST_CODE);
    }
}
