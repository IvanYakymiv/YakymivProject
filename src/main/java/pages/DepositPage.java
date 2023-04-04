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

    @FindBy(xpath = "//strong[contains(text(), 'Balance')]/following-sibling::strong[contains(@class, 'ng-binding')]")
    public WebElement depositBalance;

    public String depositData = ".//strong[@class='ng-binding']";

    @Override
    String getRelativeURL() {
        return null;
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

    public void checkAccountBalance() {
        getDataFromDepositHeader();

    }

    public void getDataFromDepositHeader() {
        List<WebElement> values = webDriver.findElements(By.xpath(depositData));
        String[] arrayDataOfDeposit = new String[values.size()];
        for (int i = 0; i < values.size(); i++) {
            arrayDataOfDeposit[i] = values.get(i).getText();
            logger.info(values.get(i).getText());
        }
    }
}

