package sitecore.sherpa.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExamples {
    public static void main(String[] args) {
        // Create a String type arraylist
        List<String> languages = new ArrayList<>();

        // Add elements to the array list
        languages.add("Java");
        languages.add("C#");
        languages.add("Python");
        languages.add("Groovy");

        System.out.println(languages);

        // Get the element from the ArrayList
        String language = languages.get(1);
        System.out.println("Element at index 1: " + language);

        // Change the element of the array list
        languages.set(1, "Kotlin");
        languages.set(2, "Scala");

        System.out.println("Modified ArrayList: " + languages);

        // Remove an element from the ArrayList
        String removed = languages.remove(3);
        System.out.println(removed);

        // Get the index of Kotlin
        int firstOccurence = languages.indexOf("Kotlin");
        System.out.println(firstOccurence);

        languages.add("Kotlin");

        // Get the last index of Kotlin
        int lastOccurrence = languages.lastIndexOf("Kotlin");
        System.out.println(lastOccurrence);

        // Iterate through the list using for-each
        for(String language2 : languages){
            System.out.println(language2);
        }
    }
}
