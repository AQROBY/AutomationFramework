package Pages;

import ObjectData.WebTableObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends BasePage{
    public WebTablePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "addNewRecordButton")
    private WebElement addField;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "userEmail")
    private WebElement emailField;

    @FindBy(id = "salary")
    private WebElement salaryField;

    @FindBy(id = "age")
    private WebElement ageField;

    @FindBy(id = "department")
    private WebElement departmentField;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitField;

    @FindBy(id = "edit-record-4")
    private WebElement modifyField;

    @FindBy(id = "delete-record-4")
    private WebElement deleteField;


    public void addEntry(WebTableObject webTableObject){
        elementMethods.clickElement(addField);

        elementMethods.fillElement(firstNameField, webTableObject.getFirstNameValue());

        elementMethods.fillElement(lastNameField, webTableObject.getLastNameValue());

        elementMethods.fillElement(emailField, webTableObject.getEmailValue());

        elementMethods.fillElement(ageField, webTableObject.getAgeValue());

        elementMethods.fillElement(salaryField, webTableObject.getSalaryValue());

        elementMethods.fillElement(departmentField, webTableObject.getDepartmentValue());

        elementMethods.clickElement(submitField);
    }

    public void editEntry(WebTableObject webTableObject){
        elementMethods.clickElement(modifyField);

        elementMethods.refillElement(firstNameField, webTableObject.getFirstNameValue());

        elementMethods.refillElement(ageField, webTableObject.getAgeValue());

        elementMethods.clickElement(submitField);
    }

    public void deleteEntry(){
        elementMethods.clickElement(deleteField);
    }
}
