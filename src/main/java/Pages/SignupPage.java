package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[data-qa='signup-name']")
    public WebElement signupName;

    @FindBy(css = "input[data-qa='signup-email']")
    public WebElement signupEmail;

    @FindBy(css = "button[data-qa='signup-button']")
    public WebElement signupButton;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private WebElement existingEmailError;

    public void navigateTo() {
        driver.get("https://automationexercise.com/");
    }

    public void fillSignupForm(String name, String email) {
        signupName.clear();
        signupName.sendKeys(name);
        signupEmail.clear();
        signupEmail.sendKeys(email);
    }

    public void clickSignup() {
        signupButton.click();
    }

    public String getExistingEmailError() {
        return existingEmailError.getText();
    }

}
