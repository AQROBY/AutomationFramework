package Pages;

import LoggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertWindowFramePage extends BasePage{
    public AlertWindowFramePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
        public WebElement alertField;

    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesField;

    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindowField;

    public void navigateToAlertPage(){
        elementMethods.scrollElementByPixel(0, 150);
        LoggerUtility.infoTest("The user scrolls down the page.");
        elementMethods.clickElement(alertField);
        LoggerUtility.infoTest("The user clicks on alert field element.");
    }

    public void navigateToFramePage(){
        elementMethods.scrollElementByPixel(0, 150);
        LoggerUtility.infoTest("The user scrolls down the page.");
        elementMethods.clickElement(framesField);
        LoggerUtility.infoTest("The user clicks on frames field element.");
    }

    public void navigateToWindowPage(){
        elementMethods.scrollElementByPixel(0, 150);
        LoggerUtility.infoTest("The user scrolls down the page.");
        elementMethods.clickElement(browserWindowField);
        LoggerUtility.infoTest("The user clicks on browserWindow field element.");
    }

}
