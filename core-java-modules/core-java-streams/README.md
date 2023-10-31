# Java Streams
In Java, streams are a powerful feature introduced in Java 8 that allows us to process collections of objects in a functional and declarative manner. They allow us to perform operations on a sequence of elements, such as filtering, mapping, sorting, aggregate and more. They are similar to C#'s LINQ, however there are some differences between them.

Streams can be created from various sources, such as arrays, collections, or generators. Streams can also be parallelized to take advantage of multiple cores and improve performance.

Here are some key points about java streams and how they are different from LINQ:
- Java streams are **lazy**, meaning that they don't execute any computation until a **terminal operation** is invoked, such as `forEach`, `count`, `reduce`, or `collect`. Terminal operations consume the stream and produce a result or a side-effect.  In contrast, LINQ queries are **eager**, meaning that they execute immediately and return an `IEnumerable` that can be iterated over multiple times.
- Java streams have **intermediate operations**, such as `filter`, `map`, `flatMap`, or `distinct`, that transform the stream to another stream. Intermediate operations are also lazy and return a new stream that is composed of the previous stream and the operation. In contrast, LINQ has **extension methods**, such as `Where`, `Select`, `SelectMany`, or `Distinct`, that operate on an `IEnumerable` and return another `IEnumerable`.
- Java streams are **pipelined**, meaning that the elements of the stream are processed one by one, instead of batches. This allows for better performance and memory efficiency, as well as avoiding intermediate collections. In contrast, LINQ queries are **composed**, meaning that they create intermediate collections for each operation and then combine them at the end.
- Java streams are **not reusable**, meaning that once a terminal operation is performed on a stream, the stream is considered consumed and cannot be used again. If we need to reuse a stream, we have to create a new one from the source. In contrast, LINQ queries are **reusable**, meaning that we can iterate over an `IEnumerable` multiple times, as long as the source does not change.

## Stream Creation
There are many options for creating a stream instance from various sources. Once generated, the instance will not modify its source, allowing multiple instances to be created from a single source.

### Empty Streams
In Java, we can create an empty stream using the `empty()` method provided by the `Stream` class.

```java
Stream<String> emptyStream = Stream.empty();
```

We usually use the `empty()` method to avoid returning *null* for streams with no element:
```java
public Stream<String> streamOf(List<String> list) {
    return list == null || list.isEmpty() ? Stream.empty() : list.stream();
}
```

### Collection Streams 
One of the most common ways to create a stream from a collection is to use the `stream()` method that is available for any colleciton that implements the `Collection` interface, such as `List`, `Set`, or `Queue`. This method returns a sequential stream of the elements in the collection.

```java
// Create a list of strings
List<String> names = List.of("Alice", "Bob", "Charlie", "David");

// Create a stream from the list using stream()
Stream<String> nameStream = names.stream();

// Print the stream elements
nameStream.forEach(System.out::println);
```

Another way to create a stream from a collection is to use the `parallelStream()` method that is also available for any collection that implements the `Collection` interface. This method returns a parallel stream of the elements in the collection, which means that the stream can be processed by multiple threads concurrently. This can improve the performance of some operations, but it can also introduce some challenges, such as ordering and synchronization.

```java
// Create a set of integers
Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);

// Create a parallel stream from the set using parallelStream()
Stream<Integer> numberStream = numbers.parallelStream();

// Print the stream elements
numberStream.forEach(System.out::println);
```

⚠ **Warning**: Note that the order of elements in the parallel stream may not be the same as the order of the elements in the original collection.

### Array Streams
To create a stream from an array in Java, we can use the `Arrays.stream()` method, which takes an array as a parameter and returns a stream of the elements in the array.

```java
// Create an array of integers
int[] numbers = new int[] {1, 2, 3, 4, 5};

// Create a stream of array using Arrays.stream()
Stream<Integer> numberStream = Arrays.stream(numbers);
```

We can also use the `Stream.of()` methid, which takes a variable number of arguments and returns a stream of the arguments.
```java
Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5);
```

⚠ **Warning**: Note that if you pass an array of primitive types to `Stream.of()`, you will get a stream of arrays, not a stream of elements[^1].

```java
// Create an array of integers
int[] numbers = new int[] {1, 2, 3, 4, 5};

// Create a stream of array using Stream.of()
Stream<int[]> numberStream = Stream.of(numbers); // This is a stream of int[], not a stream of int
```

To avoid this, you can use the `Arrays.stream()` method or use a wrapper class for the primitive type.

```java
// Create an array of integers
int[] numbers = new int[] {1, 2, 3, 4, 5};

// Create a stream of array using Stream.of() and Integer wrapper class
Stream<Integer> numberStream = Stream.of(
    Integer.valueOf(numbers[0]), 
    Integer.valueOf(numbers[1]), 
    Integer.valueOf(numbers[2]), 
    Integer.valueOf(numbers[3]), 
    Integer.valueOf(numbers[4])
);
```

### Stream Builders
A builder is an object that allows us to create a stream by adding elements individually, without the copying overhead that comes from using an array or a list as a temporary buffer.

