package pages;

import libs.TestData;
import libs.Util;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithdrawPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='amount']")
    public WebElement amountInput;

    @FindBy(xpath = ".//button[@type='submit']")
    public WebElement withdrawButton;

    @FindBy(xpath = ".//span[text()='Transaction successful']")
    public WebElement successfulMessage;

    @FindBy(xpath = ".//span[text()='Transaction Failed. You can not withdraw amount more than the balance.']")
    public WebElement errorMessage;


    @Override
    String getRelativeURL() {
        return "/account";
    }

    public WithdrawPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WithdrawPage inputAmountOfWithdraw(String amount) {
        enterTextToInput(amountInput, amount);
        return this;
    }

    public WithdrawPage inputErrorAmountOfWithdraw(String amount) {
        enterTextToInput(amountInput, amount + 1);
        return this;
    }

    public WithdrawPage clickOnWithdrawSubmitButton() {
        clickOnElement(withdrawButton);
        TestData.date = Util.getFormattedDate();
        return this;
    }

    public WithdrawPage checkSuccessfulMessage() throws InterruptedException {
        Assert.assertTrue("Successful Message is shown", successfulMessage.isDisplayed());
        Thread.sleep(1000);//todo
        return this;
    }

    public WithdrawPage checkErrorMessage() {
        Assert.assertTrue("Error Message is shown", errorMessage.isDisplayed());
        return this;
    }

    public WithdrawPage checkIsRedirectWithdrawPage() {
        Assert.assertTrue("Withdraw Page is not loaded", amountInput.isDisplayed());
        checkUrl();
        return this;
    }

}
