package main.java.ua.parflare.basics.operators;

public class OperatorsDemo {

    public static void main(String[] args) {
        printArithmeticOperators();
        printComparisonOperators();
        printLogicalOperators();
        printBitwiseOperators();
        printAssignmentOperators();
    }

    private static void printArithmeticOperators() {
        System.out.println("\nArithmetic operators:");

        int a = 10, b = 3;
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
    }

    private static void printComparisonOperators() {
        System.out.println("\nComparison operators:");

        int x = 5, y = 7;
        System.out.println("x == y: " + (x == y));
        System.out.println("x != y: " + (x != y));
        System.out.println("x > y: " + (x > y));
        System.out.println("x < y: " + (x < y));
        System.out.println("x >= y: " + (x >= y));
        System.out.println("x <= y: " + (x <= y));
    }

    private static void printLogicalOperators() {
        System.out.println("\nLogical operators:");

        boolean p = true, q = false;
        System.out.println("p && q: " + (p && q));
        System.out.println("p || q: " + (p || q));
        System.out.println("!p: " + (!p));
    }

    private static void printBitwiseOperators() {
        System.out.println("\nBitwise operators:");

        int m = 5; // binary: 0101
        int n = 3; // binary: 0011

        System.out.println("m & n = " + (m & n)); // 0001 → 1
        System.out.println("m | n = " + (m | n)); // 0111 → 7
        System.out.println("m ^ n = " + (m ^ n)); // 0110 → 6
        System.out.println("~m = " + (~m));       // ...00000101 (5) -> ...11111010 (-6)

        System.out.println("n << 1 = " + (n << 1));   // 0110 → 6
        System.out.println("n >> 1 = " + (n >> 1));   // 0001 → 1

        int negative = -8; // binary: 11111111 11111111 11111111 11111000
        int shifted = negative >>> 1;
        System.out.println("Unsigned right shift (>>>): -8 >>> 1 = " + shifted);
        // Explanation:
        // -8 in binary (32-bit signed):   11111111 11111111 11111111 11111000
        // After >>> 1 (shift right, fill with 0): 01111111 11111111 11111111 11111100
        // Result is a large positive number: 2147483644
    }

    private static void printAssignmentOperators() {
        System.out.println("\nAssignment operators:");

        int a = 10;
        a += 5;
        System.out.println("a += 5 → " + a);

        a -= 2;
        System.out.println("a -= 2 → " + a);

        a *= 3;
        System.out.println("a *= 3 → " + a);

        a /= 4;
        System.out.println("a /= 4 → " + a);

        a %= 3;
        System.out.println("a %= 3 → " + a);
    }
}
