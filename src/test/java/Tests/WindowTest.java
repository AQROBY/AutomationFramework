package Tests;

import Pages.AlertWindowFramePage;
import Pages.HomePage;
import Pages.WindowPage;
import SharedData.SharedData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WindowTest extends SharedData {

    @Test
    public void windowMethod(){
        WebDriver webDriver = super.getWebDriver();

        HomePage homePage = new HomePage(webDriver);
        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(webDriver);
        WindowPage windowPage = new WindowPage(webDriver);

        homePage.navigateToAlertFrameWindowPage();

        alertWindowFramePage.navigateToWindowPage();

        windowPage.interactWithTabBrowser();

        windowPage.interactNewWindow();
    }
}
