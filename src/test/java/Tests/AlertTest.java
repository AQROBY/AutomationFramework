package Tests;

import ObjectData.AlertObject;
import Pages.AlertPage;
import Pages.AlertWindowFramePage;
import Pages.HomePage;
import PropertyUtility.PropertyUtility;
import SharedData.SharedData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AlertTest extends SharedData {

    @Test
    public void frameMethod() {

        //get webdriver tema
        WebDriver webDriver = super.getWebDriver();

        PropertyUtility propertyUtility = new PropertyUtility("AlertData");
        AlertObject alertObject = new AlertObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(webDriver);
        homePage.navigateToAlertFrameWindowPage();

        AlertWindowFramePage alertWindowFramePage = new AlertWindowFramePage(webDriver);
        alertWindowFramePage.navigateToAlertPage();

        AlertPage alertPage = new AlertPage(webDriver);

        alertPage.dealWithAcceptAlert();

        alertPage.dealWithDelayedAlert();

        alertPage.dealWithCancelButton();

        //tema tratat ca in testele cu input data
        alertPage.dealWithPromptButton(alertObject);
    }
}
