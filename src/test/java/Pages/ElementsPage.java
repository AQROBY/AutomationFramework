package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage{
    public ElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTablesField;

    public void navigateToWebTables(){
        elementMethods.scrollElementByPixel(0, 150);
        elementMethods.clickElement(webTablesField);
    }
}
