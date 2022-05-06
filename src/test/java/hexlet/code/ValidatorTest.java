package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorTest {

    @Test
    void test1() {
        int test = Validator.test(2, 2);
        assertEquals(0, test);
    }
}
