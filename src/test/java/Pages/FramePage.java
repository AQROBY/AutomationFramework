package Pages;

import LoggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage{
    public FramePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "sampleHeading")
    public WebElement frameElement;

    public void dealWithFrame(){
        //interactionam cu un iframe
        frameMethods.switchSpecificIframe("frame1");
        LoggerUtility.infoTest("The user switches to a specific frame - frame1.");

        elementMethods.printElementText(frameElement);
        LoggerUtility.infoTest("The user prints a frame element.");

        //specificam sa revina la frameul curent
        frameMethods.switchToParent();
        LoggerUtility.infoTest("The user switches back to the default frame.");

        frameMethods.switchSpecificIframe("frame2");
        LoggerUtility.infoTest("The user switches to a specific frame - frame2.");

        elementMethods.printElementText(frameElement);
        LoggerUtility.infoTest("The user prints a frame element.");
    }

}
