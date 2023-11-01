package sitecore.sherpa.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sitecore.sherpa.streams.helpers.Person;

public class ProjectionTests {
    private List<Person> people;
    private List<String> ids;

    @BeforeEach
    public void setUp() {
        ids = new ArrayList<>();
        ids.add(UUID.randomUUID().toString());
        ids.add(UUID.randomUUID().toString());
        ids.add(UUID.randomUUID().toString());

        people = new ArrayList<>();
        people.add(new Person(ids.get(0), "Alice", 25));
        people.add(new Person(ids.get(1), "Bob", 32));
        people.add(new Person(ids.get(2), "Charles", 109));
    }

    @Test
    @DisplayName("Test getIds method")
    public void testGetIds() {
        List<String> actualIds = Projection.getIds(people);

        assertEquals(ids, actualIds, "IDs should match");
    }

    @Test
    @DisplayName("Test getNames method")
    public void testGetNames() {
        List<String> expectedNames = List.of("Alice", "Bob", "Charles");
        List<String> actualNames = Projection.getNames(people);

        assertEquals(expectedNames, actualNames);
    }

    @Test
    @DisplayName("Test getAges method")
    public void testGetAges() {
        List<Integer> expectedAges = List.of(25, 32, 109);
        List<Integer> actualAges = Projection.getAges(people);

        assertEquals(expectedAges, actualAges);
    }
}
