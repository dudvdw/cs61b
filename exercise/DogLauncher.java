public class DogLauncher {
  public static void main(String[] args){
    Dog smallDog = new Dog(5);
    Dog largeDog = new Dog(50);

    smallDog.makeNoise();
    largeDog.makeNoise();
    // Dog bigger = Dog.maxDog(smallDog, largeDog);
    Dog bigger = smallDog.maxDog(smallDog, largeDog);
    // Dog bigger = smallDog.maxDog(largeDog);
    bigger.makeNoise();

    // System.out.println(smallDog.binomen);
    System.out.println(Dog.binomen);
  }
}