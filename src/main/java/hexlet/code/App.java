package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class App {
    public static void main(String[] args) {

        Validator v = new Validator();

        StringSchema schema = v.string();
        StringSchema schema2 = v.string();

        System.out.println(schema2.minLength(9).required().minLength(5).required().minLength(4).isValid("fdgfh"));
        System.out.println();
        System.out.println();

//
//        schema2.isValid(""); // true
//        schema2.isValid(null); // true
//        schema2.required();
//        schema2.isValid("what does the fox say"); // true
//        schema2.isValid("hexlet"); // true
//        boolean b = schema2.isValid(null);// false
//        System.out.println(b);
//        schema2.isValid("");; // false
////        schema2.contains("what").isValid("what does the fox say"); // true
////        schema2.contains("whatthe").isValid("what does the fox say"); // false
//        schema2.isValid("what does the fox say"); // false

//        System.out.println(schema.required().isValid(null));


//        System.out.println(schema.isValid("")); //true
//        System.out.println(schema.isValid(null)); //true
//        System.out.println(schema.required());
//        System.out.println(schema.isValid("what does the fox say")); //true
//        System.out.println(schema.isValid("hexlet")); //true
//        System.out.println(schema.isValid(null)); // false
//        System.out.println(schema.isValid("")); // false
//        System.out.println();
//





//        System.out.println(schema.contains("what").isValid("what does the fox say"));
//        System.out.println(schema.contains("whatthe").isValid("what does the fox say"));
//        System.out.println(schema.isValid("what does the fox say"));
//
// уже false, так как добавлена ещё одна проверка contains("whatthe")

//        Validator v = new Validator();
//
//        StringSchema schema = v.string();
//
//        System.out.println(schema.isValid(""));
//        System.out.println(schema.isValid());
//
//        schema.isValid(""); // true
//        schema.isValid(); // true

//        Validator v = new Validator();
//        StringSchema schema = v.string();
//        schema.contains("Hello");
//        schema.minLength(6);
//
//        schema.isValid("Hello World!"); //true
//        schema.isValid("Hello"); //false
//        System.out.println(schema.isValid("Hello World!"));
//        System.out.println(schema.isValid("Hello"));


//
//        schema.required();
//
//        schema.isValid("what does the fox say"); // true
//        schema.isValid("hexlet"); // true
//        schema.isValid(null); // false
//        schema.isValid("");; // false
//
//        schema.contains("what").isValid("what does the fox say"); // true
//        schema.contains("whatthe").isValid("what does the fox say"); // false
//
//        schema.isValid("what does the fox say"); // false



    }

}
