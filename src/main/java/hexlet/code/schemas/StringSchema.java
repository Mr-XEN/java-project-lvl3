package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        Predicate<Object> rule = object -> object instanceof String && !((String) object).isEmpty();
        setListOfRules(rule);
        return this;
    }

    public final StringSchema minLength(int length) {
        Predicate<Object> rule = object -> {
            String res = (String) object;
            return object != null && res.length() >= length;
        };
        setListOfRules(rule);
        return this;
    }

    public final StringSchema contains(String inputString) {
        Predicate<Object> rule = object -> {
            String result = (String) object;
            return object != null && result.contains(inputString);
        };
        setListOfRules(rule);
        return this;
    }

}
