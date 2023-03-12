package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElement;
import pages.LoginPage;

public class HeaderElements extends ActionsWithElement {
    @FindBy(xpath = ".//button[text()='Logout'")
    public WebElement logOutButton;

    @FindBy(xpath = ".//button[text()='Home']")
    public WebElement homeButton;

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage clickOnHomeButton(){
        clickOnElement(homeButton);
        return new LoginPage(webDriver);
    }
}
