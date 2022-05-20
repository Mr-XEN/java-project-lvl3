package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {

    private final Validator validator = new Validator();
    private MapSchema mapSchemaOne;
    private MapSchema mapSchemaTwo;
    private static final int ONE = 1;
    private static final int TWO = 2;

    @BeforeEach
    public void init() {
        mapSchemaOne = validator.map();
        mapSchemaTwo = validator.map();
    }

    @Test
    void isValidOnly() {
        assertTrue(mapSchemaOne.isValid(""));
        assertTrue(mapSchemaTwo.isValid(null));
    }

    @Test
    void required() {
        assertFalse(mapSchemaOne.required().isValid(null));
        assertTrue(mapSchemaTwo.required().isValid(new HashMap<>()));
    }

    @Test
    void sizeof() {
        Map<Object, Object> testMap = new HashMap<>();
        testMap.put("Key1", "value1");
        assertTrue(mapSchemaOne.required().sizeof(ONE).isValid(testMap));
    }

    @Test
    void complexTestWithAllMethods() {
        Map<Object, Object> testMap = new HashMap<>();
        testMap.put("Key1", "value1");
        assertFalse(mapSchemaOne.required().sizeof(TWO).isValid(testMap));
        testMap.put("Key2", "value2");
        assertTrue(mapSchemaOne.required().sizeof(TWO).isValid(testMap));
    }

}
