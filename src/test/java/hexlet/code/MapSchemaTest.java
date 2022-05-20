package hexlet.code;

import hexlet.code.schemas.BaseSchema;
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
    private static final int FIFTYFOUR = 54;
    private static final int FIFTEEN = 15;
    private static final int NEGATIVEFIFTEEN = -15;

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

    @Test
    void shapeTestOne() {

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());
        mapSchemaOne.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", FIFTYFOUR);
        assertTrue(mapSchemaOne.isValid(human1)); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null); // true
        assertTrue(mapSchemaOne.isValid(human2));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", NEGATIVEFIFTEEN);
        assertFalse(mapSchemaOne.isValid(human4)); // false

    }

    @Test
    void shapeTestTwo() {

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", validator.string().required().contains("o").contains("l"));
        schemas.put("age", validator.number().positive().range(TWO, FIFTYFOUR));
        mapSchemaOne.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", FIFTEEN);
        assertTrue(mapSchemaOne.isValid(human1)); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "I don't like writing tests");
        human2.put("age", FIFTEEN); // true
        assertTrue(mapSchemaOne.isValid(human2));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Oleg");
        human4.put("age", ONE);
        assertFalse(mapSchemaOne.isValid(human4)); // false

    }

}
