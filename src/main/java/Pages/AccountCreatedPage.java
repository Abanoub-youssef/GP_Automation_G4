package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {

    WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h2[data-qa='account-created']")
    public WebElement successMessage;

    @FindBy(css = "a[data-qa='continue-button']")
    public WebElement continueButton;

    public String getMessage() {
        return successMessage.getText();
    }

    public void clickContinue() {
        continueButton.click();
    }
}
