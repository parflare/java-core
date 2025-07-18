package main.java.ua.parflare.functional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionalDemo {

    public static void main(String[] args) {
        lambdaBasic();
        methodReferences();
        functionalInterfaces();
        streamApi();
        optionalDemo();
        functionComposition();
        streamWithCollections();
    }

    /**
     * Basic lambda expressions demonstrating syntax, parameters, and body.
     *
     * @see Runnable
     * @see Consumer
     * @see BinaryOperator
     */
    public static void lambdaBasic() {
        // No parameters
        Runnable r1 = () -> System.out.println("Hello from lambda with no parameters");
        r1.run();

        // One parameter, no parentheses needed
        Consumer<String> printer = s -> System.out.println("Printing: " + s);
        printer.accept("Lambda");

        // Multiple parameters, with return
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println("Sum: " + sum.apply(3, 5));
    }

    /**
     * Examples of method references: instance method, static method, constructor.
     *
     * @see Function
     * @see Supplier
     */
    public static void methodReferences() {
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie");
        names.forEach(System.out::println);

        Function<String, Integer> toLength = String::length;
        String method = "Method";
        System.out.printf("Length of '%s': %d\n", method, toLength.apply(method));

        Supplier<Date> now = Date::new;
        System.out.println("Current date: " + now.get());
    }

    /**
     * Demonstrates common functional interfaces:
     * Predicate, Function, Consumer, Supplier.
     *
     * @see Predicate
     * @see Function
     * @see Consumer
     * @see Supplier
     */
    public static void functionalInterfaces() {
        // Predicate<T>: takes T, returns boolean (used for testing conditions)
        Predicate<String> isEmpty = String::isEmpty;
        System.out.println("Is empty: " + isEmpty.test(""));

        // Function<T, R>: takes T, returns R (used for mapping/conversion)
        Function<String, Integer> length = String::length;
        System.out.println("Length: " + length.apply("Functional"));

        // Consumer<T>: takes T, returns void (used for consuming/processing)
        Consumer<String> printer = System.out::println;
        printer.accept("Consume this");

        // Supplier<T>: takes no arguments, returns T (used for supplying/generating)
        Supplier<Double> random = Math::random;
        System.out.println("Random number: " + random.get());
    }


    // Stream API examples: filter, map, collect, reduce
    public static void streamApi() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        // Filter words starting with 'b', convert to uppercase, collect to list
        List<String> filtered = words.stream()
                .filter(w -> w.startsWith("b"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Filtered: " + filtered);

        // Reduce to concatenate all words with comma
        String concatenated = words.stream()
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.println("Original list view:" + words);
        System.out.println("Concatenated: " + concatenated);
    }

    /**
     * Optional: creation, checking, getting value
     *
     * @see Optional
     */

    public static void optionalDemo() {
        Optional<String> maybe = Optional.ofNullable(null);
        System.out.println("Is present? " + maybe.isPresent());
        System.out.println("Or else: " + maybe.orElse("Default"));

        Optional<String> present = Optional.of("Present value");
        present.ifPresent(s -> System.out.println("Value: " + s));
    }

    /**
     * Function composition using andThen and compose.
     *
     * @see Function
     */
    public static void functionComposition() {
        Function<Integer, Integer> timesTwo = x -> x * 2;
        Function<Integer, Integer> plusThree = x -> x + 3;

        Function<Integer, Integer> combined1 = timesTwo.andThen(plusThree);
        Function<Integer, Integer> combined2 = timesTwo.compose(plusThree);

        System.out.println("andThen (2*2+3): " + combined1.apply(2)); // (2*2)+3=7
        System.out.println("compose ( (2+3)*2 ): " + combined2.apply(2)); // (2+3)*2=10
    }

    /**
     * Using Stream API with collections: filtering, printing, mapping, reducing.
     *
     * @see java.util.stream.Stream
     */
    public static void streamWithCollections() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Filter even numbers and print
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Sum of squares
        int sumSquares = numbers.stream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Sum of squares: " + sumSquares);
    }
}
