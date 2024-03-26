package Pages;

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
        //elementMethods.clickElement(consentField);
        elementMethods.clickElement(windowField);
    }

    public void navigateToFormPage(){
        elementMethods.scrollElementByPixel(0, 450);
        elementMethods.clickElement(formField);
    }

    public void navigateToElementsPage(){
        elementMethods.scrollElementByPixel(0, 450);
        elementMethods.clickElement(elementsField);
    }
}
