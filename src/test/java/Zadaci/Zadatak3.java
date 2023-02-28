package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) {

        //Zadatak 3
        //Otici na Google
        //Zatim ukucati "Wikipedia" u polje za pretragu
        //Odraditi pretragu i otvoriti stranicu
        //Na stranici Wikipedia pretraziti "Nikola Tesla"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com/");

        WebElement googleSearchBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        googleSearchBox.sendKeys("Wikipedia");
        googleSearchBox.sendKeys(Keys.ENTER);

        WebElement wiki = driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        wiki.click();

        WebElement wikiSearchBox = driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input"));
        wikiSearchBox.sendKeys("Nikola Tesla");
        wikiSearchBox.sendKeys(Keys.ENTER);

        driver.quit();

    }
}
