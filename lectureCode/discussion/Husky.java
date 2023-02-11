package discussion;

public class Husky extends Dog {
    String color;

    public Husky() {
        super();
        this.color = "white";
    }

    public void bark() {
        for (int i = 0; i < weight % 10; i++) {
            System.out.println("bark");
        }
    }

    public void updateAge(int age) {
        this.age = age;
    }
}
