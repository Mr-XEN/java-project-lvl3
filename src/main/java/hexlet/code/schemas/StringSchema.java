package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;

public class StringSchema {

    boolean result = true;
    int length;
    Object objectToValidate;
    String stringToValidate;
    String stringToContain;
    List<String> listOfTasks = new ArrayList<>();

    public StringSchema required() {
        listOfTasks.add("required");
        return this;
    }

//    public boolean isRequired() {
//        if(listOfTasks.isEmpty()) {
//            setResult(true);
//        } else if(getObjectToValidate() == null && !(getObjectToValidate() instanceof String) && !((String) getObjectToValidate()).isEmpty()) {
//            setResult(false);
//        } else setResult(false);
//        return getResult();
//    }

    public boolean isRequired(Object o) {
        if (o == null) {
            setResult(false);
        } else if(o instanceof String && ((String) o).isEmpty()) {
            setResult(false);
        } else setResult(true);
        return getResult();
    }


    public StringSchema minLength(int length) {
        listOfTasks.add("minLength");
        setLength(length);
        return this;
    }

    public boolean isMinLength(Object o) {
        if(o instanceof String) {
            setResult(getLength() >= ((String) o).length());
        }
        return getResult();
    }


    public StringSchema contains(Object inputStringToContain) {
        listOfTasks.add("contains");
        if (inputStringToContain instanceof String) {
            setStringToContain((String) inputStringToContain);
        }
        return this;
    }

    public boolean isContains(Object object) {
        setResult(getStringToValidate().contains(getStringToContain()));
        return result;
    }

    public boolean isValid(Object object) {
        setObjectToValidate(object);
        if(!listOfTasks.isEmpty()) {
            for (String listOfTask : listOfTasks) {
                switch (listOfTask) {
                    case "required" -> isRequired(object);
                    case "minLength" -> isMinLength(object);

                    //                   case "contains" : isContains(object);
                    default -> throw new Error("Unknown task!");
                }

            }

        } else {
            return getResult();
        }
        return getResult();
    }

    @Override
    public String toString() {
        return "StringSchema{" +
               "result=" + result +
               ", string='" + stringToValidate + '\'' +
               ", length=" + length +
               ", contain='" + stringToContain + '\'' +
               ", list=" + listOfTasks +
               '}';
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getStringToValidate() {
        return stringToValidate;
    }

    public void setStringToValidate(String stringToValidate) {
        this.stringToValidate = stringToValidate;
    }

    public String getStringToContain() {
        return stringToContain;
    }

    public void setStringToContain(String stringToContain) {
        this.stringToContain = stringToContain;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Object getObjectToValidate() {
        return objectToValidate;
    }

    public void setObjectToValidate(Object objectToValidate) {
        this.objectToValidate = objectToValidate;
    }
}
