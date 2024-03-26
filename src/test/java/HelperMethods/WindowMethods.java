package HelperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethods {
    private WebDriver webDriver;

    public WindowMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void switchSpecificTabWindow(int index){
        //trebuie sa identificam numarul de taburi deschise
        List<String> tabsOpened = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabsOpened.get(index));
        System.out.println("Tabul curent are URL-ul " + webDriver.getCurrentUrl());
    }

    public void closeCurrentTabWindow(){
        //inchidem tabul curent = close
        //inchidem browserul = quit
        webDriver.close();
    }
}
