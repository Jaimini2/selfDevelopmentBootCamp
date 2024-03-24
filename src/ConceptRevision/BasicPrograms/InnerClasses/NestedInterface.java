package  src.ConceptRevision.BasicPrograms.InnerClasses;

public interface NestedInterface {
    void display();

    interface Message{
        void display2();
    }
}

class NestedInterfaceDemo implements NestedInterface.Message{

    @Override
    public void display2() {
        System.out.println("This is Nested Interface");
    }

    public static void main(String[] args) {
        NestedInterface.Message m = new NestedInterfaceDemo();
        m.display2();
    }
}
