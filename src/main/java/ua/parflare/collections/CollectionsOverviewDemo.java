package main.java.ua.parflare.collections;

import java.util.*;

public class CollectionsOverviewDemo {

    public static void main(String[] args) {
        printCollectionSummaries();
    }

    private static void printCollectionSummaries() {
        printListExamples();
        printSetExamples();
        printMapExamples();
    }

    private static void printMapExamples() {
        System.out.println("\nMap examples:");

        // HashMap: key-value pairs, unordered, allows null key and values
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(null, "NullKey");
        System.out.println("HashMap (unordered, allows null key): " + hashMap);

        // TreeMap: key-value pairs sorted by keys, no null keys allowed
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        System.out.println("TreeMap (sorted by keys): " + treeMap);

        // LinkedHashMap: key-value pairs, maintains insertion order
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(10, "Ten");
        linkedHashMap.put(20, "Twenty");
        linkedHashMap.put(10, "Updated Ten"); // key updated, order unchanged
        System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);
    }

    private static void printSetExamples() {
        System.out.println("\nSet examples:");

        // HashSet: unique elements, unordered
        Set<String> hashSet = new HashSet<>(Arrays.asList("red", "green", "blue", "red"));
        System.out.println("HashSet (unique, unordered): " + hashSet);

        // TreeSet: unique elements, sorted by natural order
        Set<String> treeSet = new TreeSet<>(Arrays.asList("zebra", "antelope", "lion"));
        System.out.println("TreeSet (unique, sorted): " + treeSet);

        // LinkedHashSet: unique elements, maintains insertion order
        Set<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList("one", "two", "three", "two"));
        System.out.println("LinkedHashSet (unique, insertion order): " + linkedHashSet);
    }

    private static void printListExamples() {
        System.out.println("List examples:");

        // ArrayList: resizable array, maintains insertion order, allows duplicates
        ArrayList<String> arrayList = new ArrayList<>(10); // initial capacity = 10
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("apple"); // duplicate element
        arrayList.add("orange");

        arrayList.trimToSize(); // reduce capacity to match current size
        arrayList.addAll(Arrays.asList("grape", "melon")); // add multiple elements at once

        System.out.println("ArrayList: " + arrayList);
        System.out.println("ArrayList (reversed): " + arrayList.reversed());
        System.out.println("Size: " + arrayList.size());
        System.out.println("Contains 'banana'? " + arrayList.contains("banana"));
        System.out.println("Index of 'apple': " + arrayList.indexOf("apple")); // returns first match
        System.out.println("Element at index 2: " + arrayList.get(2));
        arrayList.remove("banana"); // remove by value
        arrayList.remove(0);        // remove by index
        System.out.println("ArrayList after removals: " + arrayList);

        // LinkedList: doubly linked list, efficient inserts/removals at both ends
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("cat");
        linkedList.add("dog");
        linkedList.add("mouse");

        linkedList.addFirst("first"); // add at beginning
        linkedList.addLast("last");   // add at end
        System.out.println("\nLinkedList: " + linkedList);
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());
        System.out.println("Contains 'dog'? " + linkedList.contains("dog"));
        linkedList.removeFirst(); // remove from beginning
        linkedList.removeLast();  // remove from end
        System.out.println("LinkedList after removals: " + linkedList);
    }
}
