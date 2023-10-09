# CS 61B note

## Resource
[sp21 datastructure](https://sp21.datastructur.es/)
[sp21 datastructure resources](https://sp21.datastructur.es/resources.html)

## Chapter 1 Introdution to Java

## Chapter 4 Inheritance, implements

### Static type and dynamic type

#### Static Type
The static type of a variable or expression is the type that is known at compile time. It is the declared type of the variable or expression as it appears in the source code. The static type determines which operations can be performed on the variable or expression, and it is used for compile-time type checking. The static type is resolved based on the declared type or the type inferred by the compiler.

For example:
```java
int num = 5; // Static type: int
String message = "Hello"; // Static type: String
```

#### Dynamic Type
The dynamic type of an object or variable is the actual type of the object at runtime. It is determined by the class of the object to which the variable refers. The dynamic type is resolved at runtime based on the actual object being referred to, and it determines the behavior and available methods when invoking operations on the object.

For example:
```java
Animal animal = new Dog(); // Dynamic type: Dog
animal.makeSound(); // The makeSound() method of Dog class will be invoked
```

In this example, the static type of the `animal` variable is `Animal`, but the dynamic type is `Dog`. At compile time, the compiler uses the static type to check if the `makeSound()` method exists in the `Animal` class. Then, at runtime, the JVM uses the dynamic type to determine which implementation of the `makeSound()` method to invoke.

### Casting
Casting allows our compiler to overlook cases where we are calling a method that belongs to a subclass on a variable that is statically typed to be the superclass

### Dynamic Method Selection
@Compile Time:
1. Check for valid variable assignments
2. Check for valid method calls (only considering static type and static types superclasses)

@Run Time:
1. Check for overridden methods
2. Ensure casted objects can be assigned their variables

## Chapter 5 Generics and Autoboxing
### Type upper bounds
``` java
public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map) {
    List<K> keylist = map.keys();
    K largest = map.get(0);
    for (K k: keylist) {
        if (k.compareTo(largest)) {
            largest = k;
        }
    }
    return largest;
}
```

The K extends Comparable<K> means keys must implement the comparable interface and can be compared to other K's. We need to include the <K> after Comparable because Comparable itself is a generic interface! Therefore, we must specify what kind of comparable we want. In this case, we want to compare K's with K's.

**extends** in this context has a different meaning than in the polymorphism context.

When we say that the Dog class extends the Animal class, we are saying that Dogs can do anything that animals can do and more! We are giving Dog the abilities of an animal. When we say that K extends Comparable, we are simply stating a fact: 
We aren't giving K the abilities of a Comparable, we are just saying that K must be Comparable. 
This different use of extends is called type upper bounding. 

Confusing? That's okay, it is confusing. Just remember, in the context of inheritance, the extends keyword is active in giving the subclass the abilities of the superclass. You can think of it as a fairy Godmother: she sees your needs and helps you out with some of her fairy magic. On the other hand, in the context of generics, extends simply states a fact: You must be a subclass of whatever you're extending. When used with generics (like in generic method headers), extends imposes a constraint rather than grants new abilities. It's akin to a fortune teller, who just tells you something without doing much about it.


## Chapter 7 Packages and Access Control
**Private Only** code from the given class can access private members. It is truly private from everything else, as subclasses, packages, and other external classes cannot access private members. TL;DR: only the class needs this piece of code

**Package Private** This is the default access given to Java members if there is no explicit modifier written. Package private entails that classes that belong in the same package can access, but not subclasses! Why is this useful? Usually, packages are handled and modified by the same (group of) people. It is also common for people to extend classes that they didn’t initially write. The original owners of the class that’s being extended may not want certain features or members to be tampered with, if people choose to extend it — hence, package-private allows those who are familiar with the inner workings of the program to access and modify certain members, whereas it blocks those who are subclassing from doing the same. TL;DR: only classes that live in the same package can access

**Protected** Protected members are protected from the “outside” world, so classes within the same package and subclasses can access these members, but the rest of the world (e.g. classes external to the package or non-subclasses) cannot! TL;DR: subtypes might need it, but subtype clients will not

**Public** This keyword opens up the access to everyone! This is generally what clients of the package can rely on to use, and once deployed, the public members’ signatures should not change. It’s like a promise and contract to people using this public code that it will always be accessible to them. Usually if developers want to “get rid of” something that’s public, rather than removing it, they would call it “deprecated” instead.

## Chapter 8 Efficient Programming

### Encapsulated

A module is said to be encapsulated if its implementation is completely hidden, and it can be accessed only through a documented interface.

### API

An API(Application Programming Interface) of an ADT is the list of constructors and methods and a short description of each.

API consists of syntactic and semantic specification.

* Compiler verifies that syntax is met. 
AKA, everything specified in the API is present.

* Tests help verify that semantics are correct. 
AKA everything actually works the way it should.

### Asymptotics 

1. Big O (O) notation:
   - Represents the upper bound or worst-case scenario of an algorithm's efficiency.
   - Describes the maximum growth rate of the algorithm as the input size increases.
   - Provides an estimate of the algorithm's scalability.
   - Example: If an algorithm has a time complexity of O(n^2), it means that the algorithm's runtime will not exceed a quadratic growth rate relative to the input size.

2. Omega (Ω) notation:
   - Represents the lower bound of an algorithm's efficiency.
   - Describes the minimum growth rate of the algorithm as the input size increases.
   - Provides information about the best-case scenario for an algorithm's performance.
   - Example: If an algorithm has a time complexity of Ω(n), it means that the algorithm's runtime will not be faster than a linear growth rate relative to the input size.

3. Theta (Θ) notation:
   - Represents both the upper and lower bounds of an algorithm's efficiency.
   - Describes a tight bound on the algorithm's growth rate, indicating that the algorithm's runtime is neither faster nor slower than the given growth rate.
   - Used when the best-case and worst-case scenarios have the same growth rate.
   - Example: If an algorithm has a time complexity of Θ(n), it means that the algorithm's runtime will be linear relative to the input size, regardless of the best-case or worst-case scenario.

In summary, Big O notation provides an upper bound, Omega notation provides a lower bound, and Theta notation provides a tight bound on an algorithm's efficiency. These notations help in analyzing and comparing algorithms, estimating their scalability, and understanding their performance characteristics under different scenarios.
