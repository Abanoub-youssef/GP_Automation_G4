package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Pages.HomePage;


public class LoginPage {
    HomePage homePage;
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    //locaters
    private By EmailBox = By.xpath("//input[@data-qa='login-email']");
    private By passwordBox = By.xpath("(//input[@name='password'])[1]");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");
    private By ErrorMessage =By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    //Actions
    public void insertEmail(String name)
    {
        driver.findElement(EmailBox).sendKeys(name);
    }

    public void insertPassword(String password){

        driver.findElement(passwordBox).sendKeys(password);
    }
    public AccountCreatedPage ClickOnLoginButton(){

        driver.findElement(loginButton).click();
        return new AccountCreatedPage(driver);
    }
    public String Getmessage(){

        return driver.findElement(ErrorMessage).getText();
    }


}
