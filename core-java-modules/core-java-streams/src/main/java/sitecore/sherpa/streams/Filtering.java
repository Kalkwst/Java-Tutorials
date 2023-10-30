package sitecore.sherpa.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Filtering {

    /**
     * Filters the input list of integers and returns a new list containing only
     * even numbers.
     * 
     * @param numbers the list of integers to be filtered
     * @return a new list containing only the even numbers from the input list
     */
    public static List<Integer> getEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    /**
     * Filters the input list of integers and returns a new list containing only odd
     * numbers.
     * 
     * @param numbers the list of integers to be filtered
     * @return a new list containing only the odd numbers from the input list
     */
    public static List<Integer> getOdd(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
    }

    /**
     * Filters the input list of strings and returns a new list containing only
     * strings that start with a specified letter.
     * 
     * @param strings the list of strings to be filtered
     * @param letter  the letter that each string should start with
     * @return a new list containing only the strings from the input list that start
     *         with the specified letter
     */
    public static List<String> filterByFirstLetter(List<String> strings, String letter) {
        return strings.stream()
                .filter(s -> s.startsWith(letter))
                .collect(Collectors.toList());
    }

    /**
     * Filters the input list of strings and returns a new list containing only
     * strings that end with the specified letter.
     * 
     * @param strings the list of strings to be filtered
     * @param letter  the letter of each string should end with
     * @return a new list containing only the strings from the input list that end
     *         with the specified letter
     */
    public static List<String> filterByLastLetter(List<String> strings, String letter) {
        return strings.stream()
                .filter(s -> s.endsWith(letter))
                .collect(Collectors.toList());
    }

    /**
     * Filters the input list of strings and returns a new list containing only
     * strings that contain the specified substring.
     * 
     * @param strings   the list of strings to be filtered
     * @param substring the substring that each string should contain
     * @return a new list containing only the strings from the input list that
     *         contain the specified substring
     */
    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    /**
     * Filters the input list of strings and returns a new list containing only
     * strings that contain any of the specified substrings.
     * 
     * @param strings    the list of strings to be filtered
     * @param substrings the substrings that each string should contain any of them
     * @return a new list containing only the strings from the input list that
     *         contain any of the specified substrings
     */
    public static List<String> filterByAnySubString(List<String> strings, List<String> substrings) {
        return strings.stream()
                .filter(s -> substrings.stream().anyMatch(s::contains))
                .collect(Collectors.toList());
    }

    /**
     * Filters the input list of strings and returns a new list containing only
     * strings that contain all of the specified substrings.
     * 
     * @param strings    the list of strings to be filtered
     * @param substrings the substrings that each string should contain all of them
     * @return a new list containing only the strings from the input list that
     *          contain all of the specified substrings
     */
    public static List<String> filterByAllSubStrings(List<String> strings, List<String> substrings) {
        return strings.stream()
                .filter(s -> substrings.stream().allMatch(s::contains))
                .collect(Collectors.toList());
    }
}