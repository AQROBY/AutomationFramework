package Pages;

import ObjectData.AlertObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{
    public AlertPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertOk;

    @FindBy(id = "timerAlertButton")
    private WebElement alertTimer;

    @FindBy(id = "promtButton")
    private WebElement promptAlert;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    @FindBy(id = "confirmResult")
    private WebElement confirmResult;

    @FindBy(id = "promptResult")
    private WebElement confirmInputResult;

    public void dealWithAcceptAlert(){
        elementMethods.clickElement(alertOk);
        alertMethods.acceptAlert();
    }

    public void dealWithDelayedAlert(){
        elementMethods.clickElement(alertTimer);
        alertMethods.waitForAlert();
        alertMethods.acceptAlert();
    }

    public void dealWithCancelButton(){
        elementMethods.clickElement(confirmButton);
        alertMethods.cancelAlert();
        elementMethods.validateElementText(confirmResult, "You selected Cancel");
    }

    public void dealWithPromptButton(AlertObject alertObject){
        elementMethods.clickElement(promptAlert);
        alertMethods.fillAlert(alertObject.getValue());
        elementMethods.validateElementText(confirmInputResult, "You entered " +
                alertObject.getValue());
    }
}
