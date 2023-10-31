package sitecore.sherpa.streams.helpers;

public class Person {
    private String id;
    private String name;
    private int age;
    
    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
