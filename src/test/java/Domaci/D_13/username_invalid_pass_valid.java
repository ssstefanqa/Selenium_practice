package Domaci.D_13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class username_invalid_pass_valid {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
        WebElement practiceTab = driver.findElement(By.id("menu-item-20"));
        practiceTab.click();
        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("blabla");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password123");

        WebElement submitBttn = driver.findElement(By.id("submit"));
        submitBttn.click();

        WebElement errorMess = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMess.isDisplayed());
        //Assert.assertFalse(errorMess.isDisplayed());

        WebElement usernameField1 = driver.findElement(By.id("username"));
        Assert.assertTrue(usernameField1.isDisplayed());
        //Assert.assertFalse(usernameField1.isDisplayed());

        WebElement passwordField1 = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordField1.isDisplayed());
        //Assert.assertFalse(passwordField1.isDisplayed());

        boolean bttn = false;
        try {
            WebElement logOutbutton = driver.findElement(By.linkText("Log out"));
            bttn = logOutbutton.isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(bttn);

        //Thread.sleep(3000);
        driver.quit();
    }
}
