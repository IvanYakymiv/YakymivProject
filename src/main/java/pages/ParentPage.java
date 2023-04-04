package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.elements.HeaderElements;

public abstract class ParentPage extends ActionsWithElement{
    protected String base_url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#";

    private HeaderElements headerElements = new HeaderElements(webDriver);

    public HeaderElements getHeaderElement() {
        return headerElements;
    }

    abstract String getRelativeURL();

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected void checkUrl(){
        Assert.assertEquals("Invalid Page", base_url + getRelativeURL(), webDriver.getCurrentUrl());
    }
}
