package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ManagerPage extends ParentPage {

    @Override
    String getRelativeURL() {
        return "/manager";
    }

    public ManagerPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ManagerPage checkIsRedirectManagerPage() {
        Assert.assertTrue("Manager Page is not loaded", getManagerHeaderElements().addCustomerButton.isDisplayed());
        checkUrl();
        return this;
    }


}
