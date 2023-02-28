package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {

        // Ulogovati se na sajt i proveriti da li smo se ulogovali
        // https://wordpress.com/

        String validUsername = "angryichigo";
        String validPass = "okmijnqazwsx123";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wordpress.com/");

        WebElement logIn = driver.findElement(By.linkText("Log In"));
        logIn.click();

        Thread.sleep(2000);
        WebElement logInBar = driver.findElement(By.id("usernameOrEmail"));
        logInBar.sendKeys(validUsername);

        WebElement continueBttn = driver.findElement(By.className("login__form-action"));
        continueBttn.click();

        Thread.sleep(2000);
        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys(validPass);

        WebElement submitbttn = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        submitbttn.click();

        //--- - - -  -  -  -   -   -   -    -    -    -    = assert =    -    -    -    -   -   -   -  -  -  - - - ---\\

        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://wordpress.com/home/angryichigo.wordpress.com");

        Thread.sleep(5000);
        WebElement sitedomain = driver.findElement(By.className("site__domain"));
        Assert.assertEquals(sitedomain.getText(), "angryichigo.wordpress.com");

        boolean bttn = false;
        try {
            bttn = logInBar.isDisplayed();
        } catch (Exception a) {
        }
        Assert.assertFalse(bttn);

        Thread.sleep(3000);
        driver.quit();
    }
}
