package src.OOPS_Concepts.AbstractClasses;

public class Client{

    public static void main(String[] args) {
       Animal x = new Dog();

      // BullDog bd = new BullDog();

        x.move();

        System.out.println(Dog.something);
        System.out.println(BullDog.something);
    }
}