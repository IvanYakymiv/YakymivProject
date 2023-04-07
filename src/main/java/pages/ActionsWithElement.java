package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;


import java.time.Duration;
import java.util.List;

public class ActionsWithElement {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait10, webDriverWait15;

    public ActionsWithElement(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    protected void printErrorAndStop(Exception e) {
        logger.error("Cannot work with element " + e);
        Assert.fail("Cannot work with element " + e);
    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait15.until(ExpectedConditions.visibilityOf(webElement));
            webElement.click();
            logger.info(getElementName(webElement) + " Button was clicked");

        } catch (Exception e) {
            printErrorAndStop(e);
        }
    }

    protected void enterTextToInput(WebElement webElement, String data) {
        try {
            webDriverWait15.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(data);
            logger.info(data + " was inputted");
        } catch (Exception e) {
            printErrorAndStop(e);
        }
    }

    protected String getElementName(WebElement webElement) {
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

    protected void getTextFromAlertAndClickOK(WebDriver webDriver) {
        try {
            webDriverWait15.until(ExpectedConditions.alertIsPresent());
            Alert alert = webDriver.switchTo().alert();
            logger.info(alert.getText());
            alert.accept();
        } catch (Exception e) {
            printErrorAndStop(e);
        }
    }

    protected void selectTextInDropDownByUI(WebElement dropdown, String visibleText) {
        try {
            String locatorForDropDown = "//option[contains(text(),'" + visibleText + "')]";
            clickOnElement(dropdown);
            clickOnElement(dropdown.findElement(By.xpath(locatorForDropDown)));
            logger.info(visibleText + " was selected in DropDown");
        } catch (Exception e) {
            printErrorAndStop(e);
        }
    }

    protected void selectNextValueInDD(WebElement dropDown) {
        try {
            Select select = new Select(dropDown);
            List<WebElement> listOfOptions = select.getOptions();
            Integer count = listOfOptions.indexOf(select.getFirstSelectedOption());
            selectTextInDropDownByUI(dropDown, listOfOptions.get(count + 1).getText());
            logger.info("Account changed");
        } catch (Exception e) {
            printErrorAndStop(e);
        }
    }


    protected String[] getDataFromTable(WebElement table) {
        String[] arrayDataOfCustomer = new String[0];
        try {
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            for (int i = 0; i < rows.size(); i++) {
                List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
                arrayDataOfCustomer = new String[columns.size()];
                for (int j = 0; j < columns.size(); j++) {
                    arrayDataOfCustomer[j] = columns.get(j).getText();
                }
            }
        } catch (Exception e) {
            printErrorAndStop(e);
        }
        return arrayDataOfCustomer;
    }


    protected String[] getDataFromSameXpathToStringArray(String xpath) {
        String[] arrayDataOfDeposit = new String[0];
        try {
            List<WebElement> values = webDriver.findElements(By.xpath(xpath));
            arrayDataOfDeposit = new String[values.size()];
            for (int i = 0; i < values.size(); i++) {
                arrayDataOfDeposit[i] = values.get(i).getText();
            }
            return arrayDataOfDeposit;
        } catch (Exception e) {
            printErrorAndStop(e);
        }
        return arrayDataOfDeposit;
    }


}
