package main.java.ua.parflare.basics.modifiers;

/**
 * <p>Java modifiers are keywords that you add to declarations to change their meanings.
 * They can be divided into two main groups:
 *
 * <h3>1. Access Modifiers</h3>
 * These modifiers determine where a variable, class, or method is accessible:
 * <ul>
 *   <li><b>public</b> — accessible from everywhere;</li>
 *   <li><b>protected</b> — accessible within the same package and subclasses;</li>
 *   <li><b>package-private</b> (no modifier) — accessible only within the same package;</li>
 *   <li><b>private</b> — accessible only within the declaring class.</li>
 * </ul>
 *
 * <h3>2. Non-Access Modifiers</h3>
 * These modifiers define the behavior of fields, methods, and classes:
 *
 * <h4>For Classes:</h4>
 * <ul>
 *   <li><b>final</b> — class cannot be subclassed;</li>
 *   <li><b>abstract</b> — class cannot be instantiated directly; requires subclassing;</li>
 *   <li><b>strictfp</b> — enforces strict IEEE 754 compliance for floating-point calculations across platforms;
 *       rarely affects behavior on modern JVMs, but useful for portability.</li>
 * </ul>
 *
 * <h4>For Methods:</h4>
 * <ul>
 *   <li><b>final</b> — method cannot be overridden;</li>
 *   <li><b>abstract</b> — method has no implementation (must be overridden in subclass);</li>
 *   <li><b>static</b> — method belongs to the class rather than an instance;</li>
 *   <li><b>synchronized</b> — method can be accessed by only one thread at a time (thread-safety);</li>
 *   <li><b>native</b> — method implemented in another language such as C/C++ (JNI);</li>
 *   <li><b>strictfp</b> — applies strict IEEE 754 rules to floating-point calculations in this method;
 *       typically has no visible effect on most modern systems.</li>
 * </ul>
 *
 * <h4>For Variables:</h4>
 * <ul>
 *   <li><b>final</b> — value cannot be changed after initialization;</li>
 *   <li><b>static</b> — variable belongs to the class rather than any instance;</li>
 *   <li><b>volatile</b> — variable always read from main memory (important in multithreading);</li>
 *   <li><b>transient</b> — variable is not serialized during object serialization.</li>
 * </ul>
 */
public class ModifiersDemo {

    /**
     * Final and static modifiers examples
     */
    public static final double PI = 3.1415926535; // constant shared by all instances
    /**
     * Access modifier examples
     */
    public int publicField;          // accessible everywhere
    protected int protectedField;    // accessible within package and subclasses
    int packagePrivateField;          // accessible only within package
    private int privateField;        // accessible only within this class
    /**
     * Volatile example for multithreading
     */
    private volatile boolean flag = false;

    /**
     * Transient example for serialization (serialization not include this var now)
     */
    private transient String temporaryData;

    /**
     * Static method belongs to class, not instance
     */
    public static void staticMethod() {
        System.out.println("Static method called.");
    }

    /**
     * Final method cannot be overridden by subclasses
     */
    public final void finalMethod() {
        System.out.println("This final method cannot be overridden.");
    }

    /**
     * Synchronized method example for thread safety
     */
    public synchronized void synchronizedMethod() {
        System.out.println("Synchronized method called.");
    }

}
