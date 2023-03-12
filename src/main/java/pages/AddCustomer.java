package pages;

import libs.Util;
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
    public WebElement addCustomerButton;

    @FindBy(xpath = ".//button[@ng-class='btnClass3']")
    public WebElement customersButton;


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

    public AddCustomer clickOnAddCustomer() {
        Util.waitABit(1);
        clickOnElement(addCustomerButton);
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

}
