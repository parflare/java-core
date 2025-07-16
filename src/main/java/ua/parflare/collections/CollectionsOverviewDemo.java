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
        List<String> arrayList = new ArrayList<>(Arrays.asList("apple", "banana", "apple"));
        System.out.println("ArrayList (allows duplicates, ordered): " + arrayList);

        // LinkedList: list optimized for fast insertions/removals anywhere
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("dog", "cat", "mouse"));
        linkedList.addFirst("wolf");
        System.out.println("LinkedList (fast insert/remove): " + linkedList);
    }
}
