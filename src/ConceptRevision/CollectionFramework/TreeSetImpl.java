package ConceptRevision.CollectionFramework;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *TreeSet  contains only unique elements
 * Treeset cannot have null element
 * It is non synchronized
 * Treeset access and retrieval Items are quiet fast
 * It maintains ascending order
 * TreeSet can only allow those generic types that are comparable.
 * For eg , comparable interface is being implemented by  StringBuffer class
 * It is internally implemented by binary Tree , which is self - balancing tree just like Red-black tree
 * Therefore, operations such as Search, remove and add consume O(log(N))time.
 * The reason behiind this is in the self-balancing tree
 */

public class TreeSetImpl {

    static void displayTheGivenSet(Set set){
        Iterator<? extends Object> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }

    public static void main(String[] args) {
        TreeSet<Book> bookSet = new TreeSet<>();
        bookSet.add(new Book(1,"Game Of Thrones","R.R.Martin"));
        bookSet.add(new Book(2,"Harry Potter 1","Joseph Fanbuleh"));
        bookSet.add(new Book(3,"House of Dragons","Nick Jonas"));
        bookSet.add(new Book(4,"Harry Potter 2 ","Noah Lyles"));
        bookSet.add(new Book(5,"Harry Potter and the Goblet of Fire","Nate Diaz"));
        bookSet.add(new Book(6,"Harry Potter and the Half Bloody Prince","Henry Cavill"));

        displayTheGivenSet(bookSet);


    }
}
