package POM_Projects.HerokuApp_D_17.HerokuAppPages;

import POM_Projects.HerokuApp_D_17.HerokuAppBase.HerokuAppBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppLogoutPage extends HerokuAppBaseTest {
    public HerokuAppLogoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "flash")
    public WebElement Notification;

    //-----------------------

    public String getNotificationText() {
        return Notification.getText();
    }

}
