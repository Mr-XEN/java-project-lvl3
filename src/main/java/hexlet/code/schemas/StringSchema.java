package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    @Override
    public final StringSchema required() {
        Predicate<Object> rule = object -> object instanceof String && !((String) object).isEmpty();
        addRule(rule);
        return this;
    }

    public final StringSchema minLength(int length) {
        Predicate<Object> rule = object -> {
            String res = (String) object;
            return object != null && res.length() >= length;
        };
        addRule(rule);
        return this;
    }

    public final StringSchema contains(String inputString) {
        Predicate<Object> rule = object -> {
            String result = (String) object;
            return object != null && result.contains(inputString);
        };
        addRule(rule);
        return this;
    }

}
