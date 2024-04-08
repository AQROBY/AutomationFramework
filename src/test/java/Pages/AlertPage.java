package Pages;

import LoggerUtility.LoggerUtility;
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
        LoggerUtility.infoTest("The user clicks on alert ok element.");

        alertMethods.acceptAlert();
        LoggerUtility.infoTest("The user accepts the alert.");
    }

    public void dealWithDelayedAlert(){
        elementMethods.clickElement(alertTimer);
        LoggerUtility.infoTest("The user clicks on alert timer element.");

        alertMethods.waitForAlert();
        LoggerUtility.infoTest("The user waits for the alert.");

        alertMethods.acceptAlert();
        LoggerUtility.infoTest("The user accepts the alert.");
    }

    public void dealWithCancelButton(){
        elementMethods.clickElement(confirmButton);
        LoggerUtility.infoTest("The user clicks on confirm button element.");

        alertMethods.cancelAlert();
        LoggerUtility.infoTest("The user clicks on cancel alert element.");

        elementMethods.validateElementText(confirmResult, "You selected Cancel");
        LoggerUtility.infoTest("The user validates element text.");
    }

    public void dealWithPromptButton(AlertObject alertObject){
        elementMethods.clickElement(promptAlert);
        LoggerUtility.infoTest("The user clicks on prompt alert element.");

        alertMethods.fillAlert(alertObject.getValue());
        LoggerUtility.infoTest("The user fills the alert element with the following value " +
                alertObject.getValue());

        elementMethods.validateElementText(confirmInputResult, "You entered " +
                alertObject.getValue());
        LoggerUtility.infoTest("The user validates element text.");
    }
}
