package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends ParentPage {

    @FindBy(xpath = ".//button[@ng-click='transactions()']")
    public WebElement transactionButton;

    @FindBy(xpath = ".//button[@ng-click='deposit()']")
    public WebElement depositButton;

    @FindBy(xpath = ".//button[@ng-click='withdrawl()']")
    public WebElement withdrawButton;

    @FindBy(xpath = ".//span[@class='fontBig ng-binding']")
    public WebElement customerName;


    @Override
    String getRelativeURL() {
        return null;
    }

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TransactionListPage clickOnTransactionsButton() {
        clickOnElement(transactionButton);
        return new TransactionListPage(webDriver);
    }

    public DepositPage clickOnDepositButton() {
        clickOnElement(depositButton);
        return new DepositPage(webDriver);
    }

    public WithdrawlPage clickOnWithdrawButton() {
        clickOnElement(withdrawButton);
        return new WithdrawlPage(webDriver);
    }

    public AccountPage checkIsCustomerLogIn(String firstName, String lastName) {
        webDriverWait10.until(ExpectedConditions.visibilityOf(getHeaderElement().logOutButton));
        Assert.assertTrue("Logout button is not displayed", getHeaderElement().logOutButton.isDisplayed());
        Assert.assertEquals("Customer Name is", firstName + ' ' + lastName, customerName.getText());
        return this;
    }
}
