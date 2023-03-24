package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends ParentPage{
    @FindBy(xpath = ".//input[@placeholder='amount']")
    public WebElement amountInput;

    @FindBy(xpath = ".//button[@type='submit']")
    public WebElement depositButton;

    @FindBy(xpath = ".//span[text()='Deposit Successful']")
    public WebElement successfulMessage;



    public DepositPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DepositPage inputAmountOfDeposit(String deposit) {
        enterTextToInput(amountInput, deposit);
        return this;
    }

    public DepositPage clickOnDepositButton(){
        clickOnElement(depositButton);
        return this;
    }

    public DepositPage checkSuccessfulMessage() {
        Assert.assertTrue("Text in success message element", successfulMessage.isDisplayed());
        return this;
    }
}
