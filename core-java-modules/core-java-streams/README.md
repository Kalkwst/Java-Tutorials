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
```

---

[^1]: [java - How can I create a stream from an array? - Stack Overflow](https://stackoverflow.com/questions/27888429/how-can-i-create-a-stream-from-an-array)