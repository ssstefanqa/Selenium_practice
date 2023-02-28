package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) {

        //Zadatak 2
        //Otvoriti browser i jos 5 tabova
        //Na svakom tabu otvoriti URL po zelji
        //Zatvoriti sve tabove osim onog gde je otvoren Google

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(listaTabova.get(0));
        driver.navigate().to("https://www.google.com/");
        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("https://www.youtube.com/");
        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.joberty.rs/");
        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("https://www.linkedin.com/");
        driver.switchTo().window(listaTabova.get(4));
        driver.navigate().to("https://www.facebook.com/");
        driver.switchTo().window(listaTabova.get(5));
        driver.navigate().to("https://zty.pe/");

        for (int i = 1; i < listaTabova.size(); i++) {
            driver.switchTo().window(listaTabova.get(i)).close();
        }

        driver.quit();
    }
}
