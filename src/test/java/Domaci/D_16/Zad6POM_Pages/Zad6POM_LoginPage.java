package Domaci.D_16.Zad6POM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Zad6POM_LoginPage {

    public WebDriver driver;
    WebElement usernameField;
    WebElement continueButton;
    WebElement passwordField;
    WebElement submitButton;

    public Zad6POM_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("usernameOrEmail"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.className("login__form-action"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.cssSelector(".button.form-button.is-primary"));
    }


    // -------------------------- actions -------------------------- \\


    public void insertUsername(String username) throws InterruptedException {
        //wdwait.until(ExpectedConditions.elementToBeClickable(getUsernameField()));
        Thread.sleep(1000);
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void clickContinueButton () {
        getContinueButton().click();
    }

    public void insertPassword(String password) throws InterruptedException {
        Thread.sleep(1000);
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickSubmitButton() {
        getSubmitButton().click();
    }
}
