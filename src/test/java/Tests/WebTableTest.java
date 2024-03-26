package Tests;

import ObjectData.WebTableObject;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.WebTablePage;
import PropertyUtility.PropertyUtility;
import SharedData.SharedData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest(){
        WebDriver webDriver = super.getWebDriver();

        PropertyUtility propertyUtility = new PropertyUtility("WebTableData");
        WebTableObject webTableObject = new WebTableObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(webDriver);
        ElementsPage elementsPage = new ElementsPage(webDriver);
        WebTablePage webTablePage = new WebTablePage(webDriver);

        homePage.navigateToElementsPage();
        elementsPage.navigateToWebTables();

        webTablePage.addEntry(webTableObject);

        webTableObject.setFirstNameValue("Daniel");
        webTableObject.setAgeValue("30");

        webTablePage.editEntry(webTableObject);

        webTablePage.deleteEntry();

    }
}
