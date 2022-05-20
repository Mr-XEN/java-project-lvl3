package hexlet.code;

import hexlet.code.schemas.NumberSchema;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();

        NumberSchema schema = v.number();

        System.out.println(schema.required().isValid("null"));


    }
}
