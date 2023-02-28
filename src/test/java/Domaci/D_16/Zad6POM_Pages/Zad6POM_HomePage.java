package Domaci.D_16.Zad6POM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Zad6POM_HomePage {

    public WebDriver driver;
    WebElement logInButton;

    public Zad6POM_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogInButton() {
        return driver.findElement(By.linkText("Log In"));
    }


    // -------------------------- actions -------------------------- \\


    public void clickOnLoginButton() {
        getLogInButton().click();
    }
}
