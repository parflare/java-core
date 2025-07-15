package main.java.ua.parflare.basics.variables;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveTypesDemo {

    public static void main(String[] args) {

        // Types
        printTypes();

        // Default values
        new DefaultValues().printDefaults();

        // Boxing / Unboxing
        printBoxingExamples();

        // Value overflow
        printOverflowExamples();

        // Implicit and explicit type casting
        printTypeCastingExamples();
        
        // Literals (integer, floating-point, character and string, using underscore characters in numeric)

        // Comparing

        // Something
        long b = 2147483648L; // remove L
        float c = 12e-4f;

    }

    private static void printTypeCastingExamples() {
        System.out.println("\nImplicit and explicit type casting");

        // Implicit widening conversion (safe, no data loss)
        byte byteVal = 42;
        long longVal = byteVal; // byte → long
        double doubleVal = longVal; // long → double

        System.out.println("byte: " + byteVal);
        System.out.println("byte → long: " + longVal);
        System.out.println("long → double: " + doubleVal);

        // Explicit narrowing conversion (requires cast, may lose data)
        double originalDouble = 12345.6789;
        float narrowedFloat = (float) originalDouble;
        long narrowedLong = (long) narrowedFloat;
        int narrowedInt = (int) narrowedLong;
        short narrowedShort = (short) narrowedInt;
        byte narrowedByte = (byte) narrowedShort;

        System.out.println("\nOriginal double: " + originalDouble);
        System.out.println("double → float: " + narrowedFloat);
        System.out.println("float → long: " + narrowedLong);
        System.out.println("long → int: " + narrowedInt);
        System.out.println("int → short: " + narrowedShort);
        System.out.println("short → byte: " + narrowedByte);

        // Casting between char and int
        char letter = 'A';
        int letterCode = letter; // implicit
        char recoveredChar = (char) letterCode; // explicit
        System.out.println("\nchar → int: " + letterCode);
        System.out.println("int → char: " + recoveredChar);

        // Negative value to char (wraps to Unicode)
        int negative = -1;
        char wrappedChar = (char) negative;
        System.out.println("int -1 → char: " + (int) wrappedChar + " (wrapped)");
    }

    private static void printBoxingExamples() {
        System.out.println("\nBoxing / Unboxing examples");

        // Autoboxing
        int primitiveInt = 10;
        Integer boxedInt = primitiveInt; // autoboxing
        System.out.println("Autoboxing: int → Integer = " + boxedInt);

        // Unboxing
        Integer anotherBoxed = Integer.valueOf(20);
        int unboxedInt = anotherBoxed; // unboxing
        System.out.println("Unboxing: Integer → int = " + unboxedInt);

        // Explicit boxing
        Double boxedDouble = Double.valueOf(3.14);
        System.out.println("Explicit boxing: double → Double = " + boxedDouble);

        // Using boxed types in collections
        List<Integer> intList = new ArrayList<>();
        intList.add(100); // autoboxing
        System.out.println("Value from List<Integer>: " + intList.get(0)); // unboxing if used as int

        // Comparison between boxed and primitive
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;

        System.out.println("Integer 128 equals Integer 128: " + c.equals(d));

        System.out.println("Integer 127 == Integer 127: " + (a == b)); // true, cached
        // TIP: Java caches Integer objects in the range from -128 to 127 inclusive.
        System.out.println("Integer 128 == Integer 128: " + (c == d)); // false, different objects

        // Unboxing null will throw a NullPointerException
        Integer nullValue = null;
        try {
            int x = nullValue; // unboxing null → NullPointerException
        } catch (NullPointerException ex) {
            System.out.println("Unboxing null Integer causes: " + ex);
        }

        // Performance comparison: primitive vs boxing
        long start1 = System.nanoTime();
        int sum1 = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum1 += i;
        }
        long end1 = System.nanoTime();
        System.out.println("Time without boxing: " + (end1 - start1) / 1_000_000 + " ms");

        long start = System.nanoTime();
        Integer sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i; // involves boxing/unboxing on each iteration
        }
        long end = System.nanoTime();
        System.out.println("Time with boxing: " + (end - start) / 1_000_000 + " ms");

    }

    private static void printOverflowExamples() {
        System.out.println("\nValue overflow examples:");

        byte maxByte = Byte.MAX_VALUE; // 127
        byte overflowedByte = (byte) (maxByte + 1); // wrap-around
        System.out.println("Byte.MAX_VALUE + 1 = " + overflowedByte); // -128

        int temp = overflowedByte & 0xFF;
        System.out.println("-128 & 0xFF = " + temp); // signed byte to unsigned int

        int maxInt = Integer.MAX_VALUE; // 2147483647
        int overflowedInt = maxInt + 1;
        System.out.println("Integer.MAX_VALUE + 1 = " + overflowedInt); // -2147483648

        int minInt = Integer.MIN_VALUE;
        int underflowedInt = minInt - 1;
        System.out.println("Integer.MIN_VALUE - 1 = " + underflowedInt); // 2147483647

        float bigFloat = Float.MAX_VALUE;
        float floatOverflow = bigFloat * 2;
        System.out.println("Float.MAX_VALUE * 2 = " + floatOverflow); // Infinity

        float minPositive = Float.MIN_VALUE;
        float underflowFloat = minPositive / 2;
        System.out.println("Float.MIN_VALUE / 2 = " + underflowFloat); // very small → 0.0

        double bigDouble = Double.MAX_VALUE;
        double doubleOverflow = bigDouble * 2;
        System.out.println("Double.MAX_VALUE * 2 = " + doubleOverflow); // Infinity

        try {
            int safe = Math.addExact(Integer.MAX_VALUE, 1);
            System.out.println("Safe addition result: " + safe);
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            byte b = 127;
            b += 1;
            System.out.println("b += 1 results in: " + b);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
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
