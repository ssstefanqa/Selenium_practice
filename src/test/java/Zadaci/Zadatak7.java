package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak7 {
    public static void main(String[] args) throws InterruptedException {
        // NEZAVRSEN ! ! !
        // Zadatak 7 - Ulogovati se na sajt https://demoqa.com/ preko kolacica,
        // izlogovati se i asertovati da je korisnik izlogovan


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/profile");

        //Cookie userName = new Cookie("userName", "qwert");
        Cookie userID = new Cookie("userID", "a95a2c21-4fe0-4a86-8f52-5ca109e7fba8");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InF3ZXJ0IiwicGFzc3dvcmQiOiJRd2VydHkxMjMhIiwiaWF0IjoxNjczNTUxNzgxfQ.QlUyihYXQUHXylx7b4w0I99f8HyhsRe4XppoWeVRC7w");
        Cookie expires = new Cookie("expires", "2023-01-19T19%3A37%3A32.919Z");

        Thread.sleep(3000);

        //driver.manage().addCookie(userName);
        driver.manage().addCookie(userID);
        driver.manage().addCookie(token);
        driver.manage().addCookie(expires);

        driver.navigate().refresh();

    }
}
