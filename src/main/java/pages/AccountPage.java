package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountPage extends ParentPage {

    @FindBy(xpath = ".//button[@ng-click='transactions()']")
    public WebElement transactionButton;

    @FindBy(xpath = ".//button[@ng-click='deposit()']")
    public WebElement depositButton;

    @FindBy(xpath = ".//button[@ng-click='withdrawl()']")
    public WebElement withdrawButton;

    @FindBy(xpath = ".//span[@class='fontBig ng-binding']")
    public WebElement customerName;

    @FindBy(xpath = ".//*[@id = 'accountSelect']")
    public WebElement accountDropDown;

    public String depositData = ".//strong[@class='ng-binding']";

    @Override
    String getRelativeURL() {
        return "/account";
    }

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TransactionListPage clickOnTransactionsButton() {
        clickOnElement(transactionButton);
        return new TransactionListPage(webDriver);
    }

    public DepositPage clickOnDepositButton() {//todo
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
        checkUrl();
        return this;
    }

    public AccountPage selectNextAccountInDD() {
        Select select = new Select(accountDropDown);
        List<WebElement> listOfOptions = select.getOptions();
        Integer count = listOfOptions.indexOf(select.getFirstSelectedOption());
        selectTextInDropDownByUI(accountDropDown,listOfOptions.get(count + 1).getText());
        logger.info("Account changed");
        return new AccountPage(webDriver);
    }

    public AccountPage checkChangingAccount(String currency) {
        Assert.assertEquals("Balance of customer account ", currency, getAccountBalance());
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
        return arrayDataOfDeposit[2];

    }

}
