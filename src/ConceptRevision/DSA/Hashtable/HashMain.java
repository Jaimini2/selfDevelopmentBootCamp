package ConceptRevision.DSA.Hashtable;



public class HashMain {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Jai", "Science");
       Employee emp2 = new Employee(2, "Bhai", "Physics");
        Employee emp3 = new Employee(3, "Mathews", "Law");
        Employee emp4 = new Employee(4, "Raja", "Chemistry");
       Employee emp5 = new Employee(5, "Dhamma", "Maths");
        Employee emp6 = new Employee(6, "Rohan", "Algebra");
        Employee emp7 = new Employee(7, "Pranay", "Don");
        Employee emp8 = new Employee(6, "Sujay", "Geometry");

        SimpleHashtable ht = new SimpleHashtable(5);
        ht.put("Jai",emp1);
        ht.put("Bhai",emp2);
        ht.put("Mathews",emp3);
        ht.put("Raja",emp4);
        ht.put("Dhamma",emp5);
        ht.put("Rohan",emp6);
        ht.put("Pranay",emp7);

        ht.printHashTable();

        System.out.println(ht.get("Raja"));

        ht.remove("Dhamma");
        ht.remove("Jai");

        System.out.println("Printing HashTable after Removal ...............");
        ht.printHashTable();

        System.out.println("------------------------------------------------------");
        System.out.println();
        System.out.println();
        ht.put("Sujay",emp8);
        ht.put("Pranay",emp7);

        ht.printHashTable();

    }
}
