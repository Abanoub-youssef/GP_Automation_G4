package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    private WebDriver driver;

    // ====== Locators ======
    @FindBy(css = "input[name='name']")           // adjust locator if form has name field
    public WebElement nameInput;

    @FindBy(css = "input[name='email']")          // adjust locator if form has email field
    public WebElement emailInput;

    @FindBy(css = "input[name='subject']")        // adjust locator if form has subject field
    public WebElement subjectInput;

    @FindBy(css = "textarea[name='message']")     // adjust locator if form has message textarea
    public WebElement messageTextArea;

    @FindBy(css = "input[type='submit'], button[type='submit']")  // submit button (or adjust to actual)
    private WebElement submitButton;

    @FindBy(css = "div.status.alert.alert-success")
    private WebElement successMessage;                  // some locator for success message (example)

    // ====== Constructor ======
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ====== Page Actions ======

    /** Navigate to Contact Us page */
    public void navigateTo() {
        driver.get("https://automationexercise.com/contact_us");
    }

    /** Fill contact form — name, email, subject, message */
    public void fillContactForm(String name, String email, String subject, String message) {
        nameInput.clear();
        nameInput.sendKeys(name);

        emailInput.clear();
        emailInput.sendKeys(email);

        subjectInput.clear();
        subjectInput.sendKeys(subject);

        messageTextArea.clear();
        messageTextArea.sendKeys(message);
    }

    /** Submit the contact form */
    public void submitForm() {
        submitButton.click();
        // Handle the alert that appears after submit
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept(); // Or alert.dismiss();
        } catch (NoAlertPresentException e) {
            // ignore if no alert
        }
    }

    /** (Optional) Get success message text */
    public String getSuccessMessage() {
        return successMessage.getText().trim();
    }

    /** A convenience method: fill + submit */
    public void submitContactForm(String name, String email, String subject, String message) {
        fillContactForm(name, email, subject, message);
        submitForm();
    }

    public boolean isFieldValid(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (boolean) js.executeScript("return arguments[0].checkValidity();", element);
    }

}
