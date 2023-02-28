package POM_Projects.HerokuApp_D_17.HerokuAppTests;

import POM_Projects.HerokuApp_D_17.HerokuAppBase.HerokuAppBaseTest;
import POM_Projects.HerokuApp_D_17.HerokuAppPages.HerokuAppLoginPage;
import POM_Projects.HerokuApp_D_17.HerokuAppPages.HerokuAppLogoutPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuAppLoginTest extends HerokuAppBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(LoginURL);
        herokuAppLoginPage = new HerokuAppLoginPage();
        herokuAppLogoutPage = new HerokuAppLogoutPage();
    }

    @Test (priority = 10)
    public void userCanLogIn() {
        herokuAppLoginPage.insertUsername(validUsername());
        herokuAppLoginPage.inserPassword(validPassword());
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLogoutPage.getNotificationText(), "You logged into a secure area!\n" + "×");
    }

    @Test (priority = 20)
    public void userCannotLogInWithInvalidUserName() {
        herokuAppLoginPage.insertUsername(invalidUsername());
        herokuAppLoginPage.inserPassword(validPassword());
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorNotificationText(), "Your username is invalid!\n" + "×");
    }

    @Test (priority = 30)
    public void userCannotLogInWithInvalidPassword() {
        herokuAppLoginPage.insertUsername(validUsername());
        herokuAppLoginPage.inserPassword(invalidPassword());
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorNotificationText(), "Your password is invalid!\n" + "×");
    }

    @Test (priority = 40)
    public void userCannotLogInWithInvalidCredentials() {
        for (int i = 1; i < 6; i++) {
            String invalidUsername = excelReader.getStringData("Login", i,2);
            String invalidPassword = excelReader.getStringData("Login", i, 3);
            herokuAppLoginPage.insertUsername(invalidUsername);
            herokuAppLoginPage.inserPassword(invalidPassword);
            herokuAppLoginPage.clickOnLogInButton();
            Assert.assertEquals(herokuAppLoginPage.getErrorNotificationText(), "Your username is invalid!\n" + "×");
        }
    }

    @Test (priority = 50)
    public void userCannotLogInWithBlankUsername() {
        herokuAppLoginPage.getUsername().clear();
        herokuAppLoginPage.inserPassword(validPassword());
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorNotificationText(), "Your username is invalid!\n" + "×");
    }

    @Test (priority = 60)
    public void userCannotLogInWIthBlankPassword() {
        herokuAppLoginPage.insertUsername(validUsername());
        herokuAppLoginPage.getPassword().clear();
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorNotificationText(), "Your password is invalid!\n" + "×");
    }

    @Test (priority = 70)
    public void userCannotLogInWithBlankPasswordAndUsername() {
        herokuAppLoginPage.getUsername().clear();
        herokuAppLoginPage.getPassword().clear();
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorNotificationText(), "Your username is invalid!\n" + "×");
    }

    @AfterMethod
    public void cookieMonster() {
        driver.manage().deleteAllCookies();
    }
}
