# Array List in Java
In Java, an array list is a data structure that allows you to store and manage a set of elements. In contrast to a standard array, which has a fixed size and cannot be altered once generated, an array list can expand and shrink dynamically as members are added or removed. When you don't know the precise amount of elements ahead of time, it is more flexible and convenient to utilize.

In Java, an array list is an object of the `ArrayList` class, which implements the `List` interface. The `List` interface is a subinterface of the `Collection` interface, which describes how all collections in Java behave. The `ArrayList` class provides many methods to conduct various actions on the elements, including adding, removing, accessing, sorting, searching, reversing, and more. To traverse the elements of an array list, you may either use the extended for loop or the iterator.

## Table of Contents
- [Array List in Java](#array-list-in-java)
  - [Table of Contents](#table-of-contents)
  - [Initializing an ArrayList](#initializing-an-arraylist)
    - [Default No-Arguments Constructor](#default-no-arguments-constructor)
    - [Initial Capacity Accepting Constructor](#initial-capacity-accepting-constructor)
    - [Collection Accepting Constructor](#collection-accepting-constructor)
    - [What is the difference between the default constructor and the constructor with initial capacity?](#what-is-the-difference-between-the-default-constructor-and-the-constructor-with-initial-capacity)
  - [Basic ArrayList Operations](#basic-arraylist-operations)
    - [Adding elements to the ArrayList](#adding-elements-to-the-arraylist)
  - [Accessing Elements in the ArrayList](#accessing-elements-in-the-arraylist)
  - [Setting Elements in the ArrayList](#setting-elements-in-the-arraylist)
  - [Removing Elements in the ArrayList](#removing-elements-in-the-arraylist)
  - [Checking if an element exists in the ArrayList](#checking-if-an-element-exists-in-the-arraylist)
  - [Getting the size of the ArrayList](#getting-the-size-of-the-arraylist)
  - [Best Practices](#best-practices)
    - [Capacity Management](#capacity-management)
    - [Usage of ArrayList](#usage-of-arraylist)

## Initializing an ArrayList

The `ArrayList` is a generic class, so we can parameterize it with any type we want, and the compiler will ensure type safety. Also it is a good practice to use the generic `List` interface as the variable type, since it decouples it from a particular implementation.

### Default No-Arguments Constructor

The default constructor will create an empty `ArrayList` instance.

```java
List<String> list = new ArrayList<>();
assertTrue(list.isEmpty());
```

While the list is indeed empty, the internal array backing up the `ArrayList` has a size of 10 by default.

### Initial Capacity Accepting Constructor

We can specify the initial capacity of the `ArrayList` instance in the constructor.

```java
List<String> list = new ArrayList<>(20);
```

### Collection Accepting Constructor

Finally we can use a collection to initialize our `ArrayList`.

```java
// Number of random numbers to generate
int count = 20;

// Create a Random object
Random random = new Random();

// Generate a stream of random integers
IntStream randomStream = random.ints(count);

// Create a collection based on the randomStream
Collection collection = randomStream.collect(toSet());

List<Integer> list = new ArrayList<>(collection);
```

### What is the difference between the default constructor and the constructor with initial capacity?

We can improve the list's performance and memory use by using the different constructors that have different starting capacities. 

If you know ahead of time how many items you want to put in the list, you can use the constructor with initial capacity to avoid copying and resizing the internal array too many times. 

Resizing and copying are both expensive tasks that could slow down a list. 

You can use the default constructor to make a list with a good starting capacity that can grow as needed if you don't know how many items you will store in it.

## Basic ArrayList Operations

### Adding elements to the ArrayList

There are three ways to add elements in the array list. First, we can just elements to the end of the array list using the `add(T value)` method.

```java
List<Integer> integerList = new ArrayList<>();

list.add(1);
list.add(2);
```

We can also add elements to specific locations to the array list using the `add(int index, T value)` method.

```java
List<String> integerList = new ArrayList<>();

list.add(0, "Hello");
list.add(1, "World!");
```

Finally, we can add multiple values in the `ArrayList` using the `AddAll(Collection c)` method. Again, we can specify an index using the `AddAll(int index, Collection c)` method.

```java
List<Integer> list = new ArrayList<>(); 

Collection<Integer> numbers = 
        IntStream.range(0, 10)
                 .boxed()
                 .collect(toSet());

list.AddAll(numbers);
```

## Accessing Elements in the ArrayList

We can access a specific element in the array list using the `get(int index)` method.

```java
List<Integer> integerList = new ArrayList<>();

list.add(1);
list.add(2);

list.get(0) //=> 1
```

## Setting Elements in the ArrayList

We can replace an element in the array list using the `set(int index, T value)` method.

```java
List<Integer> integerList = new ArrayList<>();

list.add(1);
list.add(2);

list.set(0, 12);

list.get(0); //=> 12
```

## Removing Elements in the ArrayList

To remove items from the array list we can follow two approaches. We can either remove an element based on its index, or its value. To remove an element based on its index, we can use the `remove(int index)` method.

```java
List<Integer> integerList = new ArrayList<>();

list.add(1);
list.add(2);

list.remove(0);

list.get(0); //=> 2
```

To remove an element based on its value, we can use the `remove(T value)` method. This will remove **only the first occurrence of this value** and not all occurrences of this value in the array list.

```java
List<String> stringList = new ArrayList<>();

list.add("a");
list.add("b");
list.add("a");

list.remove("a");

list.get(0); //=> "b"
list.get(1); //=> "a"
```

## Checking if an element exists in the ArrayList

We can test if an element exists in the `ArrayList` we can use the `contains(T value)` method. This will return `true` if there is an occurrence of this element in the `ArrayList`, or `false` if it doesn't exist.

```java
List<String> stringList = new ArrayList<>();

list.add("a");
list.add("b");

list.contains("a"); //=> true
list.contains("c"); //=> false
```

## Getting the size of the ArrayList

We can get the size of the array list using the `size()` method.

```java
List<Integer> intList = new ArrayList<>();

list.add(1);
list.add(2);
list.add(3);

list.size() //=> 3
```

## Best Practices

### Capacity Management
- Setting a large enough initial capacity when creating an `ArrayList` to avoid frequent resizing and copying of the internal array. Resizing and copying are expensive operations that can affect the performace and memory usage of the `ArrayList`. The default capacity is 10, but you can specify a different value using the constructor that takes an int parameter.

```java
ArrayList<Integer> numbers = new ArrayList<>(100); // Create a new ArrayList with an initial capacity of 100
```

- Using the `ensureCapacity()` method to increase the capacity of the internal array before adding a large number of elements to the `ArrayList`. This can prevent multiple resizing and copying operations and improve the performance of the `ArrayList`. The `ensureCapacity()` method takes an int parameter that specifies the minimum desired capacity of the internal array.

```java
numbers.ensureCapacity(200); // Ensure that the internal array can hold at least 200 elements

for(int i = 0; i < 100; i++) {
    numbers.add(i);
}
```

- Avoiding unnecessary boxing and unboxing of primitive types when using an `ArrayList`. Boxing and unboxing are conversions between primitive types (such as `int`, `double` or `boolean`) and their corresponding wrapper classes (such as `Integer`, `Double` or `Boolean`). Boxing and unboxing can cause performance overhead and memory consumption when working with an `ArrayList`. To avoid this, you can use specialized classes that implement the `List` interface for primitive types, such as `IntArrayList`, `DoubleArrayList`, or `BooleanArrayList`. These classes are provided by third-party libraries, such as [Apache Commons Primitives](https://commons.apache.org/dormant/commons-primitives/).

```java
import org.apache.commons.collections.primitives.IntList;
import org.apache.commons.collections.primitives.ArrayIntList;

// Create an IntList using Apache Commons Primitives
IntList numbers = new ArrayIntList();

// Add a primitive int to the IntList
numbers.add(10);

// Get a primitive int from the IntList
int first = numbers.get(0); //=> 10
```

### Usage of ArrayList

- Use the interface type `List<E>` when declaring an array list, rather than the implementation type `ArrayList<E>`. This makes your code more flexible and adaptable to changes.

Instead of writing:
```java
ArrayList<String> names = new ArrayList<String>();
```

You should write:
```java
List<String> names = new ArrayList<String>();
```

- Use the generic type parameter `<E>` to specify the type of elements that the array list can hold. This makes your code more type-safe and avoids unnecessary casting and runtime errors. For example, instead of writing:
```java
List names = new ArrayList(); // Raw type, not recommended

names.Add("Alice");
names.add(10); // This will compile, but will throw a ClassCastException at runtime
```

You should write:
```java
List<String> names = new ArrayList<String>(); // Generic type, recommended

names.Add("Alice");
names.Add(10); // This will not compile, as 10 is not a String
```

- Use the diamond operator `<>` when creating an array list in Java 7 or later. This allows the compiler to infer the type parameter from the context and reduces code verbosity. For example, instead of writing:
```java
List<String> names = new ArrayList<String>();
```

You can write:
```java
List<String> names = new ArrayList<>();
```