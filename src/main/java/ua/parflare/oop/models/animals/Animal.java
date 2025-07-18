package main.java.ua.parflare.oop.models.animals;

/**
 * Base class for demonstrating inheritance and polymorphism.
 */
public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println(name + " makes a sound");
    }

    public String getName() {
        return name;
    }
}
