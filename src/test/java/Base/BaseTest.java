package Base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

   public WebDriver driver;
   public HomePage  homePage;
   @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://automationexercise.com/");
    }

    @AfterClass
    public void clearBrowser() {
        driver.quit();
    }
}
