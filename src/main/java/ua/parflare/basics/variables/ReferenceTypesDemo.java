package main.java.ua.parflare.basics.variables;

import java.util.Arrays;

public class ReferenceTypesDemo {

    public static void main(String[] args) {
        // Types
        printTypes();

        // Default values
        new DefaultValues().printDefaults();

        // Comparing
        printComparingExamples();
        
        // Passing objects to a method
        printReferenceBehavior();
    }

    private static void printReferenceBehavior() {
        Example example = new Example(15);
        modify(example);
        System.out.println("Modified age: " + example.age); // 25
    }

    static void modify(Example ex) {
        ex.age += 10;
    }

    private static void printComparingExamples() {
        String a = new String("Java");
        String b = new String("Java");
        System.out.println("a == b: " + (a == b));             // false
        System.out.println("a.equals(b): " + a.equals(b));     // true
    }

    static class DefaultValues {
        Byte defByte;
        Short defShort;
        Integer defInt;
        Long defLong;
        Float defFloat;
        Double defDouble;
        Character defChar;
        Boolean defBoolean;
        String defString;
        Example defExample;
        Object defObject;

        void printDefaults() {
            System.out.println("\nDefault values of reference type fields: (all null)");
            System.out.println("Byte: " + defByte);
            System.out.println("Short: " + defShort);
            System.out.println("Integer: " + defInt);
            System.out.println("Long: " + defLong);
            System.out.println("Float: " + defFloat);
            System.out.println("Double: " + defDouble);
            System.out.println("Character: " + defChar);
            System.out.println("Boolean: " + defBoolean);
            System.out.println("String: " + defString);
            System.out.println("Example class: " + defExample);
            System.out.println("Object: " + defObject);

        }
    }

    private static class Example {
        int age;

        public Example(int age) {
            this.age = age;
        }
    }

    private static void printTypes() {
        String text = "Hello, Java!";
        Integer number = 100;  // wrapper class
        Double decimal = 99.99;
        int[] numbers = {1, 2, 3};

        System.out.println("String: " + text);
        System.out.println("Integer object: " + number);
        System.out.println("Double object: " + decimal);
        System.out.println("Array: " + Arrays.toString(numbers));

        // String methods example
        System.out.println("Length of text: " + text.length());
        System.out.println("Upper case: " + text.toUpperCase());

        // Null example
        String nullString = null;
        System.out.println("Null string: " + nullString);

        try {
            System.out.println(nullString.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException on null reference");
        }
    }

}
