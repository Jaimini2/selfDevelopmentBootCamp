package ConceptRevision.OOPsCOncepts;

class Animal {

    Animal(){
        System.out.println("Animal is Created ");
    }
    void eat(){
        System.out.println("Animal is eating ");
    }
}

class Dog extends Animal{
    Dog(){
        super();
        System.out.println("Dog is created ");

    }
    void eat(){
        super.eat();
        System.out.println("Dog is eating ");
    }
}
public class SuperTest {
    public static void main(String[] args) {
        Dog d = new Dog();

        d.eat();
    }
}
