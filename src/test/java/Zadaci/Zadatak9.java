package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak9 {
    public static void main(String[] args) throws InterruptedException {

        // Napraviti meme
        // https://imgflip.com/memegenerator


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://imgflip.com/memegenerator");

        //Thread.sleep(30000);
        WebElement uploadbttn = driver.findElement(By.id("mm-show-upload"));
        uploadbttn.click();

        Thread.sleep(3000);
        WebElement uploadFile = driver.findElement(By.className("hidden-file-input"));
        uploadFile.sendKeys("C:\\Users\\Thinkpad T540p\\Desktop\\New folder\\bkiefall.jpg");

        WebElement finalUpload = driver.findElement(By.id("mm-upload-btn"));
        finalUpload.click();

        List<WebElement> textbox = driver.findElements(By.className("mm-text"));
        textbox.get(0).sendKeys("hmm, what if...");
        textbox.get(1).sendKeys("Test passed");

        WebElement generate = driver.findElement(By.cssSelector(".mm-generate.b.but"));
        generate.click();

    }
}
