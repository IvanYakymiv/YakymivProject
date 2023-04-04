package pages;

import libs.Util;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCustomer extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='First Name']")
    public WebElement firsNameInput;

    @FindBy(xpath = ".//input[@placeholder='Last Name']")
    public WebElement lastNameInput;

    @FindBy(xpath = ".//input[@placeholder='Post Code']")
    public WebElement postCodeInput;

    @FindBy(xpath = ".//button[@type='submit']")
    public WebElement addCustomerSubmitButton;

    @FindBy(xpath = ".//button[@ng-class='btnClass3']")
    public WebElement customersButton;


    @Override
    String getRelativeURL() {
        return "/manager/addCust";
    }

    public AddCustomer(WebDriver webDriver) {
        super(webDriver);
    }

    public AddCustomer enterTextToFirstNameInput(String firstName) {
        enterTextToInput(firsNameInput, firstName);
        return this;
    }

    public AddCustomer enterTextToLastNameInput(String lastName) {
        enterTextToInput(lastNameInput, lastName);
        return this;
    }

    public AddCustomer enterTextToPostCodeInput(String postCode) {
        enterTextToInput(postCodeInput, postCode);
        return this;
    }

    public AddCustomer clickOnAddCustomerSubmit() {
        Util.waitABit(1);
        clickOnElement(addCustomerSubmitButton);
        return this;
    }

    public AddCustomer getTextFromAlert() {
        getTextFromAlertAndClickOK(webDriver);
        return this;
    }

    public CustomersListPage clickOnCustomers() {
        clickOnElement(customersButton);
        return new CustomersListPage(webDriver);
    }

    public AddCustomer checkIsRedirectAddCustomerPage() {
        Assert.assertTrue("Add Customer Page is not loaded", firsNameInput.isDisplayed());
        checkUrl();
        return this;
    }
}
