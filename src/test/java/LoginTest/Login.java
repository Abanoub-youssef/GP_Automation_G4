package LoginTest;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.SecureAreaPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends BaseTest {
//    LoginPage loginPage;
//    @Test(priority = 1)
//    public void  testLoginSuccess(){
//
//      loginPage =  homePage.openLoginPage();
//        loginPage.enterUsername("tomsmith");
//        loginPage.enterPassword("SuperSecretPassword");
//        SecureAreaPage secureAreaPage = loginPage.clickLogin();
//        String actualResult = secureAreaPage.getSuccessMessage();
//        String expectedResult ="You logged into a secure area!";
//        System.out.println(actualResult);
//        Assert.assertTrue(actualResult.contains(expectedResult));
//
//
//    }
//
//    @Test(priority = 2)
//    public void testIncorrectUserName(){
//
//
//        loginPage =  homePage.openLoginPage();
//        loginPage.enterUsername("tomsmith");
//        loginPage.enterPassword("SuperSecretPassword");
//        loginPage.clickLogin();
//        String actualResult = loginPage.getErrorMessage();
//
//        String expectedResult ="tom";
//        System.out.println(actualResult);
//        Assert.assertTrue(actualResult.contains(expectedResult));
//
//
//    }
//
//    @Test(priority = 3)
//    public void testIncorrectPassword(){
//
//        loginPage =  homePage.openLoginPage();
//        loginPage.enterUsername("tomsmith");
//        loginPage.enterPassword("SuperSecretPassword");
//        loginPage.clickLogin();
//
//        String actualResult = loginPage.getErrorMessage();
//        String expectedResult ="SuperSecret";
//        System.out.println(actualResult);
//        Assert.assertTrue(actualResult.contains(expectedResult));
//
//
//    }
}
