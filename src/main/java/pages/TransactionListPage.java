package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TransactionListPage extends ParentPage {
    @FindBy(xpath = ".//button[@ng-click = 'reset()']")
    public WebElement resetButton;

    @FindBy(xpath = ".//button[@ng-click = 'back()']")
    public WebElement backButton;

    @FindBy(xpath = "//*[@class='table table-bordered table-striped']/tbody")
    public WebElement customersTable;

    @Override
    String getRelativeURL() {
        return "/listTx";
    }

    public TransactionListPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TransactionListPage checkIsRedirectTransactionPage() {
        Assert.assertTrue("Transaction List is not loaded", resetButton.isDisplayed());
        checkUrl();
        return this;
    }

    public TransactionListPage checkTransactionData(String deposit, String type) {
        String[] arrayDataOfCustomer = getDataFromTable(customersTable);
        Assert.assertEquals("Transaction Type is", type, arrayDataOfCustomer[2]);
        Assert.assertEquals("Amount is", deposit, arrayDataOfCustomer[1]);
        return this;
    }

    public AccountPage clickOnBack() {
        clickOnElement(backButton);
        return new AccountPage(webDriver);
        //todo
    }
}
