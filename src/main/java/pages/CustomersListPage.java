package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomersListPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='Search Customer']")
    public WebElement searchCustomerInput;

    @FindBy(xpath = ".//button[@ng-click = 'deleteCust(cust)']")
    public WebElement deleteButton;

    public String customerPostCodeInList = ".//td[text()='%s']";

    @FindBy(xpath = "//*[@class='table table-bordered table-striped']/tbody")
    public WebElement CustomersTable;

    @Override
    String getRelativeURL() {
        return "/manager/list";
    }

    public CustomersListPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CustomersListPage enterTextInSearch(String text) {
        enterTextToInput(searchCustomerInput, text);
        return this;
    }

    public List<WebElement> getPostListWithTitle(String title) {
        return webDriver.findElements(By.xpath(String.format(customerPostCodeInList, title)));
    }

    public CustomersListPage checkCustomerWasCreated(String accountPostCode) {
        Assert.assertEquals("Number of customers with Post Code ", 1, getPostListWithTitle(accountPostCode).size());
        logger.info("Customer is present");
        return this;
    }

    public CustomersListPage deleteAccountWithPostCode(String postCode) {
        clickOnElement(deleteButton);
        logger.info("Customer was deleted with Post Code: " + postCode);
        return this;
    }

    public CustomersListPage checkIsRedirectCustomersPage() {
        Assert.assertTrue("Customers List is not loaded", searchCustomerInput.isDisplayed());
        checkUrl();
        return this;
    }

    public CustomersListPage checkCustomerWasDeleted(String accountPostCode) {
        Assert.assertEquals("Number of customers with Post Code ", 0, getPostListWithTitle(accountPostCode).size());
        logger.info("No customers with Post Code " + accountPostCode);
        return this;
    }


    public CustomersListPage checkAccountWasCreated(String name) {
        String[] arr = getAccountNumber(name).split(" ");
        Assert.assertEquals("Number accounts of customer " + name, 1, arr.length);
        return this;
    }

    public String[] getDataOfCustomerFromTable(String name) {
        enterTextInSearch(name);
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
    }

    public String getAccountNumber(String name) {
        String[] arrayDataOfCustomer = getDataOfCustomerFromTable(name);
        return arrayDataOfCustomer[3];
    }
}
