package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenAccountPage extends ParentPage{

    @FindBy(xpath = ".//*[@id = 'userSelect']")
    private WebElement customersDropDown;

    @FindBy(xpath = ".//*[@id = 'currency']")
    private WebElement currencyDropDown;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement processButton;

    public OpenAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public OpenAccountPage selectNameOfCustomerInDD(String name){
        selectTextInDropDownByUI(customersDropDown,name);
        return this;
    }

    public OpenAccountPage selectCurrencyInDD(String currency){
        selectTextInDropDownByUI(currencyDropDown,currency);
        return this;
    }

    public OpenAccountPage clickOnProcessButton() {
        clickOnElement(processButton);
        return this;
    }
}
