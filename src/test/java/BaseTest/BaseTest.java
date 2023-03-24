package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.LoginPage;

import java.time.Duration;


public class BaseTest {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected LoginPage loginPage;

    @Before
    public void before(){
        logger.info("--------" + testName.getMethodName() + " was started--------");
//        WebDriverManager.chromedriver().setup();
//        webDriver = new ChromeDriver();
        WebDriverManager.edgedriver().setup();
        webDriver=new EdgeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(webDriver);
    }

    @After
    public void after(){
        webDriver.quit();
        logger.info("Browser is closed");


    }

    @Rule
    public TestName testName = new TestName();
}
