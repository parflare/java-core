package main.java.ua.parflare.oop.models.animals;

/**
 * Dog class that extends Animal and overrides speak.
 *
 * @see Animal
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(name + ": barks");
    }

    public void fetch() {
        System.out.println(getName() + " is fetching the ball.");
    }
}
