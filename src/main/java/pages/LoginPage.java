package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage{
    protected String base_url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage openLoginPage(){
        try {
            webDriver.get(base_url);
            logger.info("LoginPage was opened " + base_url);
        }catch (Exception e){
            logger.error("Can not open page");
            Assert.fail("Can not open page");
        }
        return new LoginPage(webDriver);
    }

}
