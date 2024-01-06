# SortedLinkedList Library

This library provides a `SortedLinkedList` class, a linked list that keeps its values sorted. It can hold any type that extends `Comparable<E>`, but it is specifically designed and tested for `String` and `Integer` values.


## Features

- Maintains elements in sorted order according to their natural ordering.
- Allows duplicate elements but does not permit null elements.
- Provides a wide range of operations similar to those in `List`, `LinkedList`, `Collections`, etc.

## Usage

### For Integer Values

```java
SortedLinkedList<Integer> intList = new SortedLinkedList<>();
intList.add(3);
intList.add(1);
intList.add(2);
System.out.println(intList.toString());  // Prints: [1, 2, 3]
```

### For String Values

```java
SortedLinkedList<String> stringList = new SortedLinkedList<>();
stringList.add("banana");
stringList.add("apple");
stringList.add("cherry");
System.out.println(stringList.toString());  // Prints: [apple, banana, cherry]
```

### Building the Project
This project uses Gradle 8.4 for building. You can build the project using the following command:
`./gradlew build`

This will compile the source code, run the tests, and generate a JAR file in the build/libs directory.

### Contributing

Contributions are welcome! Please feel free to submit a Pull Request.