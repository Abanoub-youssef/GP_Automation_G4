package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    // Constructor with PageFactory
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    private By contactUSLink = By.cssSelector("a[href='/contact_us']");

    @FindBy(css = "a[href='/login']")
    public WebElement signupLoginButton;

    // ------- Page Actions -------

    public void navigateTo() {
        driver.get("https://automationexercise.com/");
    }

    public ContactUsPage openContactUS() {
        driver.findElement(contactUSLink).click();
        return new ContactUsPage(driver);
    }

    public SignupPage openSignup() {
        signupLoginButton.click();
        return new SignupPage(driver);
    }

    public LoginPage ClickOnSignupLoginPagelink(){
        signupLoginButton.click();
        return new LoginPage(driver);
    }
}
