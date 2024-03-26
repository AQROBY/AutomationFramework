package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends BasePage{
    public FormPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceFormField;

    public void navigateToPracticeForm(){
        elementMethods.scrollElementByPixel(0, 150);
        elementMethods.clickElement(practiceFormField);
    }
}
