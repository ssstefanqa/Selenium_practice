package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D_12 {
    public static void main(String[] args) throws InterruptedException {

        //Otici na YouTube preko Google-a i pustiti pesmu po Vasem izboru.


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        WebElement googleSearchBox = driver.findElement(By.className("gLFyf"));
        googleSearchBox.sendKeys("Youtube");
        googleSearchBox.sendKeys(Keys.ENTER);

        WebElement youtube = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        youtube.click();

        WebElement youtubeSearchBox = driver.findElement(By.name("search_query"));
        youtubeSearchBox.sendKeys("Avishai Cohen Trio - Shifting Sands Session - ARTE Concert");
        youtubeSearchBox.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        WebElement video1 = driver.findElement(By.cssSelector(".style-scope.ytd-video-renderer"));
        video1.click();

        Thread.sleep(3759000);

        driver.quit();

    }
}

