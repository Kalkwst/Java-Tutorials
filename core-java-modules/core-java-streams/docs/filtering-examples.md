# Filtering Examples

## Get even numbers from the input collection

<table>
<tr>
<th>C# LINQ</th>
<th>Java Streams</th>
</tr>
<tr>
<td>

```csharp
List<int> numbers = new List<int> {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

var evenNumbers = numbers.Where(n => n % 2 == 0);

foreach (var number in evenNumbers)
{
    Console.WriteLine(number);
}
```

</td>
<td>

```java
List<Integer> numbers = new List<Integer> {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

List<Integer> evenNumbers = 
            numbers.stream()
                   .filter(n -> n % 2 == 0)
                   .collect(Collectors.toList());

evenNumbers.stream().forEach(System.out::println);
```

</td>
</tr>
</table>

## Get odd numbers from the input collection

<table>
<tr>
<th>C# LINQ</th>
<th>Java Streams</th>
</tr>
<tr>
<td>

```csharp
List<int> numbers = new List<int> {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

var oddNumbers = numbers.Where(n => n % 2 != 0);

foreach (var number in oddNumbers)
{
    Console.WriteLine(number);
}
```

</td>
<td>

```java
List<Integer> numbers = new List<Integer> {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

List<Integer> oddNumbers = 
            numbers.stream()
                   .filter(n -> n % 2 != 0)
                   .collect(Collectors.toList());

oddNumbers.stream().forEach(System.out::println);
```

</td>
</tr>
</table>

## Filter strings by first letter

<table>
<tr>
<th>C# LINQ</th>
<th>Java Streams</th>
</tr>
<tr>
<td>

```csharp
List<string> words = new List<string> 
{
    "apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lemon"
};

var targetLetter = 'c';

var filteredWords = words.Where(word => word.StartsWith(
    targetLetter.ToString(), StringComparison.OrdinalIgnoreCase
));

foreach (var word in filteredWords)
{
    Console.WriteLine(word);
}
```

</td>
<td>

```java
List<String> words = new List<String> 
{
    "apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lemon"
};

char targetLetter = 'c';

List<String> filteredWords = 
            words.stream()
                .filter(s -> s.startsWith(targetLetter))
                .collect(Collectors.toList());

filteredWords.stream().forEach(System.out::println);
```

</td>
</tr>
</table>

## Filter strings by last letter

<table>
<tr>
<th>C# LINQ</th>
<th>Java Streams</th>
</tr>
<tr>
<td>

```csharp
List<string> words = new List<string> 
{
    "apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lemon"
};

var targetLetter = 'e';

var filteredWords = words.Where(word => word.EndsWith(
    targetLetter.ToString(), StringComparison.OrdinalIgnoreCase
));

foreach (var word in filteredWords)
{
    Console.WriteLine(word);
}
```

</td>
<td>

```java
List<String> words = new List<String> 
{
    "apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lemon"
};

char targetLetter = 'e';

List<String> filteredWords = 
            words.stream()
                .filter(s -> s.endsWith(targetLetter))
                .collect(Collectors.toList());

filteredWords.stream().forEach(System.out::println);
```

</td>
</tr>
</table>

## Filter strings by substring

<table>
<tr>
<th>C# LINQ</th>
<th>Java Streams</th>
</tr>
<tr>
<td>

```csharp
List<string> words = new List<string> 
{
    "apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lemon"
};

var substring = "an";

var filteredWords = words.Where(word => word.Contains(
    substring, StringComparison.OrdinalIgnoreCase
));

foreach (var word in filteredWords)
{
    Console.WriteLine(word);
}
```

</td>
<td>

```java
List<String> words = new List<String> 
{
    "apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lemon"
};

string substring = "an";

List<String> filteredWords = 
            words.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());

filteredWords.stream().forEach(System.out::println);
```

</td>
</tr>
</table>