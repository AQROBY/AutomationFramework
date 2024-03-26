package Pages;

import ObjectData.PracticeFormObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage{
    public PracticeFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameField;

    @FindBy(css = "input[placeholder='name@example.com']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    private WebElement phoneField;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement genderField;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthField;

    @FindBy(css = ".react-datepicker__month-select")
    private WebElement monthDateOfBirthField;

    @FindBy(css = ".react-datepicker__year-select")
    private WebElement yearDateOfBirthField;

    @FindBy(xpath = "//div[not(contains(@class, 'react-datepicker__day--outside-month')) " +
            "and contains(@class, 'react-datepicker__day react-datepicker__day')]")
    private List<WebElement> dayDateOfBirthFields;

    @FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class='custom-control-label']")
    private List<WebElement> listaHobbyuri;

    @FindBy(id = "subjectsInput")
    private WebElement subjectField;

    @FindBy(id = "uploadPicture")
    private WebElement pictureField;

    @FindBy(css = "textarea[placeholder=\"Current Address\"]")
    private WebElement addressField;

    @FindBy(xpath = "//div[text()='Select State']")
    private WebElement stateField;

    @FindBy(id = "react-select-3-input")
    private WebElement subjectInputField;

    @FindBy(xpath = "//div[text()='Select City']")
    private WebElement cityField;

    @FindBy(id = "react-select-4-input")
    private WebElement cityInputField;

    @FindBy(id = "submit")
    private WebElement submitField;

    @FindBy(xpath = "//table/tbody/tr/td[1]")
    private List<WebElement> labelFields;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    private List<WebElement> valueFields;

    public void fillFirstName(String firstNameValue){
        elementMethods.fillElement(firstNameField, firstNameValue);
    }

    public void fillLastName(String lastNameValue){
        elementMethods.fillElement(lastNameField, lastNameValue);
    }

    public void fillEmailField(String emailValue){
        elementMethods.fillElement(emailField, emailValue);
    }

    public void fillPhoneField(String phoneValue){
        elementMethods.fillElement(phoneField, phoneValue);
    }

    public void clickGenderField(){
        elementMethods.clickElement(genderField);
    }

    public void pickBirthDate(String monthValue, String yearValue, String dayValue){
        elementMethods.clickElement(dateOfBirthField);
        elementMethods.selectTextElement(monthDateOfBirthField, monthValue);
        elementMethods.selectValueElement(yearDateOfBirthField, yearValue);

        for (Integer i = 0; i < dayDateOfBirthFields.size(); i++){
            if(dayDateOfBirthFields.get(i).getText().equals(dayValue)){
                dayDateOfBirthFields.get(i).click();
                break;
            }
        }
    }

    public void pickHobbies(List<String> hobbyuri){
        for(int i = 0; i < listaHobbyuri.size(); i++){
            String currentElementText = listaHobbyuri.get(i).getText();
            if (hobbyuri.contains(currentElementText)){
                elementMethods.forceClick(listaHobbyuri.get(i));
            }
        }
    }

    public void pickSubject(String subjectValue){
        elementMethods.fillPressElement(subjectField, subjectValue, Keys.ENTER);
    }

    public void uploadPicture(String filePath){
        elementMethods.fillElement(pictureField, new File(filePath).getAbsolutePath());
    }

    public void pickAddress(String addressValue){
        elementMethods.fillElement(addressField, addressValue);
    }

    public void fillState(String stateValue){
        elementMethods.forceClick(stateField);
        elementMethods.fillPressElement(subjectInputField, stateValue, Keys.ENTER);
    }

    public void fillCity(String cityInputValue){
        elementMethods.forceClick(cityField);
        elementMethods.fillPressElement(cityInputField, cityInputValue, Keys.ENTER);
    }

    public void submit(){
        elementMethods.forceClick(submitField);
    }

    public void validatePracticeFormTable(PracticeFormObject practiceFormObject){
        Assert.assertEquals(labelFields.get(0).getText(), "Student Name");
        Assert.assertEquals(valueFields.get(0).getText(),practiceFormObject.getFirstNameValue()
                + " " + practiceFormObject.getLastNameValue());

        Assert.assertEquals(labelFields.get(1).getText(), "Student Email");
        Assert.assertEquals(valueFields.get(1).getText(), practiceFormObject.getEmailValue());

        Assert.assertEquals(labelFields.get(2).getText(), "Gender");
        Assert.assertEquals(valueFields.get(2).getText(), practiceFormObject.getGenderValue());

        Assert.assertEquals(labelFields.get(3).getText(), "Mobile");
        Assert.assertEquals(valueFields.get(3).getText(), practiceFormObject.getPhoneValue());

        Assert.assertEquals(labelFields.get(5).getText(), "Subjects");
        Assert.assertEquals(valueFields.get(5).getText(), practiceFormObject.getSubjectValue());

        Assert.assertEquals(labelFields.get(6).getText(), "Hobbies");
        for (int i = 0; i < practiceFormObject.getHobbyuri().size(); i++){
            Assert.assertTrue(valueFields.get(6).getText().contains(
                    practiceFormObject.getHobbyuri().get(i)));
        }

        Assert.assertEquals(labelFields.get(7).getText(), "Picture");
        String[] filePathArr = practiceFormObject.getFilePath().split("/");
        int desiredIndex = filePathArr.length - 1;
        Assert.assertEquals(valueFields.get(7).getText(), filePathArr[desiredIndex]);
    }

    public void addData(PracticeFormObject practiceFormObject){
        fillFirstName(practiceFormObject.getFirstNameValue());
        fillLastName(practiceFormObject.getLastNameValue());
        fillEmailField(practiceFormObject.getEmailValue());
        fillPhoneField(practiceFormObject.getPhoneValue());
        clickGenderField();
        pickBirthDate(practiceFormObject.getMonthValue(), practiceFormObject.getYearValue(),
                practiceFormObject.getDayValue());
        pickHobbies(practiceFormObject.getHobbyuri());
        pickSubject(practiceFormObject.getSubjectValue());
        uploadPicture(practiceFormObject.getFilePath());
        pickAddress(practiceFormObject.getAddressValue());
        fillState(practiceFormObject.getStateValue());
        fillCity(practiceFormObject.getCityValue());
        submit();
    }
}
