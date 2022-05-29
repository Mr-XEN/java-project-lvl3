# Schema Validator 

<img alt="" src="https://img.shields.io/badge/Version-1.0.0-green">

[![Actions Status](https://github.com/Mr-XEN/java-project-lvl3/workflows/hexlet-check/badge.svg 'Actions Status')](https://github.com/Mr-XEN/java-project-lvl3/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/98802fd672106d1adec2/maintainability 'Maintainability')](https://codeclimate.com/github/Mr-XEN/java-project-lvl3/maintainabilityt)
[![Test Coverage](https://api.codeclimate.com/v1/badges/98802fd672106d1adec2/test_coverage 'Test Coverag')](https://codeclimate.com/github/Mr-XEN/java-project-lvl3/test_coverage)

## Validating strings

- required – any non-empty string
- minLength – the string is equal to or longer than the specified number
- contains – the string contains a certain substring

```groovy
Validator v = new Validator();

StringSchema schema = v.string();

schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid("what does the fox say"); // true
schema.isValid("github"); // true
schema.isValid(null); // false
schema.isValid("");; // false

schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false
```
## Validation of numbers

- required – any number including zero
- positive  – positive number
- range – the range within which the numbers should fall, including the boundaries

```groovy
Validator v = new Validator();

NumberSchema schema = v.number();

schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(10) // true
schema.isValid("5"); // false

schema.positive().isValid(10); // true
schema.isValid(-10); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```

## Validating Map <Object,Object>

- required – Map data type is required
- sizeof  – the number of key-value pairs in the Map object must be equal to the given

```groovy
Validator v = new Validator();

MapSchema schema = v.map();

schema.isValid(null); // true

schema.required();

schema.isValid(null) // false
schema.isValid(new HashMap()); // true
Map<String, String> data = new HashMap<>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(2);

schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true
```

## Validation inside the Map

- shape - allows to describe validation for Map object values by keys.

```groovy
Validator v = new Validator();

MapSchema schema = v.map();

Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());
schema.shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "Maya");
human2.put("age", null); // true
schema.isValid(human2);

Map<String, Object> human3 = new HashMap<>();
human3.put("name", "");
human3.put("age", null);
schema.isValid(human3); // false

Map<String, Object> human4 = new HashMap<>();
human4.put("name", "Valya");
human4.put("age", -5);
schema.isValid(human4); // false
```

