package pages;

import libs.TestData;
import libs.Util;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='amount']")
    public WebElement amountInput;

    @FindBy(xpath = ".//button[@type='submit']")
    public WebElement depositButton;

    @FindBy(xpath = ".//span[text()='Deposit Successful']")
    public WebElement successfulMessage;

    public String accountData = ".//strong[@class='ng-binding']";


    @Override
    String getRelativeURL() {
        return "/account";
    }

    public DepositPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DepositPage inputAmountOfDeposit(String deposit) {
        enterTextToInput(amountInput, deposit);
        return this;
    }

    public DepositPage clickOnDepositSubmitButton() {
        clickOnElement(depositButton);
        TestData.date = Util.getFormattedDate();
        return this;
    }

    public DepositPage checkSuccessfulMessage() throws InterruptedException {
        Assert.assertTrue("Text in success message element: ", successfulMessage.isDisplayed());
        Thread.sleep(1000);
        //так як на цьому сайті немає ніякого лоадера, то прийшлось використати такий костиль у вигляді Thread.sleep
        // щоб дані на сторінці Transactions встигли з'явитись
        return this;
    }

    public DepositPage checkAccountBalance(String deposit) {
        Assert.assertEquals("Balance of customer account ", deposit, getAccountBalance());
        logger.info("Account Balance Equals Deposit");


        return this;
    }

    public String getAccountBalance() {
        return getDataFromSameXpathToStringArray(accountData)[1];
    }
}

