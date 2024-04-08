package Pages;

import LoggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  BasePage{

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(className = "fc-button-label")
    private WebElement consentField;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement windowField;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formField;

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsField;

    public void navigateToAlertFrameWindowPage(){
        elementMethods.scrollElementByPixel(0, 450);
        LoggerUtility.infoTest("The user scrolls down the page.");
        //elementMethods.clickElement(consentField);
        elementMethods.clickElement(windowField);
        LoggerUtility.infoTest("The user clicks on window field element.");
    }

    public void navigateToFormPage(){
        elementMethods.scrollElementByPixel(0, 450);
        LoggerUtility.infoTest("The user scrolls down the page.");
        elementMethods.clickElement(formField);
        LoggerUtility.infoTest("The user clicks on form field element.");
    }

    public void navigateToElementsPage(){
        elementMethods.scrollElementByPixel(0, 450);
        LoggerUtility.infoTest("The user scrolls down the page.");
        elementMethods.clickElement(elementsField);
        LoggerUtility.infoTest("The user clicks on elements field element.");
    }
}
