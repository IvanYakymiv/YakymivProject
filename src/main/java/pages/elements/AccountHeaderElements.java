package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.*;

public class AccountHeaderElements extends ActionsWithElement {
    @FindBy(xpath = ".//button[@ng-click='transactions()']")
    public WebElement transactionButton;

    @FindBy(xpath = ".//button[@ng-click='deposit()']")
    public WebElement depositButton;

    @FindBy(xpath = ".//button[@ng-click='withdrawl()']")
    public WebElement withdrawButton;

    @FindBy(xpath = ".//*[@id = 'accountSelect']")
    public WebElement accountDropDown;

    public String depositData = ".//strong[@class='ng-binding']";


    public AccountHeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    public TransactionListPage clickOnTransactionButton() {
        clickOnElement(transactionButton);
        return new TransactionListPage(webDriver);
    }

    public DepositPage clickOnDepositButton() {//todo
        clickOnElement(depositButton);
        return new DepositPage(webDriver);
    }

    public WithdrawPage clickOnWithdrawButton() {
        clickOnElement(withdrawButton);
        return new WithdrawPage(webDriver);
    }

    public AccountPage selectNextAccountInDD() {
        selectNextValueInDD(accountDropDown);
        return new AccountPage(webDriver);
    }


    public String getAccountCurrency() {
        return getDataFromSameXpathToStringArray(depositData)[2];
    }
}
