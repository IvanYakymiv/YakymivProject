package pages;

import org.openqa.selenium.WebDriver;
import pages.elements.HeaderElements;

public class ParentPage extends ActionsWithElement{

    private HeaderElements headerElements = new HeaderElements(webDriver);

    public HeaderElements getHeaderElement() {
        return headerElements;
    }

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }
}
