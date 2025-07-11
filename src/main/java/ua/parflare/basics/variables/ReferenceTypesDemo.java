package main.java.ua.parflare.basics.variables;

public class ReferenceTypesDemo {

    public static void main(String[] args) {
        // Types
        printTypes();

        // Default values
        new DefaultValues().printDefaults();

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

        }
    }

    private class Example {
        int age;

        public Example(int age) {
            this.age = age;
        }
    }

    private static void printTypes() {
        String text = "Hello, Java!";
        Integer number = 100;  // wrapper class
        Double decimal = 99.99;

        System.out.println("String: " + text);
        System.out.println("Integer object: " + number);
        System.out.println("Double object: " + decimal);

        // String methods example
        System.out.println("Length of text: " + text.length());
        System.out.println("Upper case: " + text.toUpperCase());

        // Null example
        String nullString = null;
        System.out.println("Null string: " + nullString);
    }

}
