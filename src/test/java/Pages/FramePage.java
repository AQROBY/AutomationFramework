package Pages;

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
        elementMethods.printElementText(frameElement);
        //specificam sa revina la frameul curent
        frameMethods.switchToParent();

        frameMethods.switchSpecificIframe("frame2");
        elementMethods.printElementText(frameElement);
    }

}
