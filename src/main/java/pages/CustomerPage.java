package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage extends ParentPage{
    @FindBy(xpath = ".//*[@id = 'userSelect']")
    public WebElement customersDropDown;

    @FindBy(xpath = ".//button[@type='submit']")
    public WebElement loginButton;

    @Override
    String getRelativeURL() {
        return "/customer";
    }

    public CustomerPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CustomerPage selectCustomerNameFromDD(String name){
        selectTextInDropDownByUI(customersDropDown,name);
        return this;
    }

    public AccountPage clickOnLogin(){
        clickOnElement(loginButton);
        return new AccountPage(webDriver);
    }

    public CustomerPage checkIsRedirectCustomerPage() {
        Assert.assertTrue("Customer Page is not loaded", customersDropDown.isDisplayed());
        checkUrl();
        return this;
    }
}
