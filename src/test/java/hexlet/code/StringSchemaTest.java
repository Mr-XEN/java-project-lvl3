package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringSchemaTest {

    private final Validator v = new Validator();
    private StringSchema stringSchemaOne;
    private StringSchema stringSchemaTwo;
    private static final int FIFTYFOUR = 54;
    private static final int TWENTYSIX = 26;
    private static final int TWENTYSEVEN = 27;
    private static final int FIFTEEN = 15;



    @BeforeEach
    public void init() {
        stringSchemaOne = v.string();
        stringSchemaTwo = v.string();
    }

    @Test
    void isValidOnly() {
        assertTrue(stringSchemaOne.isValid(""));
        assertTrue(stringSchemaTwo.isValid(null));
    }

    @Test
    void required() {
        assertTrue(stringSchemaOne.required().isValid("what does the fox say"));
        assertTrue(stringSchemaTwo.required().isValid("I don't like writing tests"));
    }

    @Test
    void requiredWithNullAndEmptyString() {
        assertFalse(stringSchemaOne.required().isValid(null));
        assertFalse(stringSchemaTwo.required().isValid(""));
    }

    @Test
    void minLengthWithNull() {
        assertFalse(stringSchemaOne.minLength(0).isValid(null));
        assertFalse(stringSchemaTwo.minLength(FIFTYFOUR).isValid(null));
    }

    @Test
    void minLengthWithEmptyString() {
        assertTrue(stringSchemaOne.minLength(0).isValid(""));
        assertFalse(stringSchemaTwo.minLength(FIFTYFOUR).isValid(""));
    }

    @Test
    void contains() {
        assertTrue(stringSchemaOne.contains("what").isValid("what does the fox say"));
        assertFalse(stringSchemaTwo.contains("whatthe").isValid("what does the fox say"));
    }

    @Test
    void complexTestWithAllMethodsOne() {
        assertTrue(stringSchemaOne.minLength(TWENTYSIX)
                .contains("do")
                .contains("sts")
                .isValid("I don't like writing tests"));
    }

    @Test
    void complexTestWithAllMethodsTwo() {
        assertFalse(stringSchemaOne.minLength(TWENTYSEVEN)
                .contains("do")
                .contains("sts")
                .isValid("I don't like writing tests"));
    }

    @Test
    void complexTestWithAllMethodsThree() {
        assertFalse(stringSchemaOne.minLength(FIFTEEN)
                .required()
                .contains("do")
                .contains("sts")
                .isValid(""));
    }

    @Test
    void complexTestWithAllMethodsFour() {
        assertTrue(stringSchemaOne.minLength(FIFTEEN)
                .required()
                .contains("do")
                .contains("sts")
                .isValid("I don't like writing tests"));
    }
}
