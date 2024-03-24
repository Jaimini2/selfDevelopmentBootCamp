package  src.ConceptRevision.DSA.Hashtable;

public class ChainedHashMain {
    public static void main(String[] args) {
        Employee JohnJones = new Employee(1,"John","ALgebra");
        Employee JonDoe = new Employee(2,"Jon","Science");
        Employee marrySmith = new Employee(3,"Marry","Geometry");
        Employee MikeWilson = new Employee(4,"Mike","Data Structures");

        ChainedHashTable ct = new ChainedHashTable();
        ct.put("John",JohnJones);
        ct.put("Jon",JonDoe);
        ct.put("Marry",marrySmith);
        ct.put("Mike",MikeWilson);

        ct.printHashTable();

        System.out.println("Retreive Key Smith : " + ct.get("Marry"));

//        ct.remove("Jon");
//        ct.remove("John");

        System.out.println("Hashtable after removal of two items ............");
        System.out.println();
        ct.printHashTable();
    }
}
