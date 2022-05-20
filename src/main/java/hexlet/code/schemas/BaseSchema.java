package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private final List<Predicate<Object>> listOfRules = new LinkedList<>();

    public abstract BaseSchema required();

    public final boolean isValid(Object inputObject) {

        for (Predicate<Object> rule : listOfRules) {
            if (!rule.test(inputObject)) {
                return false;
            }
        }
        return true;
    }

    protected final void addRule(Predicate<Object> rule) {
        this.listOfRules.add(rule);
    }
}
