package main.java.ua.parflare.basics.variables;

public class ReferenceTypesDemo {

    public static void main(String[] args) {
        // Types
        printTypes();


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
