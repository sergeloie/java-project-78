package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TempTest {
    @Test
    void someTest(){
        Validator v = new Validator();
        NumberSchema schema = v.number();

        System.out.println(schema.isValid(null));
        System.out.println("-2 = " + schema.isValid(-2));
        System.out.println("10 = " + schema.isValid(10));
        schema.positive();
        schema.positive();
        System.out.println(schema.isValid(null));
        schema.required();
        System.out.println(schema.predicates);

//        for (Predicate<Integer> predicate : schema.predicates) {
//
//            try {
//                System.out.println("Штатная обработка - " + predicate.test(null));
//            } catch (NullPointerException npe) {
//                System.out.println("Ошибка. NullPointerException !!!!11111адинадин");
//            }
//        }

        System.out.println(schema.isValid(null));
        System.out.println("-2 = " + schema.isValid(-2));
        System.out.println("10 = " + schema.isValid(10));



    }

}
