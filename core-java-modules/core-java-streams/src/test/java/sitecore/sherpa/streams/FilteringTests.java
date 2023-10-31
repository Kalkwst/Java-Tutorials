package sitecore.sherpa.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FilteringTests {

    @Test
    @DisplayName("Test even numbers filtering with positive numbers")
    public void getEven_whenProvidedWithPositiveNumbers_returnsEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expected = Arrays.asList(2, 4, 6);

        List<Integer> result = Filtering.getEven(numbers);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test even numbers filtering with negative numbers")
    public void getEven_whenProvidedWithNegativeNumbers_returnsEvenNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -4, -5, -6);
        List<Integer> expected = Arrays.asList(-2, -4, -6);

        List<Integer> result = Filtering.getEven(numbers);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test odd numbers filtering with positive numbers")
    public void getOdd_whenProvidedWithPositiveNumbers_returnsOddNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expected = Arrays.asList(1, 3, 5);

        List<Integer> result = Filtering.getOdd(numbers);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test odd numbers filtering with negative numbers")
    public void getOdd_whenProvidedWithNegativeNumbers_returnsOddNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -4, -5, -6);
        List<Integer> expected = Arrays.asList(-1, -3, -5);

        List<Integer> result = Filtering.getOdd(numbers);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test first letter filtering with valid elements")
    public void filterByFirstLetter_whenProvidedWithAnArray_returnsOnlyValidStrings() {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "grape");
        String letter = "b";

        List<String> filteredList = Filtering.filterByFirstLetter(fruits, letter);

        assertEquals("banana", filteredList.get(0));
    }

    @Test
    @DisplayName("Test first letter filtering with no valid elements")
    public void filterByFirstLetter_whenProvidedWithNoMatchingElements_returnsEmptyArray() {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "grape");
        String letter = "z";

        List<String> filteredList = Filtering.filterByFirstLetter(fruits, letter);

        assertEquals(filteredList.size(), 0);
    }

    @Test
    @DisplayName("Test last letter filtering with valid elements")
    public void filterByLastLetter_whenProvidedWithAnArray_returnsOnlyValidStrings() {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "grape");
        String letter = "e";

        List<String> filteredList = Filtering.filterByLastLetter(fruits, letter);

        assertEquals("apple", filteredList.get(0));
        assertEquals("grape", filteredList.get(1));

    }

    @Test
    @DisplayName("Test last letter filtering with no valid elements")
    public void filterByLastLetter_whenProvidedWithNoMatchingElements_returnsEmptyArray() {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "grape");
        String letter = "z";

        List<String> filteredList = Filtering.filterByLastLetter(fruits, letter);

        assertEquals(filteredList.size(), 0);
    }

    @Test
    @DisplayName("Test substring filtering with valid elements")
    public void filterBySubstring_whenProvidedWithMatchingElements_returnsFilteredResults() {
        List<String> inputList = Arrays.asList("apple", "banana", "cherry", "grape");
        String substring = "an";

        List<String> filteredList = Filtering.filterBySubstring(inputList, substring);

        assertEquals("banana", filteredList.get(0));
    }

    @Test
    @DisplayName("Test substring filtering with no valid elements")
    public void filterBySubstring_whenProvidedWithNoMatchingElement_returnsEmptyArray() {
        List<String> inputList = Arrays.asList("apple", "banana", "cherry", "grape");
        String substring = "lz";

        List<String> filteredList = Filtering.filterBySubstring(inputList, substring);

        assertEquals(0, filteredList.size());
    }

    @Test
    @DisplayName("Test any substring filtering with valid elements")
    public void filterByAnySubString_whenProvidedWithMatchingElements_returnsFilteredResults() {
        List<String> inputList = Arrays.asList("apple", "banana", "cherry", "grape");
        List<String> substrings = Arrays.asList("an", "rry");

        List<String> filteredList = Filtering.filterByAnySubString(inputList, substrings);

        assertEquals("banana", filteredList.get(0));
        assertEquals("cherry", filteredList.get(1));
    }

    @Test
    @DisplayName("Test any substring filtering with no valid elements")
    public void filterByAnySubString_whenProvidedWithNoMatchingElements_returnsFilteredResults() {
        List<String> inputList = Arrays.asList("apple", "banana", "cherry", "grape");
        List<String> substrings = Arrays.asList("lz", "bp");

        List<String> filteredList = Filtering.filterByAnySubString(inputList, substrings);

        assertEquals(0, filteredList.size());
    }

    @Test
    @DisplayName("Test all substrings filtering with valid elements")
    public void filterByAllSubStrings_whenProvidedWithMatchingElements_returnsFilteredResults() {
        List<String> inputList = Arrays.asList("apple", "banana", "cherry", "grape");
        List<String> substrings = Arrays.asList("ba", "na");

        List<String> filteredList = Filtering.filterByAllSubStrings(inputList, substrings);

        assertEquals("banana", filteredList.get(0));
    }

    @Test
    @DisplayName("Test all substrings filtering with no valid elements")
    public void filterByAllSubString_whenProvidedWithNoMatchingElements_returnsFilteredResults() {
        List<String> inputList = Arrays.asList("apple", "banana", "cherry", "grape");
        List<String> substrings = Arrays.asList("lz", "bp");

        List<String> filteredList = Filtering.filterByAllSubStrings(inputList, substrings);

        assertEquals(0, filteredList.size());
    }
}
