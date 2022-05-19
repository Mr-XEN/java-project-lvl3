package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    private final List<Predicate<Object>> listOfRules = new LinkedList<>();

    public final boolean isValid(Object inputObject) {

        if (!listOfRules.isEmpty()) {
            for (Predicate<Object> rule : listOfRules) {
                if (!rule.test(inputObject)) {
                    return false;
                }
            }
        }
        return true;
    }

    protected final void setListOfRules(Predicate<Object> rule) {
        this.listOfRules.add(rule);
    }
}
