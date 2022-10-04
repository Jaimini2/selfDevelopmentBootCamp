package ConceptRevision.CollectionFramework;

import java.util.*;

/**
 * Hashset represents a set of unique objects.
 * It can have null value
 * It is the best approach for search algorithms
 * It does not maintain the insertion order
 * Elements are inserted on the basis of their hashcode
 * The initial default capacity is 16 and load factor is 0.75
 */
public class HashSetImpl {

   public static void displayTheGivenSet(Set set){
       System.out.println("************Displaying the Set Data**************************");
            Iterator<? extends Object>it = set.iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }

    }

    public static void main(String[] args) {
        Set<String> hashset = new HashSet<>();
        hashset.add("Jaimini");
        hashset.add("Amoli");
        hashset.add("Naruto");
        hashset.add("Mummy");
        hashset.add("Papa");

            displayTheGivenSet(hashset);

        List<String> arlist = new ArrayList<>(hashset);
        ArrayListImpl.displayTheGivenList(arlist);


    }
}
