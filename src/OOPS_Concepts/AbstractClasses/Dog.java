package src.OOPS_Concepts.AbstractClasses;

import src.OOPS_Concepts.AbstractClasses.Animal;

public class Dog extends Animal {
    public static int something = 5;

   public Dog() {
        super("Dog");
        something+=1;
    }

   public void move(){
        System.out.println("Dog is running");
    }

}