package ConceptRevision.DSA.Queues;

public class QueueMain {

    public static void displayQueueDetails(ArrayQueue queue) {
        System.out.println("==============================Printing Queue===================");
        queue.printQueue();
        System.out.println("Size of the queue " + queue.size());

        System.out.println("==========================Removing Elements from the Queue===================");
        queue.remove();
        queue.remove();
        queue.remove();
       /* queue.remove();*/


        queue.add(new Employee(8,"Jacksy","Dacksy"));


        queue.printQueue();
        System.out.println("Peeking the first employee of the queue "+queue.peek());
        System.out.println("Size of the queue " + queue.size());
      //  System.out.println("Length of Queue "+queue.empQueue.length);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Jai", "Science");
        Employee emp2 = new Employee(2, "Bhai", "Physics");
        Employee emp3 = new Employee(3, "Mathews", "Law");
        Employee emp4 = new Employee(4, "Raja", "Chemistry");
        Employee emp5 = new Employee(5, "Dhamma", "Maths");
        Employee emp6 = new Employee(6, "Rohan", "Algebra");
        Employee emp7 = new Employee(7, "Pranay", "Don");

        ArrayQueue queue = new ArrayQueue(4);
        queue.add(emp1);
        queue.add(emp2);
        queue.add(emp3);
        /*queue.add(emp4);
        queue.add(emp5);
        queue.add(emp6);
        queue.add(emp7);*/

        displayQueueDetails(queue);

    }
}
