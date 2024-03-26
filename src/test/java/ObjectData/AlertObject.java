package ObjectData;

import java.util.Map;

public class AlertObject {
    private String value = "Robert";

    public AlertObject(Map<String, String> testData){
        prepareObject(testData);
    }

    private void prepareObject(Map<String, String> testData){
        for (String key : testData.keySet()){
            switch (key){
                case "value":
                    setValue(testData.get(key));
                    break;
            }
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
