package stepdef;

import Base.BaseTest;
import Pages.AccountCreatedPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginSteps extends BaseTest {


    LoginPage loginPage;
    AccountCreatedPage Asloginpage;

    @Test(priority = 1)
    public void ValidLogin() {

        loginPage = homePage.ClickOnSignupLoginPagelink();
        loginPage.insertEmail("Ahmed111@gmail.com");
        loginPage.insertPassword("123456");
        Asloginpage = loginPage.ClickOnLoginButton();
        String ActualMessage = Asloginpage.getSuccessMessage();
        String ExpectedMessage = "Logged in as";
        Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
    }

    @Test(priority = 2)
    public void LoginWithValidEmailAndInvalidPassword() {

        loginPage = homePage.ClickOnSignupLoginPagelink();
        loginPage.insertEmail("Ahmed111@gmail.com");
        loginPage.insertPassword("1233");
        loginPage.ClickOnLoginButton();
        String ActualMessage = loginPage.Getmessage();
        String ExpectedMessage = "Your email or password is incorrect!";
        Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
    }

    @Test(priority = 3)
    public void LoginWithInvalidEmailAndValidPassword() {

        loginPage = homePage.ClickOnSignupLoginPagelink();
        loginPage.insertEmail("AAgg@gmail.com");
        loginPage.insertPassword("123456");
        loginPage.ClickOnLoginButton();
        String ActualMessage = loginPage.Getmessage();
        String ExpectedMessage = "Your email or password is incorrect!";
        Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
    }

    @Test(priority = 4)
    public void LoginWithBlankEmailAndPassword() {

        loginPage = homePage.ClickOnSignupLoginPagelink();
        loginPage.insertEmail("");
        loginPage.insertPassword("");
        loginPage.ClickOnLoginButton();
        String ActualMessage = loginPage.Getmessage();
        String ExpectedMessage = "Your email or password is incorrect!";
        Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
    }

    @Test(priority = 5)
    public void LoginWithBlankEmail() {

        loginPage = homePage.ClickOnSignupLoginPagelink();
        loginPage.insertEmail("");
        loginPage.insertPassword("1233");
        loginPage.ClickOnLoginButton();
        String ActualMessage = loginPage.Getmessage();
        String ExpectedMessage = "Your email or password is incorrect!";
        Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
    }

    @Test(priority = 6)
    public void LoginWithBlankPassword() {

        loginPage = homePage.ClickOnSignupLoginPagelink();
        loginPage.insertEmail("Ahmed111@gmail.com");
        loginPage.insertPassword("");
        loginPage.ClickOnLoginButton();
        String ActualMessage = loginPage.Getmessage();
        String ExpectedMessage = "Your email or password is incorrect!";
        Assert.assertTrue(ActualMessage.contains(ExpectedMessage));
    }

    @Test(priority = 7)
    public void Logout() {
        ValidLogin();
        homePage=Asloginpage.LogoutLink();
    }


}
