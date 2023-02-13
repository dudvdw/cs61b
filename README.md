# CS 61B note

## Resource
[sp21 datastructure](https://sp21.datastructur.es/)
[sp21 datastructure resources](https://sp21.datastructur.es/resources.html)

## Chapter 1 Introdution to Java

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

"extends" in this context has a different meaning than in the polymorphism context.

When we say that the Dog class extends the Animal class, we are saying that Dogs can do anything that animals can do and more! We are giving Dog the abilities of an animal. When we say that K extends Comparable, we are simply stating a fact: 
We aren't giving K the abilities of a Comparable, we are just saying that K must be Comparable. 
This different use of extends is called type upper bounding. 

Confusing? That's okay, it is confusing. Just remember, in the context of inheritance, the extends keyword is active in giving the subclass the abilities of the superclass. You can think of it as a fairy Godmother: she sees your needs and helps you out with some of her fairy magic. On the other hand, in the context of generics, extends simply states a fact: You must be a subclass of whatever you're extending. When used with generics (like in generic method headers), extends imposes a constraint rather than grants new abilities. It's akin to a fortune teller, who just tells you something without doing much about it.


## Chapter 7 Packages and Access Control
**Private Only** code from the given class can access private members. It is truly private from everything else, as subclasses, packages, and other external classes cannot access private members. TL;DR: only the class needs this piece of code

**Package Private** This is the default access given to Java members if there is no explicit modifier written. Package private entails that classes that belong in the same package can access, but not subclasses! Why is this useful? Usually, packages are handled and modified by the same (group of) people. It is also common for people to extend classes that they didn’t initially write. The original owners of the class that’s being extended may not want certain features or members to be tampered with, if people choose to extend it — hence, package-private allows those who are familiar with the inner workings of the program to access and modify certain members, whereas it blocks those who are subclassing from doing the same. TL;DR: only classes that live in the same package can access

**Protected** Protected members are protected from the “outside” world, so classes within the same package and subclasses can access these members, but the rest of the world (e.g. classes external to the package or non-subclasses) cannot! TL;DR: subtypes might need it, but subtype clients will not

**Public** This keyword opens up the access to everyone! This is generally what clients of the package can rely on to use, and once deployed, the public members’ signatures should not change. It’s like a promise and contract to people using this public code that it will always be accessible to them. Usually if developers want to “get rid of” something that’s public, rather than removing it, they would call it “deprecated” instead.