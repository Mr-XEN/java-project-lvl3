package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    @Override
    public final MapSchema required() {
        Predicate<Object> rule = map -> map instanceof Map<?, ?>;
        addRule(rule);
        return this;
    }

    public final MapSchema sizeof(int size) {
        Predicate<Object> rule = map -> map instanceof Map<?, ?> && ((Map<?, ?>) map).size() == size;
        addRule(rule);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> inputMap) {
        Predicate<Object> rule = map -> map == null || map instanceof Map && inputMap.entrySet()
                .stream()
                .allMatch(s -> s.getValue().isValid(((Map<?, ?>) map).get(s.getKey())));
        addRule(rule);
        return this;
    }
}
