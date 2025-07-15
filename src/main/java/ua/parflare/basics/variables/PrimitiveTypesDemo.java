package main.java.ua.parflare.basics.variables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        printLiteralsExamples();
        
        // Comparing
        printComparingExamples();
        
        // Something
        long b = 2147483648L; // remove L
        float c = 12e-4f;
    }

    private static void printLiteralsExamples() {
        System.out.println("\nJava literals examples");

        // Integer literals
        int decimal = 42;           // decimal literal
        int binary = 0b101010;      // binary literal (Java 7+)
        int octal = 052;            // octal literal (leading zero)
        int hex = 0x2A;             // hexadecimal literal

        System.out.println("Decimal literal: " + decimal);
        System.out.println("Binary literal (0b101010): " + binary);
        System.out.println("Octal literal (052): " + octal);
        System.out.println("Hexadecimal literal (0x2A): " + hex);

        // Floating-point literals
        float floatLiteral = 3.14f;         // suffix 'f' or 'F' for float
        double doubleLiteral = 2.71828;     // default is double
        double scientific = 1.23e3;         // exponential notation

        System.out.println("\nFloat literal: " + floatLiteral);
        System.out.println("Double literal: " + doubleLiteral);
        System.out.println("Scientific notation: " + scientific);

        // Character literals
        char charLiteral = 'A';
        char unicodeChar = '\u0041';        // Unicode escape for 'A'
        char specialChar = '\n';            // special character (newline)

        System.out.println("\nCharacter literal: " + charLiteral);
        System.out.println("Unicode character (\\u0041): " + unicodeChar);
        System.out.println("Special character (newline): [" + specialChar + "]");

        // String literal
        String stringLiteral = "Hello, world!";
        System.out.println("\nString literal: " + stringLiteral);

        // Underscores in numeric literals (Java 7+)
        int readableInt = 1_000_000;
        long readableLong = 9_876_543_210L;
        double readableDouble = 3.1415_9265;

        System.out.println("\nUnderscores in int: " + readableInt);
        System.out.println("Underscores in long: " + readableLong);
        System.out.println("Underscores in double: " + readableDouble);

        // Invalid uses (won’t compile)
        // int invalid = _100;         // underscore at beginning — not allowed
        // int invalid2 = 100_;        // underscore at end — not allowed
    }

    private static void printComparingExamples() {
        System.out.println("\nComparing Wrapper Objects");

        // Comparison using '==' (reference equality)
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;

        System.out.println("Integer 127 == Integer 127: " + (a == b)); // true — same cached object
        System.out.println("Integer 128 == Integer 128: " + (c == d)); // false — distinct objects

        // TIP: Integer values from -128 to 127 are cached by the JVM,
        // so autoboxing returns the same object reference within that range.

        // Value-based comparison (should always be preferred)
        System.out.println("Equals comparing 1128 & 128: " + c.equals(d)); // true

        // Compare primitive and boxed
        int primitive = 127;
        Integer boxed = 127;
        System.out.println("int 127 == Integer 127: " + (primitive == boxed)); // true — unboxed automatically

        // Null-safe comparison
        Integer x = null;
        System.out.println("Null-safe equals: " + Objects.equals(x, 10)); // false, no exception

        // compareTo example (numeric comparison)
        Integer n1 = 10;
        Integer n2 = 20;
        System.out.println("n1.compareTo(n2): " + n1.compareTo(n2)); // -1

        // Comparison with different boxed types
        Double doubleValue = 10.0;
        System.out.println("n1.equals(doubleValue): " + n1.equals(doubleValue)); // false — different classes

        // == between boxed and primitive of different types
        double primitiveDouble = 10.0;
        System.out.println("n1 == primitiveDouble: " + (n1 == primitiveDouble)); // true — unboxed and promoted
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
