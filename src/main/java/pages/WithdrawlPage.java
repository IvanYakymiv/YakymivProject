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


    @Override
    String getRelativeURL() {
        return null;
    }

    public WithdrawlPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WithdrawlPage inputAmountOfWithdraw(String deposit) {
        enterTextToInput(amountInput, deposit);
        return this;
    }

    public WithdrawlPage clickOnWithdrawButton(){
        clickOnElement(withdrawButton);
        return this;
    }

    public WithdrawlPage checkSuccessfulMessage() {
        Assert.assertTrue("Successful Message is shown", successfulMessage.isDisplayed());
        return this;
    }

    public WithdrawlPage checkErrorMessage() {
        Assert.assertTrue("Error Message is shown", errorMessage.isDisplayed());
        return this;
    }


}
