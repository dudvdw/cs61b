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


