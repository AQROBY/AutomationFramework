package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementMethods {
    private WebDriver webDriver;

    public ElementMethods(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void scrollElementByPixel(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(" + x + ", " + y + ")", "");
    }

    public void waitForVisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element){
        waitForVisibleElement(element);
        element.click();
    }

    public void validateElementText(WebElement webElement, String expected){
        waitForVisibleElement(webElement);
        String actual = webElement.getText();
        Assert.assertEquals(actual, expected);
    }

    public void printElementText(WebElement webElement){
        waitForVisibleElement(webElement);
        System.out.println(webElement.getText());
    }

    public void fillElement(WebElement webElement, String value){
        waitForVisibleElement(webElement);
        webElement.sendKeys(value);
    }

    public void refillElement(WebElement webElement, String value){
        waitForVisibleElement(webElement);
        webElement.clear();
        webElement.sendKeys(value);
    }

    public void selectTextElement(WebElement webElement, String value){
        waitForVisibleElement(webElement);
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
    }

    public void selectValueElement(WebElement webElement, String value){
        waitForVisibleElement(webElement);
        Select select = new Select(webElement);
        select.selectByValue(value);
    }

    public void fillPressElement(WebElement webElement, String value, Keys key){
        waitForVisibleElement(webElement);
        webElement.sendKeys(value);
        webElement.sendKeys(key);
    }

    public void forceClick(WebElement webElement){
        waitForVisibleElement(webElement);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webElement);
    }
}
