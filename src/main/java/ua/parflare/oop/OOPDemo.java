package main.java.ua.parflare.oop;

import main.java.ua.parflare.oop.models.Person;
import main.java.ua.parflare.oop.models.animals.Animal;
import main.java.ua.parflare.oop.models.animals.Cat;
import main.java.ua.parflare.oop.models.animals.Dog;
import main.java.ua.parflare.oop.models.shapes.Circle;
import main.java.ua.parflare.oop.models.shapes.Rectangle;
import main.java.ua.parflare.oop.models.shapes.Shape;

import java.util.List;

/**
 * Demonstrates core OOP principles:
 * encapsulation, inheritance, polymorphism, and abstraction.
 *
 * @see Animal
 * @see Dog
 * @see Cat
 * @see Shape
 * @see Circle
 * @see Rectangle
 */
public class OOPDemo {

    public static void main(String[] args) {
        encapsulationExample();
        inheritanceExample();
        polymorphismExample();
        abstractionExample();
        referenceTypesExample();
    }

    /**
     * Demonstrates encapsulation via private fields and public getters/setters.
     */
    public static void encapsulationExample() {
        int age = 30;
        Person p = new Person("Alice", age);
        System.out.println("Person: " + p.getName() + ", age: " + p.getAge());
        p.setAge(age + 1);
        System.out.println("Updated age: " + p.getAge());
    }

    /**
     * Demonstrates inheritance with base class Animal and derived classes.
     */
    public static void inheritanceExample() {
        Dog dog = new Dog("Rex");
        dog.speak();

        Cat cat = new Cat("Whiskers");
        cat.speak();
    }

    /**
     * Demonstrates polymorphism via method overriding and base class reference.
     */
    public static void polymorphismExample() {
        List<Animal> animals = List.of(
                new Dog("Polymorphic Rex"),
                new Cat("Polymorphic Whiskers"));

        for (Animal animal : animals) {
            animal.speak(); // polymorphic dispatch
        }
    }

    /**
     * Demonstrates abstraction using abstract class Shape.
     */
    public static void abstractionExample() {
        int radius = 5;
        Shape s1 = new Circle(radius);

        int width = 4;
        int height = 6;
        Shape s2 = new Rectangle(width, height);

        System.out.println("Circle area: " + s1.getArea());
        System.out.println("Rectangle area: " + s2.getArea());
    }

    /**
     * Demonstrates differences in reference types.
     */
    public static void referenceTypesExample() {
        // Case 1: Reference and object are the same type.
        Dog dog1 = new Dog("Dog1");
        dog1.speak(); // OK
        dog1.fetch(); // OK (specific method in Dog)

        // Case 2: Reference is base type, object is derived type (upcasting).
        Animal dog2 = new Dog("Dog2");
        dog2.speak(); // OK (dynamic dispatch)
        // dog2.fetch(); // Error: fetch() is not in Animal

        // Case 3: Invalid — cannot assign base type object to derived reference.
        // Dog dog3 = new Animal("Dog3"); // Compilation error: Animal is abstract or cannot be cast to Dog

        // If casting manually:
        Animal animal = new Dog("CastDog");
        if (animal instanceof Dog) {
            Dog castedDog = (Dog) animal;
            castedDog.fetch(); // Now works
        }
    }

}

