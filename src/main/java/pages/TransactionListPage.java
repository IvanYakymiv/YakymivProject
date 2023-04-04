package pages;

import org.openqa.selenium.WebDriver;

public class TransactionListPage extends ParentPage{
    @Override
    String getRelativeURL() {
        return null;
    }

    public TransactionListPage(WebDriver webDriver) {
        super(webDriver);
    }
}
