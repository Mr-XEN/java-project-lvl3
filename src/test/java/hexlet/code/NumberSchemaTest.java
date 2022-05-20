package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {

    private final Validator validator = new Validator();
    private NumberSchema numberSchemaOne;
    private NumberSchema numberSchemaTwo;
    private NumberSchema numberSchemaThree;
    private static final int ONE = 1;
    private static final int NEGATIVEONE = 1;
    private static final int FIFTYFOUR = 54;
    private static final int TWENTYSIX = 26;
    private static final int TWENTYSEVEN = 27;
    private static final int FIFTEEN = 15;
    private static final int NEGATIVEFIFTEEN = -15;


    @BeforeEach
    public void init() {
        numberSchemaOne = validator.number();
        numberSchemaTwo = validator.number();
        numberSchemaThree = validator.number();
    }

    @Test
    void isValidOnly() {
        assertTrue(numberSchemaOne.isValid(""));
        assertTrue(numberSchemaTwo.isValid(null));
        assertTrue(numberSchemaThree.isValid(ONE));
    }

    @Test
    void required() {
        assertFalse(numberSchemaOne.required().isValid(null));
        assertTrue(numberSchemaTwo.required().isValid(FIFTEEN));
        assertFalse(numberSchemaThree.required().isValid("I don't like writing tests"));

    }

    @Test
    void positive() {
        assertTrue(numberSchemaOne.positive().isValid(FIFTYFOUR));
        assertFalse(numberSchemaTwo.positive().isValid(""));
        assertFalse(numberSchemaThree.positive().isValid(NEGATIVEFIFTEEN));

    }

    @Test
    void range() {
        assertTrue(numberSchemaOne.range(NEGATIVEFIFTEEN, FIFTEEN).isValid(ONE));
        assertTrue(numberSchemaTwo.range(NEGATIVEFIFTEEN, FIFTEEN).isValid(NEGATIVEONE));
        assertFalse(numberSchemaThree.range(NEGATIVEFIFTEEN, FIFTEEN).isValid(null));
    }

    @Test
    void complexTestWithAllMethods() {
        assertFalse(numberSchemaOne.required()
                .range(NEGATIVEFIFTEEN, FIFTYFOUR)
                .isValid(null));

        assertTrue(numberSchemaOne.required()
                .positive()
                .range(ONE, FIFTYFOUR)
                .isValid(FIFTEEN));

    }
}
