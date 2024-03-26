package HelperMethods;

import org.openqa.selenium.WebDriver;

public class FrameMethods {
    private WebDriver webDriver;

    public FrameMethods(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void switchSpecificIframe(String value){
        //interactionam cu un iframe
        webDriver.switchTo().frame(value);
    }

    public void switchToParent(){
        //specificam sa revina la frameul curent
        webDriver.switchTo().parentFrame();
    }
}
