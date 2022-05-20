package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    @Override
    public final NumberSchema required() {
        Predicate<Object> rule = number -> number instanceof Integer;
        addRule(rule);
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Object> rule = number -> number == null || (number instanceof Integer && (Integer) number > 0);
        addRule(rule);
        return this;
    }

    public final NumberSchema range(int rangeStart, int rangeEnd) {
        Predicate<Object> ruleOne = Objects::nonNull;
        Predicate<Object> ruleTwo = number -> (Integer) number >= rangeStart && (Integer) number <= rangeEnd;
        Predicate<Object> complexRule = ruleOne.and(ruleTwo);
        addRule(complexRule);
        return this;
    }
}