A stream builder has a lifecycle, which starts in a building phase, during which elements can be added and then transitions to a built phase, after which elements may not be added. The built phase begins when the `build()` method is called, which creates an ordered stream whose elements are the elements that were added to a stream builder, in the order they were added.

```java
// Create a stream builder for a stream of strings
Stream.Builder<String> builder = Stream.builder();

// Add some elemetns to the stream builder
builder.add("Hello")
    .add("World")
    .add("!");

// Build the stream from the stream builder
Stream<String> stream = builder.build();

// Print the elements of the stream
stream.forEach(System.out::println);
```

### Stream Generation
The `Stream.generate` is a method that creates an infinite stream of elements by using a supplier function. A supplier is a functional interface that takes no arguments and returns a value. `Stream.generate` can be used to create streams of constant values, random values, or any other values that can be generated by a supplier.

```java
import java.util.Random;

// Create a Random object
Random rand = new Random();

// Create a stream of 10 random numbers using stream.generate
Stream<Integer> stream = Stream.generate(() -> rand.nextInt(100)).limit(10);

// Print the stream elements
stream.forEach(System.out::println);
```

Note that `stream.generate` creates an infinite stream, so you need to use the `limit` method to specify how many elements you want int the stream. Otherwise, the stream will never end and may cause an out-of-memory error.

## Referencing a Stream
It is possible to create a stream and have a reference to it as long as only the intermediate steps are called. When we call a terminal action, we block access to the stream.

```java
Stream<String> stream = Stream.of("a", "b", "c")
            .filter(element -> element.contains("b"));

Optional<String> anyElement = stream.findAny();
```

However, an attempt to reuse the same reference after calling the terminal operation will trigger the *IllegalStateException*

```java
Optional<String> firstElement = stream.findFirst();
```

Since the *IllegalStateException* is a *RuntimeException*, the compiler will not warn us about the problem. It is very importan to remember that **streams are not reusable**.

To make the above code functional, we need to create two new streams.

```java
List<String> elements = Stream.of("a", "b", "c")
                        .filter(element -> element.contains("b"))
                        .collect(Collectors.toList());

Optional<String> anyElement = elements.stream().findAny();
Optional<String> firstElement = elements.stream().findFirst();
```

## Intermediate Operations
Intermediate operations are operations that are applied to a stream to transform, filter, or manipulate its elements. These operations are often used in a sequence and return a new stream, which allows for method chaining.

Intermediate operations do not produce a final result on their own; they set up the stream for further processing.

### Filter (`filter()`)
Returns a stream consisting of elements that match a given predicate.

```java
Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);
Stream<Integer> subStream = intStream.filter(value -> value > 3);

long count = subStream.count(); //=> 2
```

### Map (`map()`)
Returns a stream with the results of applying a function to each element.

```java
Stream<String> strStream = Stream.of("Welcome", "To", "C#", "Training");
Stream<String> subsStream = strStream.map(string -> {
    if(string.equals("C#"))
        return string;
});

List<string> welcomeList = subStream2.collect(Collectors.toList()); 
//=> [Welcome, To, Java, Training]
```

### FlatMap (`flatMap()`)
Converts multiple lists into a single stream.

```java
List<List<String>> fruitLists = Arrays.asList(
    Arrays.asList("apple", "banana", "cherry"),
    Arrays.asList("date", "elderberry", "figs" )
);

List<String> fruits = fruitLists.stream()
                                .flatMap(List::stream)
                                .collect(Collectors.toList());
//=> [apple, banana, cherry, date, elderberry, figs]
```

### Distinct (`distinct()`)
Returns a stream with distinct elements.

```java
Stream<Integer> numbers = Stream.of(1, 2, 2, 3, 3, 4);
List<Integer> distinctNumbers = numbers.distinct()
                                       .collect(Collectors.toList());
//=> [1, 2, 3, 4]
```

### Sorted (`sorted()`)
Returns a stream with elements sorted according to natural order or a custom comparator.

```java
List<List<String>> fruitLists = Arrays.asList(
    Arrays.asList("date", "elderberry", "figs"),
    Arrays.asList("apple", "banana", "cherry")
);

List<String> sortedWords = fruitLists.stream()
                                     .flatMap(List::stream)
                                     .sorted()
                                     .collect(Collectors.toList());
//=> [apple, banana, cherry, date, elderberry, figs]
```

### Peek (`peek()`)
Allows us to perform an action on each element without altering the stream. This is useful for debugging or logging intermediate results.

### Limit (`limit()`) and Skip (`skip()`)
- `limit(n)` returns the first `n` elements of the stream.
- `skip(n)` discards the first `n` elements of the stream.

```java
Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
List<Integer> limitedNumbers = numbers
                                .skip(2)
                                .limit(2)
                                .collect(Collections.toList());
//=> [3, 4]
```

---

[^1]: [java - How can I create a stream from an array? - Stack Overflow](https://stackoverflow.com/questions/27888429/how-can-i-create-a-stream-from-an-array)