package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    WebDriver driver;

    // Constructor
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By emailField = By.id("email");
    By retrieveButton = By.id("form_submit");
    By confirmationMessage = By.tagName("h1");

    // Actions
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickRetrievePassword() {
        driver.findElement(retrieveButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}
