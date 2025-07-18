package main.java.ua.parflare.oop.models.animals;

/**
 * Cat class that extends Animal and overrides speak.
 *
 * @see Animal
 */
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(name + ": meows");
    }
}
