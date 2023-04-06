package pages;

import com.beust.ah.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TransactionListPage extends ParentPage {
    @FindBy(xpath = ".//button[@ng-click = 'reset()']")
    public WebElement resetButton;

    @FindBy(xpath = ".//button[@ng-click = 'back()']")
    public WebElement backButton;

    @FindBy(xpath = "//*[@class='table table-bordered table-striped']/tbody")
    public WebElement CustomersTable;

    @Override
    String getRelativeURL() {
        return "/listTx";
    }

    public TransactionListPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TransactionListPage checkIsRedirectTransactionPage() {
        Assert.assertTrue("Customers List is not loaded", resetButton.isDisplayed());
        checkUrl();
        return this;
    }

    public String[] getDataOfTransactionsFromTable() {
        List<WebElement> rows = CustomersTable.findElements(By.tagName("tr"));
        String[] arrayDataOfCustomer = new String[0];
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            arrayDataOfCustomer = new String[columns.size()];
            for (int j = 0; j < columns.size(); j++) {
                arrayDataOfCustomer[j] = columns.get(j).getText();
            }
        }
        return arrayDataOfCustomer;
        //ToDO
    }

    public TransactionListPage checkTransactionData(String deposit, String type) {
        String[] arrayDataOfCustomer = getDataOfTransactionsFromTable();
        Assert.assertEquals("Transaction Type is", type, arrayDataOfCustomer[2]);
        Assert.assertEquals("Amount is", deposit, arrayDataOfCustomer[1]);
        //ToDO
        return this;
    }


    public AccountPage clickOnBack() {
        clickOnElement(backButton);
        return new AccountPage(webDriver);
    }
}
