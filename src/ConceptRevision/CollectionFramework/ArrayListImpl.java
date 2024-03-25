package src.ConceptRevision.CollectionFramework;

import java.util.*;

public class ArrayListImpl {

    public static void displayTheGivenList(List list){

        if(list instanceof ArrayList){
            System.out.println("Displaying Arraylist of given Type  : " +list.getClass());
            Iterator<? extends Object> it = list.iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }
        }
        if(list instanceof LinkedList){
            System.out.println("Displaying LinkedList of Given Type : "+list.getClass());
            Iterator<? extends Object> it = list.iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }
        }

    }
    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<>(8);

        a1.add("Jaimini");
        a1.add("Amo");
        a1.add("Naruto");
        a1.add("Mummy");
        a1.add("Papa");

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("JackFruit");
        fruits.add("Kiwi");
        fruits.add("Orange");
        //Normal Display of ArrayList
        System.out.println(a1);

        //Display ArrayList through Iterator
        Iterator<String> it = a1.iterator();
        while (it.hasNext()){
            //printing the element and move to next
            System.out.println(it.next());
        }
        System.out.println();
        System.out.println("*******************Displaying Fruits ***************************");
        //displaying arraylist using ForEach Loop
        for (String fruit:fruits) {
            System.out.println(fruit);
        }

        System.out.println("");
        System.out.println("                                       SORTING THE LIST");
        System.out.println();
        Collections.sort(a1);
        Collections.sort(fruits);
        System.out.println("***************Displaying List with the Generic Method Created after Sorting the Lists ************");
        displayTheGivenList(fruits);
        System.out.println();

        displayTheGivenList(a1);

        System.out.println("**************************Traversing List through List Iterator ********************");

        ListIterator<String> lt = fruits.listIterator(fruits.size());
        while (lt.hasPrevious()){
            System.out.println(lt.previous());
        }

        System.out.println("***************************Traversing through ForEach () method**************************");

        fruits.forEach(a->{
            System.out.println(a);
        });

        System.out.println("*********************Traversing through ForEachRemaining *************************");
        Iterator it1 = fruits.iterator();
        it1.forEachRemaining(a -> {
            System.out.println(a);
        });

        System.out.println(" " +
                "");
        it1 = a1.listIterator();
        it1.forEachRemaining(b ->{
            System.out.println(b);
        });

        Collections.sort(a1,Collections.reverseOrder());

        Set<String> fruitset = new HashSet<>(fruits);
        HashSetImpl.displayTheGivenSet(fruitset);

    }
}
