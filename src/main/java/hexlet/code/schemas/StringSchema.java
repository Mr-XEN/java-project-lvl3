package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StringSchema {

    private boolean validationResult = true;
    private Object objectToValidate;
    private String stringToValidate;
    private final List<String> listOfTasks = new ArrayList<>();
    private final List<Boolean> listOfResult = new LinkedList<>();
    private final List<Map<String, Object>> listOfRules = new LinkedList<>();

    public final StringSchema required() {
        listOfTasks.add("required");
        listOfRules.add(Map.of("required", "required"));
        return this;
    }

    private void isRequired(Object o) {
        if (o == null) {
            listOfResult.add(false);
        } else if (o instanceof String && ((String) o).isEmpty()) {
            listOfResult.add(false);
        } else {
            listOfResult.add(true);
        }
    }


    public final StringSchema minLength(int length) {
        listOfTasks.add("minLength");
        listOfRules.add(Map.of("minLength", length));
        return this;
    }

    private void isMinLength(Object o, int i) {
        if (o != null && getStringToValidate().length() >= i) {
            listOfResult.add(true);
        } else {
            listOfResult.add(false);
        }
    }


    public final StringSchema contains(Object inputStringToContain) {
        listOfTasks.add("contains");
        if (inputStringToContain instanceof String) {
            listOfRules.add(Map.of("contains", inputStringToContain));
        }
        return this;
    }

    private void isContains(Object object, String inputString) {
        if (object instanceof String) {
            listOfResult.add(getStringToValidate().contains(inputString));
        }
    }

    public final boolean isValid(Object object) {

        if (object instanceof String) {
            setStringToValidate((String) object);
        }

        setObjectToValidate(object);

        if (!listOfTasks.isEmpty()) {
            for (int i = 0; i < listOfTasks.size(); i++) {
                for (Map<String, Object> stringObjectMap : listOfRules) {
                    if (stringObjectMap.containsKey("required")) {
                        isRequired(object);
                    }
                    if (stringObjectMap.containsKey("minLength")) {
                        isMinLength(object, (Integer) stringObjectMap.get("minLength"));
                    }
                    if (stringObjectMap.containsKey("contains")) {
                        isContains(object, (String) stringObjectMap.get("contains"));
                    }
                }
            }
            for (Boolean result : listOfResult) {
                if (!result) {
                    setValidationResult(false);
                    break;
                }
            }
        }
        return getValidationResult();
    }


    private String getStringToValidate() {
        return stringToValidate;
    }

    private void setStringToValidate(String stringOfValidate) {
        this.stringToValidate = stringOfValidate;
    }

    private boolean getValidationResult() {
        return validationResult;
    }

    private void setValidationResult(boolean result2) {
        this.validationResult = result2;
    }

    private void setObjectToValidate(Object objectOfValidate) {
        this.objectToValidate = objectOfValidate;
    }

}
