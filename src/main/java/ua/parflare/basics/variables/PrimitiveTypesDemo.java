package main.java.ua.parflare.basics.variables;

public class PrimitiveTypesDemo {

    public static void main(String[] args) {

        // Types
        printTypes();

        // Default values
        new DefaultValues().printDefaults();

        // Boxing / Unboxing

        // Value overflow

        // Implicit and Explicit Type Casting

        // Literals (integer, floating-point, character and string, using underscore characters in numeric)

        // Comparing



    }

    private static void printTypes() {
        System.out.println("Size and range of primitive types:");

        System.out.printf("byte: %d bytes, range: [%d, %d]%n",
                Byte.BYTES, Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("short: %d bytes, range: [%d, %d]%n",
                Short.BYTES, Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("int: %d bytes, range: [%d, %d]%n",
                Integer.BYTES, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("long: %d bytes, range: [%d, %d]%n",
                Long.BYTES, Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.printf("float: %d bytes, approx range: [%e, %e]%n",
                Float.BYTES, -Float.MAX_VALUE, Float.MAX_VALUE);
        System.out.printf("double: %d bytes, approx range: [%e, %e]%n",
                Double.BYTES, -Double.MAX_VALUE, Double.MAX_VALUE);
        System.out.printf("char: %d bytes, range: [%d, %d]%n",
                Character.BYTES, (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);
        System.out.printf("boolean: JVM-dependent size (typically 1 byte), values: true or false%n");
    }

    static class DefaultValues {
        byte defByte;
        short defShort;
        int defInt;
        long defLong;
        float defFloat;
        double defDouble;
        char defChar;
        boolean defBoolean;

        void printDefaults() {
            System.out.println("\nDefault values of primitive fields:");
            System.out.println("byte: " + defByte);
            System.out.println("short: " + defShort);
            System.out.println("int: " + defInt);
            System.out.println("long: " + defLong);
            System.out.println("float: " + defFloat);
            System.out.println("double: " + defDouble);
            System.out.println("char: [" + defChar + "] (int: " + (int) defChar + ")");
            System.out.println("boolean: " + defBoolean);
        }
    }

}
