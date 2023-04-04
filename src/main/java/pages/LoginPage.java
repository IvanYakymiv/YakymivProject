package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{
    protected String base_url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    @FindBy(xpath = ".//button[text()='Bank Manager Login']")
    private WebElement bankManagerLoginButton;

    @FindBy(xpath = ".//button[text()='Customer Login']")
    private WebElement customerLoginButton;

    @Override
    String getRelativeURL() {
        return "/login";
    }

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage openLoginPage(){
        try {
            webDriver.get(base_url);
            logger.info("LoginPage was opened " + base_url);
        } catch (Exception e){
            printErrorAndStop(e);
        }
        checkIsRedirectLoginPage();
        return new LoginPage(webDriver);
    }

    public ManagerPage clickOnBankManagerLogin(){
        clickOnElement(bankManagerLoginButton);
        return new ManagerPage(webDriver);
    }

    public CustomerPage clickOnCustomerLoginButton(){
        clickOnElement(customerLoginButton);
        return new CustomerPage(webDriver);
    }

    public LoginPage checkIsRedirectLoginPage() {
        Assert.assertTrue("Manager Page is not loaded", customerLoginButton.isDisplayed());
        Assert.assertTrue("Manager Page is not loaded", bankManagerLoginButton.isDisplayed());
        checkUrl();
        return this;
    }

}
