package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DepositPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='amount']")
    public WebElement amountInput;

    @FindBy(xpath = ".//button[@type='submit']")
    public WebElement depositButton;

    @FindBy(xpath = ".//span[text()='Deposit Successful']")
    public WebElement successfulMessage;

    @FindBy(xpath = ".//button[@ng-click='transactions()']")
    public WebElement transactionButton;

    public String depositData = ".//strong[@class='ng-binding']";

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

    public DepositPage clickOnDepositButton() {
        clickOnElement(depositButton);
        return this;
    }

    public DepositPage checkSuccessfulMessage() {
        Assert.assertTrue("Text in success message element", successfulMessage.isDisplayed());
        return this;
    }

    public DepositPage checkAccountBalance(String deposit) throws InterruptedException {
        Assert.assertEquals("Balance of customer account ", deposit, getAccountBalance());
        logger.info("Account Balance Equals Deposit");
        Thread.sleep(1000);
        //ToDo
        return this;
    }

    public String[] getDataFromDepositHeader() {
        List<WebElement> values = webDriver.findElements(By.xpath(depositData));
        String[] arrayDataOfDeposit = new String[values.size()];
        for (int i = 0; i < values.size(); i++) {
            arrayDataOfDeposit[i] = values.get(i).getText();
        }
        return arrayDataOfDeposit;
    }

    public String getAccountBalance() {
        String[] arrayDataOfDeposit = getDataFromDepositHeader();
        return arrayDataOfDeposit[1];

    }

    public TransactionListPage clickOnTransactionButton() {
        clickOnElement(transactionButton);
        return new TransactionListPage(webDriver);
    }


}

