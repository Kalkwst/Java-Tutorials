package sitecore.sherpa.streams;

import java.util.List;
import java.util.stream.Collectors;

import sitecore.sherpa.streams.helpers.Person;

public class Projection {
    
    /**
     * Retrieves a list of IDs from a list of Person objects.
     * @param people a list of Person objects
     * @return a list of IDs as strings
     */
    public static List<String> getIds(List<Person> people) {
        return people.stream()
                    .map(Person::getId)
                    .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of names from a list of Person objects.
     * @param people a list of Person objects
     * @return a list of names as strings
     */
    public static List<String> getNames(List<Person> people) {
        return people.stream()
                    .map(Person::getName)
                    .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of ages from a list of Person objects.
     * @param people a list of Person objects
     * @return a list of ages as integers
     */
    public static List<Integer> getAges(List<Person> people) {
        return people.stream()
                    .map(Person::getAge)
                    .collect(Collectors.toList());
    }

}
