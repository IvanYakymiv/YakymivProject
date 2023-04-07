package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends ParentPage {

    @FindBy(xpath = ".//span[@class='fontBig ng-binding']")
    public WebElement customerName;

    public String depositData = ".//strong[@class='ng-binding']";

    @Override
    String getRelativeURL() {
        return "/account";
    }

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AccountPage checkIsCustomerLogIn(String firstName, String lastName) {
        webDriverWait10.until(ExpectedConditions.visibilityOf(getHeaderElement().logOutButton));
        Assert.assertTrue("Logout button is not displayed", getHeaderElement().logOutButton.isDisplayed());
        Assert.assertEquals("Customer Name is", firstName + ' ' + lastName, customerName.getText());
        checkUrl();
        return this;
    }

    public AccountPage checkAccountCurrency(String currency) {
        Assert.assertEquals("Currency of customer account ", currency, getAccountCurrency());
        return this;
    }

    public String getAccountCurrency() {
        return getDataFromSameXpathToStringArray(depositData)[2];
    }

}
