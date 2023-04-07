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

    public CustomersListPage checkNumberOfAccountWasCreated(String name, Integer count) {
        String[] arr = getAccountNumber().split(" ");
        Assert.assertEquals("Number accounts of customer " + name, count.intValue(), arr.length);
        return this;
    }

    public String getAccountNumber() {
        return getDataFromTable(CustomersTable)[3];
    }
}
