package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) {

        //Zadatak 1
        //Pokrenite browser, idite na Linkedin sajt, uradite refresh, idite na Joberty sajt
        //vratite se nazad i odstampajte poslednji URL na kom se nalazite
        //na kraju zatvorite driver

        WebDriverManager.chromedriver().setup();
        WebDriver Driver = new ChromeDriver();
        Driver.manage().window().maximize();
        Driver.navigate().to("https://www.linkedin.com/");
        Driver.navigate().refresh();
        Driver.navigate().to("https://www.joberty.rs/");
        Driver.navigate().back();
        System.out.println(Driver.getCurrentUrl());
        Driver.quit();

    }
}
