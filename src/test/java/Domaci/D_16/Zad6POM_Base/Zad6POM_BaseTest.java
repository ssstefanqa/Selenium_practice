package Domaci.D_16.Zad6POM_Base;

import Domaci.D_16.Zad6POM_Pages.Zad6POM_HomePage;
import Domaci.D_16.Zad6POM_Pages.Zad6POM_LoginPage;
import Domaci.D_16.Zad6POM_Pages.Zad6POM_ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Zad6POM_BaseTest {

    public WebDriver driver;
    public Zad6POM_HomePage Zad6POM_HomePage;
    public Domaci.D_16.Zad6POM_Pages.Zad6POM_LoginPage Zad6POM_LoginPage;
    public Domaci.D_16.Zad6POM_Pages.Zad6POM_ProfilePage Zad6POM_ProfilePage;

    @BeforeClass
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Zad6POM_HomePage = new Zad6POM_HomePage(driver);
        Zad6POM_LoginPage = new Zad6POM_LoginPage(driver);
        Zad6POM_ProfilePage = new Zad6POM_ProfilePage(driver);
    }

    @AfterClass
    public void shutDown() {
        //driver.quit();
    }
}
