# Projection Examples

## Get Ids from Person class

<table>
<tr>
<th>C# LINQ</th>
<th>Java Streams</th>
</tr>
<tr>
<td>

```csharp
var personIds = people.Select(person => person.Id).ToList();

foreach (string id in personIds)
{
    Console.WriteLine(id);
}
```

</td>
<td>

```java
List<String> personIds = 
    people.stream()
        .map(Person::getId)
        .collect(Collectors.toList());

personIds.stream().forEach(System.out::println);
```

</td>
</tr>
</table>

## Get Names from Person class

<table>
<tr>
<th>C# LINQ</th>
<th>Java Streams</th>
</tr>
<tr>
<td>

```csharp
var personNames = people.Select(person => person.Name).ToList();

foreach (string name in personNames)
{
    Console.WriteLine(name);
}
```

</td>
<td>

```java
List<String> personNames = 
    people.stream()
        .map(Person::getName)
        .collect(Collectors.toList());

personNames.stream().forEach(System.out::println);
```

</td>
</tr>
</table>

## Get Ages from Person class

<table>
<tr>
<th>C# LINQ</th>
<th>Java Streams</th>
</tr>
<tr>
<td>

```csharp
var personIds = people.Select(person => person.Age).ToList();

foreach (int age in personIds)
{
    Console.WriteLine(id);
}
```

</td>
<td>

```java
List<Integer> personAges = 
    people.stream()
        .map(Person::getAge)
        .collect(Collectors.toList());

personIds.stream().forEach(System.out::println);
```

</td>
</tr>
</table>