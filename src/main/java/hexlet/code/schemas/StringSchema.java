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
    List<Integer> listOfMinLength = new ArrayList<>();
    List<Boolean> listOfResult = new ArrayList<>();

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

    private boolean isRequired(Object o) {
        if (o == null) {
            setResult(false);
        } else if (o instanceof String && ((String) o).isEmpty()) {
            setResult(false);
        } else setResult(true);
        return getResult();
    }


    public StringSchema minLength(int length) {
        listOfTasks.add("minLength");
        listOfMinLength.add(length);
        return this;
    }

    private boolean isMinLength(Object o, int i) {
        for (int j = 0; j < listOfMinLength.size(); j++) {
            if (getStringToValidate().length() >= listOfMinLength.get(i)) {
                listOfResult.add(true);
            } else listOfResult.add(false);
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

    private boolean isContains(Object object) {
        setResult(getStringToValidate().contains(getStringToContain()));
        return result;
    }

    public boolean isValid(Object object) {
        if (object instanceof String) {
            setStringToValidate((String) object);
        }
        setObjectToValidate(object);
        if (!listOfTasks.isEmpty()) {
            for (int i = 0; i < listOfTasks.size(); i++) {
                switch (listOfTasks.get(i)) {
                    case "required" -> isRequired(object);
                    case "minLength" -> isMinLength(object,i);
                    default -> throw new Error("Unknown task!");
                }
            }
            for (int i = 0; i < listOfResult.size(); i++) {
              if(listOfResult.get(i) == false) {
                  setResult(false);
                  break;
              }
            }
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
