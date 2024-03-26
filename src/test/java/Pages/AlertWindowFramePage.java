package Pages;

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
        elementMethods.clickElement(alertField);
    }

    public void navigateToFramePage(){
        elementMethods.scrollElementByPixel(0, 150);
        elementMethods.clickElement(framesField);
    }

    public void navigateToWindowPage(){
        elementMethods.scrollElementByPixel(0, 150);
        elementMethods.clickElement(browserWindowField);
    }

}
