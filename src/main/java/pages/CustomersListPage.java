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

    public CustomersListPage checkAccountWasCreated(String accountPostCode) {
        Assert.assertEquals("Number of posts with Post Code ",1 , getPostListWithTitle(accountPostCode).size());
        logger.info("Account is present");
        return this;
    }

    public CustomersListPage deleteAccountWithPostCode(String postCode){
        clickOnElement(deleteButton);
        logger.info("Customer was deleted with Post Code: " + postCode);
        return this;
    }
}
