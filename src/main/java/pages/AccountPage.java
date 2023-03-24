package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends ParentPage{
    @FindBy(xpath = ".//*[@id = 'accountSelect']")
    public WebElement accountsDropDown;

    @FindBy(xpath = ".//button[@ng-click='transactions()']")
    public WebElement transactionButton;

    @FindBy(xpath = ".//button[@ng-click='deposit()']")
    public WebElement depositButton;

    @FindBy(xpath = ".//button[@ng-click='withdrawl()']")
    public WebElement withdrawButton;


    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TransactionListPage clickOnTransactionsButton(){
        clickOnElement(transactionButton);
        return new TransactionListPage(webDriver);
    }

    public DepositPage clickOnDepositButton(){
        clickOnElement(depositButton);
        return new DepositPage(webDriver);
    }

    public WithdrawlPage clickOnWithdrawButton(){
        clickOnElement(withdrawButton);
        return new WithdrawlPage(webDriver);
    }
}
