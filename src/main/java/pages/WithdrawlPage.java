package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithdrawlPage extends ParentPage{
    @FindBy(xpath = ".//input[@placeholder='amount']")
    public WebElement amountInput;

    @FindBy(xpath = ".//button[@type='submit']")
    public WebElement withdrawButton;

    @FindBy(xpath = ".//span[text()='Transaction successful']")
    public WebElement successfulMessage;

    @FindBy(xpath = ".//span[text()='Transaction Failed. You can not withdraw amount more than the balance.']")
    public WebElement errorMessage;

    @FindBy(xpath = ".//button[@ng-click='transactions()']")
    public WebElement transactionButton;


    @Override
    String getRelativeURL() {
        return "/account";
    }

    public WithdrawlPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WithdrawlPage inputAmountOfWithdraw(String amount) {
        enterTextToInput(amountInput, amount);
        return this;
    }

    public WithdrawlPage inputErrorAmountOfWithdraw(String amount) {
        enterTextToInput(amountInput, amount + 1);
        return this;
    }

    public WithdrawlPage clickOnWithdrawButton(){
        clickOnElement(withdrawButton);
        return this;
    }

    public WithdrawlPage checkSuccessfulMessage() throws InterruptedException {
        Assert.assertTrue("Successful Message is shown", successfulMessage.isDisplayed());
        Thread.sleep(1000);
        return this;
    }

    public WithdrawlPage checkErrorMessage() {
        Assert.assertTrue("Error Message is shown", errorMessage.isDisplayed());
        return this;
    }

    public WithdrawlPage checkIsRedirectWithdrawlPage() {
        Assert.assertTrue("Customer Page is not loaded", amountInput.isDisplayed());
        checkUrl();
        return this;
    }

    public TransactionListPage clickOnTransactionButton() {
        clickOnElement(transactionButton);
        return new TransactionListPage(webDriver);
    }




}
