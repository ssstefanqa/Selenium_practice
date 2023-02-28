package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.List;

public class D_14 {
    public static void main(String[] args) throws InterruptedException {

        // Ulogujte se na demoqa preko cookies-a, dodati dve knjige na svoj nalog, zatim se izlogovati brisanjem cookies-a.
        // Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.

        String validUser = "qwert";
        String validPass = "Qwerty123!";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/profile");

        Cookie userName = new Cookie("userName", "qwert");
        driver.manage().addCookie(userName);
        Cookie userID = new Cookie("userID", "a95a2c21-4fe0-4a86-8f52-5ca109e7fba8");
        driver.manage().addCookie(userID);
        Cookie expires = new Cookie("expires", "2023-01-22T16%3A09%3A32.844Z");
        driver.manage().addCookie(expires);
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InF3ZXJ0IiwicGFzc3dvcmQiOiJRd2VydHkxMjMhIiwiaWF0IjoxNjczNzk4OTcyfQ.hOd1FfqtpTopr0fUflPRgkRAo6BMKFjmByMdGKvUWKk");
        driver.manage().addCookie(token);
        driver.navigate().refresh();

        boolean bool = true;
        do {
            try {
                WebElement dltBttn = driver.findElement(By.id("delete-record-undefined"));
            } catch (Exception e) {
                bool = false;
            }
            if (bool) {
                WebElement dltBttn = driver.findElement(By.id("delete-record-undefined"));
                dltBttn.click();
                WebElement dltOK = driver.findElement(By.id("closeSmallModal-ok"));
                dltOK.click();
                driver.navigate().refresh();
            }
        } while (bool);

        jse.executeScript("scroll(0, 300)");
        WebElement goToStore = driver.findElement(By.id("gotoStore"));
        goToStore.click();

        Thread.sleep(1000);
        List<WebElement> knjige = driver.findElements(By.className("action-buttons"));
        knjige.get(0).click();

        jse.executeScript("scroll(0, 300)");
        WebElement addToColl = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToColl.click();

        driver.navigate().back();

        knjige = driver.findElements(By.className("action-buttons"));
        knjige.get(1).click();

        jse.executeScript("scroll(0, 300)");
        addToColl = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToColl.click();

        driver.navigate().refresh();
        driver.manage().deleteCookieNamed("expires");
        driver.manage().deleteCookieNamed("token");
        driver.navigate().refresh();

        Thread.sleep(1000);
        WebElement loginBttn = driver.findElement(By.id("login"));
        loginBttn.click();

        Thread.sleep(1000);
        WebElement userField = driver.findElement(By.id("userName"));
        userField.sendKeys(validUser);

        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys(validPass);

        loginBttn = driver.findElement(By.id("login"));
        loginBttn.click();

        Thread.sleep(1000);
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        Thread.sleep(1000);
        knjige = driver.findElements(By.className("action-buttons"));
        Assert.assertTrue(knjige.get(0).isDisplayed());
        Assert.assertTrue(knjige.get(1).isDisplayed());
    }
}
