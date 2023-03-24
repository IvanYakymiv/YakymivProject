package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerPage extends ParentPage{

    @FindBy(xpath = ".//button[@ng-class='btnClass1']")
    public WebElement addCustomerButton;

    @FindBy(xpath = ".//button[@ng-class='btnClass2']")
    public WebElement openAccountButton;

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
}
