package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        Predicate<Object> rule = number -> number instanceof Integer;
        setListOfRules(rule);
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Object> rule = number -> number instanceof Integer && (Integer) number > 0;
        setListOfRules(rule);
        return this;
    }

    public final NumberSchema range(int rangeStart, int rangeEnd) {
        Predicate<Object> ruleOne = Objects::nonNull;
        Predicate<Object> ruleTwo = number -> (Integer) number >= rangeStart && (Integer) number <= rangeEnd;
        Predicate<Object> complexRule = ruleOne.and(ruleTwo);
        setListOfRules(complexRule);
        return this;
    }
}
