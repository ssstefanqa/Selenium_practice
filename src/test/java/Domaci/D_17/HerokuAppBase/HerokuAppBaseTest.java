package POM_Projects.HerokuApp_D_17.HerokuAppBase;

import POM_Projects.HerokuApp_D_17.HerokuAppPages.HerokuAppLoginPage;
import POM_Projects.HerokuApp_D_17.HerokuAppPages.HerokuAppLogoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class HerokuAppBaseTest {
    public static WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String LoginURL;
    public HerokuAppLoginPage herokuAppLoginPage;
    public HerokuAppLogoutPage herokuAppLogoutPage;

    public String validUsername() {
        return excelReader.getStringData("Login", 1, 0);
    }

    public String validPassword() {
        return excelReader.getStringData("Login", 1, 1);
    }

    public String invalidPassword() {
        return excelReader.getStringData("Login", 1, 3);
    }

    public String invalidUsername() {
        return excelReader.getStringData("Login", 1, 2);
    }

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/java/POM_Projects/P4_HerokuApp/TestData.xlsx");
        LoginURL = excelReader.getStringData("URL", 1, 0);
    }

    @AfterClass
    public void eatAndQuit() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
