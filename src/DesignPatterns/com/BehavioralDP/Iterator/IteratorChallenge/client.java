package DesignPatterns.com.BehavioralDP.Iterator.IteratorChallenge;

public class client {

    public static void print(IteratorInterface iterator){
        while (!iterator.isDone()){
            System.out.println(iterator.next());
        }
    }
    public static void main(String[] args) {
        System.out.println("****Iterator Demo Pattern *******");
        SubjectInterface sc_subject = new Science();
        SubjectInterface arts_subject = new Arts();

        IteratorInterface sc_iterator = sc_subject.createIterator();
        IteratorInterface arts_iterator = arts_subject.createIterator();

        System.out.println(" Science Subjects");
        print(sc_iterator);

        System.out.println("Arts subjects");
        print(arts_iterator);
    }
}
