package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Zadatak10 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void userCanLogIn() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password123");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());
        WebElement notification = driver.findElement(By.className("post-title"));
        Assert.assertEquals(notification.getText(), "Logged In Successfully");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");
    }

    @Test
    public void userCanLogOut() {

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password123");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        logOutButton.click();
        WebElement usernameField1 = driver.findElement(By.id("username"));
        Assert.assertTrue(usernameField1.isDisplayed());
        WebElement passwordField1 = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordField1.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void invalidLogInName() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student123");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password123");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        WebElement usernameField1 = driver.findElement(By.id("username"));
        Assert.assertTrue(usernameField1.isDisplayed());
        WebElement passwordField1 = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordField1.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void invalidPassword() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        WebElement usernameField1 = driver.findElement(By.id("username"));
        Assert.assertTrue(usernameField1.isDisplayed());
        WebElement passwordField1 = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordField1.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void invalidPassAndUsername() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student123");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        WebElement usernameField1 = driver.findElement(By.id("username"));
        Assert.assertTrue(usernameField1.isDisplayed());
        WebElement passwordField1 = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordField1.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void blankUsername() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        WebElement usernameField1 = driver.findElement(By.id("username"));
        Assert.assertTrue(usernameField1.isDisplayed());
        WebElement passwordField1 = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordField1.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void blankPassword() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        WebElement usernameField1 = driver.findElement(By.id("username"));
        Assert.assertTrue(usernameField1.isDisplayed());
        WebElement passwordField1 = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordField1.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void blankPassAndBlankUsername() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        WebElement usernameField1 = driver.findElement(By.id("username"));
        Assert.assertTrue(usernameField1.isDisplayed());
        WebElement passwordField1 = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordField1.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @AfterMethod
    public void cookiemonster() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void kraj(){
        driver.quit();
    }
}