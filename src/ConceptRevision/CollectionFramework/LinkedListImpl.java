package src.ConceptRevision.CollectionFramework;

import java.util.LinkedList;

/**
 * Linked list can contain duplicate elements
 * Linked list maintains inserstion order
 * Linked list class is non synchronized
 * In linked list manipulation is fast because no shifting of elements is required
 * In Java, linked list can be used as a List,stack or Queue
 */
public class LinkedListImpl {
    public static void main(String[] args) {
        LinkedList<String> topics = new LinkedList<>();
        topics.add("Collections");
        topics.add("Spring framework");
        topics.add("Rest Services");
        topics.add("SOAP servies");
        topics.add("MicroServices");
        topics.add("DataStructures and Algorithms");

        //adding an element at the specific index
        topics.add(2,"MultiThreading");

        ArrayListImpl.displayTheGivenList(topics);


    }

}
