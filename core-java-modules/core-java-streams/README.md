# Java Streams
In Java, streams are a powerful feature introduced in Java 8 that allows us to process collections of objects in a functional and declarative manner. They allow us to perform operations on a sequence of elements, such as filtering, mapping, sorting, aggregate and more. They are similar to C#'s LINQ, however there are some differences between them.

Streams can be created from various sources, such as arrays, collections, or generators. Streams can also be parallelized to take advantage of multiple cores and improve performance.

Here are some key points about java streams and how they are different from LINQ:
- Java streams are **lazy**, meaning that they don't execute any computation until a **terminal operation** is invoked, such as `forEach`, `count`, `reduce`, or `collect`. Terminal operations consume the stream and produce a result or a side-effect.  In contrast, LINQ queries are **eager**, meaning that they execute immediately and return an `IEnumerable` that can be iterated over multiple times.

## Stream Creation
There are many options for creating a stream instance from various sources. Once generated, the instance will not modify its source, allowing multiple instances to be created from a single source.

### Empty Streams
In Java, we can create an empty stream using the `empty()` method provided by the `Stream` class.