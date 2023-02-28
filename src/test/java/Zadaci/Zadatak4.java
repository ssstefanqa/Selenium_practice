package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        //Ulogovati se na sajt i proveriti da li smo ulogovani
        // https://practicetestautomation.com/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");

        Thread.sleep(2000);
        WebElement practiceTab = driver.findElement(By.id("menu-item-20"));
        practiceTab.click();

        Thread.sleep(2000);
        WebElement practicePage = driver.findElement(By.xpath("//div[2]/div[1]/div[1]/p/a"));
        practicePage.click();

        WebElement usernameBar = driver.findElement(By.id("username"));
        usernameBar.sendKeys("student");

        WebElement passBar = driver.findElement(By.id("password"));
        passBar.sendKeys("Password123");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement loginHeader = driver.findElement(By.className("post-title"));
        String actualTitle = loginHeader.getText();
        String expectedTitle = "Logged In Successfully";
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement logOutbutton = driver.findElement(By.className("wp-block-button__link has-text-color has-background has-very-dark-gray-background-color"));
        Assert.assertTrue(logOutbutton.isDisplayed());

        driver.quit();

    }
}
