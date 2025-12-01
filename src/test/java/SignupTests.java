import Base.BaseTest;
import Pages.SignupPage;
import Pages.AccountInformationPage;
import Pages.AccountCreatedPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {

    SignupPage signupPage;
    AccountInformationPage accountInfoPage;
    AccountCreatedPage accountCreatedPage;

    // -------------------------
    // Test Case 1 – Valid Signup
    // -------------------------
    @Test
    public void testValidSignup() {
        signupPage = homePage.openSignup();
        signupPage.fillSignupForm("Abanoub QA", "test" + System.currentTimeMillis() + "@email.com");
        signupPage.clickSignup();

        accountInfoPage = new AccountInformationPage(driver);
        accountInfoPage.fillAccountInfo();
        accountInfoPage.clickCreateAccount();

        accountCreatedPage = new AccountCreatedPage(driver);
        System.out.println(accountInfoPage);
        String message = accountCreatedPage.getMessage();
        Assert.assertEquals(message, "ACCOUNT CREATED!");
    }

    // -------------------------
    // Test Case 2 – Signup with existing email (Negative)
    // -------------------------
    @Test
    public void testSignupWithExistingEmail() {
        signupPage = homePage.openSignup();
        signupPage.fillSignupForm("Abanoub", "existing@example.com");
        signupPage.clickSignup();
        String message = signupPage.getExistingEmailError();
        Assert.assertEquals(message, "Email Address already exist!");
    }

    // -------------------------
    // Test Case 3 – Signup with invalid email format
    // -------------------------
    @Test
    public void testSignupWithInvalidEmail() {
        signupPage = homePage.openSignup();
        signupPage.fillSignupForm("Abanoub", "invalidemail");
        signupPage.clickSignup();

        boolean emailIsValid = signupPage.signupEmail.getAttribute("validationMessage").isEmpty();
        Assert.assertFalse(emailIsValid, "Invalid email should prevent submission");
    }

    // -------------------------
    // Test Case 4 – Missing Name
    // -------------------------
    @Test
    public void testSignupWithoutName() {
        signupPage = homePage.openSignup();
        signupPage.fillSignupForm("", "test" + System.currentTimeMillis() + "@email.com");

        boolean nameIsValid = signupPage.signupName.getAttribute("validationMessage").isEmpty();
        Assert.assertFalse(nameIsValid, "Name is required");
    }

    // -------------------------
    // Test Case 5 – Missing Email
    // -------------------------
    @Test
    public void testSignupWithoutEmail() {
        signupPage = homePage.openSignup();
        signupPage.fillSignupForm("Abanoub", "");

        boolean emailIsValid = signupPage.signupEmail.getAttribute("validationMessage").isEmpty();
        Assert.assertFalse(emailIsValid, "Email is required");
    }

    // -------------------------
    // Test Case 6 – Very Long Name
    // -------------------------
    @Test
    public void testSignupWithLongName() {
        signupPage = homePage.openSignup();
        signupPage.fillSignupForm("A".repeat(200), "longname" + System.currentTimeMillis() + "@mail.com");
        signupPage.clickSignup();

        accountInfoPage = new AccountInformationPage(driver);
        Assert.assertTrue(accountInfoPage.password.isDisplayed());
    }
}
