package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

        // Izlogovati se sa sajta
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

        // Sledeci deo ne mora da se radi, ne moramo da assertujemo da li smo se uspesno log in-ovali, jer smo to
        // uradili u prethodnom testu, u ovom proveravamo da li mozemo da se izlogujemo
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        WebElement loginHeader = driver.findElement(By.className("post-title"));
        String actualTitle = loginHeader.getText();
        String expectedTitle = "Logged In Successfully";
        Assert.assertEquals(actualTitle, expectedTitle);
        WebElement logOutbutton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutbutton.isDisplayed());
        // -----------------------------------------------------------------------------------------------

        Thread.sleep(2000);

        if (logOutbutton.isDisplayed()) {
            logOutbutton.click();
        } else {
            System.out.println("OH, NO! WE ARE TRAPPED!");
        }

        String expectedURL2 = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL2);

        WebElement usernameBar2 = driver.findElement(By.id("username"));
        Assert.assertTrue(usernameBar2.isDisplayed());

        WebElement passBar2 = driver.findElement(By.id("password"));
        Assert.assertTrue(passBar2.isDisplayed());

        Thread.sleep(3000);
        driver.quit();

    }
}
