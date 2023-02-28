package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class D_15 {

    // Prethodni zadatak za dodavanje knjiga uraditi koristeci Anotacije. Da jedan test bude sa dodavanjem jedne
    // knjige, drugi test sa dodavanjem dve knjige, treci sa tri itd.


    WebDriver driver;
    String validUser = "qwert";
    String validPass = "Qwerty123!";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/profile");
        Cookie userName = new Cookie("userName", "qwert");
        driver.manage().addCookie(userName);
        Cookie userID = new Cookie("userID", "a95a2c21-4fe0-4a86-8f52-5ca109e7fba8");
        driver.manage().addCookie(userID);
        Cookie expires = new Cookie("expires", "2023-01-22T23%3A22%3A30.334Z");
        driver.manage().addCookie(expires);
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InF3ZXJ0IiwicGFzc3dvcmQiOiJRd2VydHkxMjMhIiwiaWF0IjoxNjczODI0OTUwfQ.1inuq1P9_Yh49dVLS0xGPGtU-w2PeGvTf9ovSv-UV_4");
        driver.manage().addCookie(token);
        driver.navigate().refresh();
    }

    @BeforeMethod
    public void pageSetUp() {
        boolean bttn = false;
        try {
            WebElement dltBttn = driver.findElement(By.id("delete-record-undefined"));
            bttn = dltBttn.isDisplayed();
        } catch (Exception a) {
        }
        Assert.assertFalse(bttn);
    }

    @Test
    public void add1Book() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 300)");
        WebElement goToStore = driver.findElement(By.id("gotoStore"));
        goToStore.click();

        Thread.sleep(1000);
        List<WebElement> knjige = driver.findElements(By.className("action-buttons"));
        knjige.get(0).click();

        jse.executeScript("scroll(0, 300)");
        Thread.sleep(1000);

        WebElement addToColl = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToColl.click();

        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(3000);
        WebElement knjiga1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(knjiga1.isDisplayed());
    }

    @Test
    public void add2Books() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        Thread.sleep(1000);
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
        Thread.sleep(1000);
        knjige = driver.findElements(By.className("action-buttons"));
        knjige.get(1).click();

        jse.executeScript("scroll(0, 300)");
        addToColl = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToColl.click();

        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(3000);
        WebElement knjiga1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(knjiga1.isDisplayed());

        WebElement knjiga2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        Assert.assertTrue(knjiga2.isDisplayed());
    }

    @Test
    public void add3Books() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
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

        driver.navigate().back();
        jse.executeScript("scroll(0, 200)");
        knjige = driver.findElements(By.className("action-buttons"));
        knjige.get(2).click();

        jse.executeScript("scroll(0, 300)");
        addToColl = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToColl.click();

        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(3000);
        WebElement knjiga1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        Assert.assertTrue(knjiga1.isDisplayed());

        WebElement knjiga2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        Assert.assertTrue(knjiga2.isDisplayed());

        WebElement knjiga3 = driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"));
    }

    @AfterMethod
    public void cleanUp() {
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
    }

    @AfterClass
    public void end() {
        driver.quit();
    }
}