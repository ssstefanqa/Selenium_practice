package Domaci.D_16.Zad6POM_Tests;

import Domaci.D_16.Zad6POM_Base.Zad6POM_BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Zad6POM_BaseTest {

    @BeforeMethod
    public void PageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://wordpress.com/");
    }

    @Test
    public void UserCanLogIn() throws InterruptedException {
        Zad6POM_HomePage.clickOnLoginButton();
        Zad6POM_LoginPage.insertUsername("angryichigo");
        Zad6POM_LoginPage.clickContinueButton();
        Zad6POM_LoginPage.insertPassword("okmijnqazwsx123");
        Zad6POM_LoginPage.clickSubmitButton();
        Zad6POM_ProfilePage.assertProfile();
    }
}
