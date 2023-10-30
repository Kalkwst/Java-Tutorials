package sitecore.sherpa.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FilteringTests {

    @Test
    public void getEven_whenProvidedWithPositiveNumbers_returnsEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expected = Arrays.asList(2, 4, 6);

        List<Integer> result = Filtering.getEven(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void getEven_whenProvidedWithNegativeNumbers_returnsEvenNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -4, -5, -6);
        List<Integer> expected = Arrays.asList(-2, -4, -6);

        List<Integer> result = Filtering.getEven(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void getOdd_whenProvidedWithPositiveNumbers_returnsOddNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expected = Arrays.asList(1, 3, 5);

        List<Integer> result = Filtering.getOdd(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void getOdd_whenProvidedWithNegativeNumbers_returnsOddNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -4, -5, -6);
        List<Integer> expected = Arrays.asList(-1, -3, -5);

        List<Integer> result = Filtering.getOdd(numbers);

        assertEquals(expected, result);
    }
}
