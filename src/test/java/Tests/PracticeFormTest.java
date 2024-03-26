package Tests;

import ObjectData.PracticeFormObject;
import Pages.FormPage;
import Pages.HomePage;
import Pages.PracticeFormPage;
import PropertyUtility.PropertyUtility;
import SharedData.SharedData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest(){

        WebDriver webDriver = super.getWebDriver();

        PropertyUtility propertyUtility = new PropertyUtility("PracticeFormData");
        PracticeFormObject practiceFormObject = new PracticeFormObject(propertyUtility.getAllData());

        HomePage homePage = new HomePage(webDriver);
        FormPage formPage = new FormPage(webDriver);
        PracticeFormPage practiceFormPage = new PracticeFormPage(webDriver);

        homePage.navigateToFormPage();
        formPage.navigateToPracticeForm();

        practiceFormPage.addData(practiceFormObject);
        practiceFormPage.validatePracticeFormTable(practiceFormObject);
    }
}
