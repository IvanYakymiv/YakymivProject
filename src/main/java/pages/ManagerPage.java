package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerPage extends ParentPage{

    @FindBy(xpath = ".//button[@ng-class='btnClass1']")
    public WebElement addCustomerButton;

    @FindBy(xpath = ".//button[@ng-class='btnClass2']")
    public WebElement openAccountButton;

    @FindBy(xpath = ".//button[@ng-class='btnClass3']")
    public WebElement customersButton;

    @Override
    String getRelativeURL() {
        return "/manager";
    }

    public ManagerPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddCustomer clickOnAddCustomer(){
        clickOnElement(addCustomerButton);
        return new AddCustomer(webDriver);
    }

    public OpenAccountPage clickOnOpenAccount() {
        clickOnElement(openAccountButton);
        return new OpenAccountPage(webDriver);
    }

    public CustomersListPage clickOnCustomers() {
        clickOnElement(customersButton);
        return new CustomersListPage(webDriver);
    }

    public ManagerPage checkIsRedirectManagerPage() {
        Assert.assertTrue("Manager Page is not loaded", addCustomerButton.isDisplayed());
        checkUrl();
        return this;
    }


}
