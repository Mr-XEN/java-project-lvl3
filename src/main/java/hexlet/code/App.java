package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class App {
    public static void main(String[] args) {

        Validator v = new Validator();
        StringSchema schema2 = v.string();
        StringSchema schema3 = v.string();
        StringSchema schema4 = v.string();
        StringSchema schema5 = v.string();
        StringSchema schema6 = v.string();

        System.out.println(schema2.minLength(0)
                .isValid("")); // true

    }
}
