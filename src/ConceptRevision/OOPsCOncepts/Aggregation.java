package ConceptRevision.OOPsCOncepts;

public class Aggregation {

    public static void main(String[] args) {
        Employee e1 = new Employee(12,"Jaimini",new Address("Amarkunj","Virar"));
        Employee e2 = new Employee(13,"Amoli",new Address("Ranphool","Aurangabad"));

        e1.display();
        e2.display();
    }

}

class Employee {
    int id;
    String name;
    //address is a class
    //Here Employee has an entity refference address, so relationship is Employee HAS- A address.
    Address address;

    Employee(int id,String name, Address add){
        this.id = id;
        this.name = name;
        this.address = add;
    }

    public void display(){
        System.out.println("EMployee name is "+this.name + " and Id is "+id);
        System.out.println("Employee address is " + address.displayAddress());

    }
}

class Address {
    String addr1 ;
    String addr2;

    Address(String addr1, String addr2){
        this.addr1 = addr1;
        this.addr2 = addr2;
    }
    public String displayAddress(){
        return " House is "+addr1 + " City is "+addr2;
    }
}