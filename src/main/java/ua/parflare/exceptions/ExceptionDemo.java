package main.java.ua.parflare.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class ExceptionDemo {

    public static void main(String[] args) {
        combinedTryCatchExamples();
        customChecked();

        try {
            customUnchecked();
        } catch (CustomUncheckedException e) {
            System.out.println("Caught CustomUncheckedException: " + e.getMessage());
        }

        try {
            throwVsThrows();
        } catch (CustomCheckedException e) {
            System.out.println("Handled in main: " + e.getMessage());
        }

        chainedExceptions();
        tryWithResources();
        suppressedExceptions();
    }

    // Demonstrates simple try-catch, multi-catch, and finally block
    public static void combinedTryCatchExamples() {
        try {
            System.out.println("Inside try block");
            String s = null;
            System.out.println(s.length()); // Throws NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        } catch (Exception e) {
            System.out.println("Caught general Exception");
        } finally {
            System.out.println("Inside finally block (always executes)");
        }
    }

    // Demonstrates a custom checked exception
    public static void customChecked() {
        try {
            throw new CustomCheckedException("This is a custom checked exception");
        } catch (CustomCheckedException e) {
            System.out.println("Caught CustomCheckedException: " + e.getMessage());
        }
    }

    // Demonstrates a custom unchecked exception
    public static void customUnchecked() {
        throw new CustomUncheckedException("This is a custom unchecked exception");
    }

    // Method that declares throwing a checked exception
    public static void throwVsThrows() throws CustomCheckedException {
        throw new CustomCheckedException("Thrown from demonstrateThrowVsThrows()");
    }

    // Demonstrates chained exceptions (one exception caused by another)
    public static void chainedExceptions() {
        try {
            try {
                throw new IOException("Primary exception");
            } catch (IOException e) {
                throw new RuntimeException("Secondary exception", e);
            }
        } catch (RuntimeException e) {
            System.out.println("Caught chained exception: " + e.getMessage());
            System.out.println("Caused by: " + e.getCause());
        }
    }

    // Demonstrates try-with-resources usage
    public static void tryWithResources() {
        try (BufferedReader reader = new BufferedReader(new StringReader("test"))) {
            System.out.println("Read: " + reader.readLine());
        } catch (IOException e) {
            System.out.println("IOException in try-with-resources: " + e.getMessage());
        }
    }

    // Demonstrates suppressed exceptions when closing resources
    public static void suppressedExceptions() {
        try (AutoCloseableResource resource = new AutoCloseableResource()) {
            throw new RuntimeException("Exception in try block");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getMessage());
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed);
            }
        }
    }

    // Custom checked exception class
    static class CustomCheckedException extends Exception {
        public CustomCheckedException(String message) {
            super(message);
        }
    }

    // Custom unchecked exception class
    static class CustomUncheckedException extends RuntimeException {
        public CustomUncheckedException(String message) {
            super(message);
        }
    }

    // AutoCloseable resource that throws exception on close()
    static class AutoCloseableResource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new Exception("Exception in close()");
        }
    }

}
