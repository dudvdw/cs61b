package discussion;

public class testPeople {
    public static class Person {
        public String name;
        public int age;

        public Person(String name, int age) {
                this.name = name;
                this.age = age;
        }

        public void greet(Person other) {System.out.println("Hello, " + other.name);}
    }

    public static class Grandma extends Person {

        public Grandma(String name, int age) {
            super(name, age);
        }

        @Override
        public void greet(Person other) {System.out.println("Hello, young whippersnapper");}

        public void greet(Grandma other) {System.out.println("How was bingo, " + other.name + "?");}
    }

    public static void main(String[] args) {
        Person n = new Person("Neil", 12);
        Person a = new Grandma("Ada", 60);
        Grandma v = new Grandma("Vidya", 80);
//        Grandma al = new Person("Alex", 70); // Compile time error
        n.greet(a); // "Hello Ada"
        n.greet(v); // "Hello Vidya"
        v.greet(a); // "Hello, young whippersnapper"
        v.greet((Grandma) a); // "How was bingo, Ada?"
        a.greet(n); // "Hello, young whippersnapper"
        a.greet(v); // "Hello, young whippersnapper"
        ((Grandma) a).greet(v); // "How was bingo, Vidya?"
        ((Grandma) n).greet(v); // Runtime error
    }
}
