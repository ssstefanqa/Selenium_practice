package Domaci.D_16.Zad6POM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Zad6POM_ProfilePage {

    public WebDriver driver;
    WebElement siteDomain;

    public Zad6POM_ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSiteDomain() {
        return driver.findElement(By.className("site__domain"));
    }

    // -------------------------- actions -------------------------- \\

    public void assertProfile() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(getSiteDomain().getText(), "angryichigo.wordpress.com");
    }
}
