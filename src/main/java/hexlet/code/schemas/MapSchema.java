package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public final MapSchema required() {
        Predicate<Object> rule = map -> map instanceof Map<?, ?>;
        setListOfRules(rule);
        return this;
    }

    public final MapSchema sizeof(int size) {
        Predicate<Object> rule = map -> map instanceof Map<?, ?> && ((Map<?, ?>) map).size() == size;
        setListOfRules(rule);
        return this;
    }
}
