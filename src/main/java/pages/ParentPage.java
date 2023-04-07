package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.elements.AccountHeaderElements;
import pages.elements.HeaderElements;
import pages.elements.ManagerHeaderElements;

public abstract class ParentPage extends ActionsWithElement {
    protected String base_url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#";

    private HeaderElements headerElements = new HeaderElements(webDriver);

    public HeaderElements getHeaderElement() {
        return headerElements;
    }

    private AccountHeaderElements accountHeaderElements = new AccountHeaderElements(webDriver);

    public AccountHeaderElements getAccountHeaderElements() {
        return accountHeaderElements;
    }

    private ManagerHeaderElements managerHeaderElements = new ManagerHeaderElements(webDriver);

    public ManagerHeaderElements getManagerHeaderElements() {
        return managerHeaderElements;
    }


    abstract String getRelativeURL();

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected void checkUrl() {
        Assert.assertEquals("Invalid Page", base_url + getRelativeURL(), webDriver.getCurrentUrl());
    }
}
