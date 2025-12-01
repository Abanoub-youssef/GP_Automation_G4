package ContactUsTest;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

import Pages.ContactUsPage;

public class ContactUsTest extends BaseTest {

    private ContactUsPage contactUsPage;

    @Test
    public void testSubmitContactUs() {
        contactUsPage = homePage.openContactUS();
        contactUsPage.navigateTo();
        contactUsPage.submitContactForm(
                "Abanoub Youssef",
                "Abanoub.Youssef@example.com",
                "Test Subject",
                "This is a test message."
        );

        String msg = contactUsPage.getSuccessMessage();
        Assert.assertTrue(msg.contains("successfully"), "Expected success message after submission");
    }

    @Test
    public void testSubmitContactUsWithIncorrectMail() {
        contactUsPage = homePage.openContactUS();
        contactUsPage.navigateTo();
        contactUsPage.submitContactForm(
                "Abanoub Youssef",
                "Abanoub.Youssef",
                "Test Subject",
                "This is a test message."
        );

        boolean emailIsValid = contactUsPage.isFieldValid(contactUsPage.emailInput);

        Assert.assertFalse(emailIsValid, "Email should be invalid and form should NOT submit.");
    }

    @Test
    public void testSubmitContactUsWithoutName() {
        contactUsPage = homePage.openContactUS();
        contactUsPage.navigateTo();

        contactUsPage.fillContactForm(
                "",
                "test@example.com",
                "Subject Test",
                "Message test"
        );

        boolean nameIsValid = contactUsPage.isFieldValid(contactUsPage.nameInput);
        Assert.assertTrue(nameIsValid);
    }

    @Test
    public void testSubmitWithoutMessage() {
        contactUsPage = homePage.openContactUS();
        contactUsPage.navigateTo();

        contactUsPage.fillContactForm(
                "Abanoub",
                "test@example.com",
                "Test Subject",
                ""
        );

        boolean messageIsValid = contactUsPage.isFieldValid(contactUsPage.messageTextArea);

        Assert.assertTrue(messageIsValid);
    }

    @Test
    public void testSubmitContactUsWithoutSubject() {
        contactUsPage = homePage.openContactUS();
        contactUsPage.navigateTo();

        contactUsPage.submitContactForm(
                "Abanoub",
                "test@example.com",
                "",
                "Message content here"
        );

        String msg = contactUsPage.getSuccessMessage();
        Assert.assertTrue(msg.contains("successfully"), "Form should submit even without subject.");
    }

    @Test
    public void testSubmitWithSpecialCharactersInMessage() {
        contactUsPage = homePage.openContactUS();
        contactUsPage.navigateTo();

        contactUsPage.submitContactForm(
                "Abanoub",
                "special@example.com",
                "Special Subject",
                "Hello! @#$%^&*() -- Testing special characters."
        );

        String msg = contactUsPage.getSuccessMessage();
        Assert.assertTrue(msg.contains("successfully"), "Expected success with special characters.");
    }

    @Test
    public void testSubmitWithLongMessage() {
        contactUsPage = homePage.openContactUS();
        contactUsPage.navigateTo();

        String longMessage = "A".repeat(5000);

        contactUsPage.submitContactForm(
                "Abanoub",
                "longmsg@example.com",
                "Long Message Test",
                longMessage
        );

        String msg = contactUsPage.getSuccessMessage();
        Assert.assertTrue(msg.contains("successfully"), "Long message should submit successfully.");
    }

}
