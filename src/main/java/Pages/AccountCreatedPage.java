package Pages;

import org.openqa.selenium.By;
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

    private By SuccessLoginMessage = By.xpath("//a[contains(text(),' Logged in as ')]");
    private By LogoutButton = By.xpath("//a[contains(text(),' Logout')]");

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

    public String getSuccessMessage(){
        return driver.findElement(SuccessLoginMessage).getText();
    }

    public HomePage LogoutLink(){
        driver.findElement(LogoutButton).click();
        return new HomePage(driver);
    }
}
