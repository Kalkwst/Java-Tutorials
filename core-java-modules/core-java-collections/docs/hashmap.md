# HashMap in Java
A HashMap in Java is a data structure that allows us to stroe and retrieve key-value pairs efficiently. It is part of the Java Collections Framework, which provides various interfaces and classes for working with collections of objects. 

A hashmap uses a hash function to map keys to indices in an array, where each index can store a linked list of nodes that contain the key and the value. This way, a hashmap can handle collisions, which occur when two different keys have the same hash value. 

## Initializing a HashMap

Java `HashMap` provides four constructors.

### Default No-Argument Constructor

The default constructor will create an empty `HashMap` instance. 

```java
HashMap<String, String> map = new HashMap<>();
assertTrue(map.isEmpty());
```

While the map is indeed empty, the `HashMap` has a default initial capacity of 16 and load factor of 0.75.

### Initial Capacity Accepting Constructor

We can specify the initial capacity of the `HashMap` instance in the constructor.

```java
HashMap<String, String> map = new HashMap<>(100);
```

The map will have the specified initial capacity and a default load factor of 0.75. This is useful in avoiding rehashing if you know the number of mappings to be stored in the `HashMap`.

### Initial Capacity and Load Factor Accepting Constructor

We can specify the initial capacity and load factor of the `HashMap` instance in the constructor.

```java
HashMap<String, String> map = new HashMap<>(32, 0.8f);
```

The map will have the specified initial capacity and load factor. You can use this if you know the maximum number of mappings to be stored in `HashMap`. In common scenarios **you should avoid this** because load factor 0.75 offers a good tradeoff between space and time cost.

### Map Accepting Constructor

Finally we can use a map to initialize our `HashMap`.

```java
HashMap<String, String> map1 = new HashMap<>();

Map<String, String> map2 = new HashMap<>(map1);
```

The map will have the same mappings asthe specified map and with load factor 0.75.

## Java 8 and Java 9 Initialization Methods

There are some more ways to initialize a `HashMap` in Java, both in version 8 and version 9.

### Using Collectors.toMap()

We can use a stream of a two-dimensional array and collect them into a map:

```java
Map<String, String> map = Stream.of(new String[][] {
    { "Hello", "World" },
    { "John", "Doe" },
}).collect(Collectors.toMap(
    data -> data[0],
    data -> data[1]
));
```

Note that the data types of the key and the value of the `Map` is the same.
We can create a more generic, we can use an array of `Object`s and perform the same operation:

```java
Map<String, Integer> map = Stream.of(new Object[][]{
    { "data1", 1 },
    { "data2", 2 },
}).collect(Collectors.toMap(
    data -> (String) data[0],
    data -> (Integer) data[1]
));
```

### Using a Stream of `Map.Entry`

Here we are going to use instances of `Map.Entry`, and we can have different key and value types.
We are going to use the `SimpleEntry` implementation of the `Entry` interface:

```java
Map<String, Integer> map = Stream.of(
    new AbstractMap.SimpleEntry<>(1, "desktop"),
    new AbstractMap.SimpleEntry<>(2, "laptop"),
    new AbstractMap.SimpleEntry<>(3, "mobile")
).collect(Collectors.toMap(
    Map.Entry::getKey,
    Map.Entry::getValue
));
```

We can also make the entries immutable using the `SimpleImmutableEntry` implementation of the `Entry` interface:

```java
Map<String, Integer> map = Stream.of(
    new AbstractMap.SimpleImmutableEntry<>(1, "desktop"),
    new AbstractMap.SimpleImmutableEntry<>(2, "laptop"),
    new AbstractMap.SimpleImmutableEntry<>(3, "mobile")
).collect(Collectors.toMap(
    Map.Entry::getKey,
    Map.Entry::getValue
));
```

### Initializing an Immutable Map

We can create an immutable map by wrapping the `Collectors.toMap()` inside `Collectors.collectingAndThen()`.

```java
Map<String, String> map = Stream.of(new String[][]{
    { "Hello", "World" },
    { "John", "Doe" },
}).collect(Collectors.collectingAndThen(
    Collectors.toMap(
        data -> data[0], 
        data -> data[1]
    ),
    Collections::<String, String> unmodifiableMap
));
```

⚠️We should avoid using this implementation, as it can cause a huge performance overhead and lots of garbage objects are created just to initialize the map.

### Using `Map.of()`

The `Map.of()` factory method can take no arguments, a single argument, and multiple arguments.

```java
Map<String, String> emtpyMap = Map.of();
Map<String, String> singletonMap = Map.of("key1", "value");
Map<String, String> map = Map.of("key1", "value1", "key2", "value2");
```

⚠️Note that this method supports only a maximum of 10 key-value pairs.

### Using `Map.ofEntries()`

The `Map.ofEntries()` is a similar implementation to the `Map.of()` but has no limitations on the number of key-value pairs:

```java
Map<String, String> map = Map.ofEntries(
    new AbstractMap.SimpleEntry<String, String>("name", "George"),
    new AbstractMap.SimpleEntry<String, String>("city", "Prague"),
    new AbstractMap.SimpleEntry<String, String>("zipCode", "12345"),
    new AbstractMap.SimpleEntry<String, String>("phone", "123-123-212")
)
```

This factory method produces will produce an immutable map, hence any mutation will result in an `UnsupportedOperationException`. Also, they do not allow for null keys or duplicate keys.

## Basic HashMap Operations

### Adding elements in the HashMap

We can add elements in the `HashMap` we can use the `put(K key, V value)` method. This method also returns the value added.

```java
Map<String, String> map = new HashMap<>();

map.put("johnDoe@example.com", UUID.randomUUID().toString());
map.put("janeDoe@example.com", UUID.randomUUID().toString());
map.put("alice@example.com", UUID.randomUUID().toString());
```

Note that if the key already exists, **the previous value will be replaced**.

### Access Elements in the HashMap

We can access a specific element in the hash map using the `get(Object key)` method.

```java
String value = map.get("johnDoe@example.com");
System.out.println(value); //=> a UUID
```

### Clearing a HashMap

We can clear all the mappings and make the `HashMap` empty by using the `clear()` method.

```java
map.clear();
```

### Removing Elements from the HashMap

To remove items from the `HashMap` we can use the `remove(Object key)` method. The method will remove the mapping for the specified key from the map if present. It will also return the value of the removed mapping.

```java
String value = map.remove("alice@example.com");
```

### Checking for keys and values

We can check if a specific key or value exists in the `HashMap`. 

To check for keys can use the `containsKey(Object key)` method that will return `true` if the key exists, otherwise it will return `false`.

```java
map.containsKey("johnDoe@example.com"); //=> true
map.containsKey("thisIsAKey"); //=> false
```

To check for values we can use the `containsValue(Object value)` method that will return `true` if the value exists, otherwise it will return `false`.

## HashMap Internals

### What the internal hash bucket array?

The data structure used to hold the buckets or slots where key-value pairs are arranged is called an internal array for a hash map. There are several names for this array, such as "table" or "bucket array." To handle key collisions, Java's internal array consists of an array of linked lists, or (in Java 8 and subsequent versions) a combination of linked lists and balanced trees.

### What is a bucket in HashMap?

In a `HashMap`, a bucket refers to an individual storage location within the internal array where key-value pairs are stored. The `HashMap` uses these buckets to organize and manage its key-value pairs efficiently.

Here's how it works:
1. When you add a key-value pair to a `HashMap`, the `HashMap`