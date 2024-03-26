package Tests;

import Pages.AlertWindowFramePage;
import Pages.FramePage;
import Pages.HomePage;
import SharedData.SharedData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FrameTest extends SharedData {

    @Test
    public void frameMethod() {

        WebDriver webDriver = super.getWebDriver();

        HomePage homePage = new HomePage(webDriver);
        homePage.navigateToAlertFrameWindowPage();

        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(webDriver);
        alertWindowFramePage.navigateToFramePage();

        FramePage framePage = new FramePage(webDriver);
        framePage.dealWithFrame();
    }
}
