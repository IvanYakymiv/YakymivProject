package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.*;

public class ManagerHeaderElements extends ActionsWithElement {
    @FindBy(xpath = ".//button[@ng-class='btnClass1']")
    public WebElement addCustomerButton;

    @FindBy(xpath = ".//button[@ng-class='btnClass2']")
    public WebElement openAccountButton;

    @FindBy(xpath = ".//button[@ng-class='btnClass3']")
    public WebElement customersButton;

    public ManagerHeaderElements(WebDriver webDriver) {
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
}
