package SharedData;

import LoggerUtility.LoggerUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends SharedData{

    private String testName;


    @BeforeMethod
    public void prepareEnvironment(){
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestCase(testName);
        prepareDriver();
        LoggerUtility.infoTest("The driver is open successfully.");
    }

    @AfterMethod
    public void clearEnvironment(){
        clearDriver();
        LoggerUtility.infoTest("The driver is closes successfully.");
        LoggerUtility.finishTestCase(testName);
    }
}
