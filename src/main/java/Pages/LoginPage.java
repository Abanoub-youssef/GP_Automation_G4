package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.cssSelector("button.radius");
    By errorMessage = By.cssSelector("div.flash.error");

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLogin() {
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
