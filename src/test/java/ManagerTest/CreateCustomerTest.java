package ManagerTest;

import BaseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class CreateCustomerTest extends BaseTest {
    final String FIRST_NAME = "Ivan";
    final String LAST_NAME = "Ivan";
    final String POST_CODE = Util.getDateAndTimeFormatted();

    @Test
    public void createCustomer(){
        loginPage.openLoginPage()
                .clickOnBankManagerLogin()
                .clickOnAddCustomer()
                .enterTextToFirstNameInput(FIRST_NAME)
                .enterTextToLastNameInput(LAST_NAME)
                .enterTextToPostCodeInput(POST_CODE)
                .clickOnAddCustomer()


        ;

    }
}
