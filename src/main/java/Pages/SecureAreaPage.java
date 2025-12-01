package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    WebDriver driver;

    // Constructor
    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By successMessage = By.cssSelector(".flash");

    // Actions
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
