package ConceptRevision.CollectionFramework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * A Map contains values on the basis of key ,
 * i.e. key and Value pair.
 *Each Key and Value pair is known as Entry.
 * A Map contains Unique keys
 * There are 2 interfaces for implementing Map in java,
 * Map and SortedMap , and 3 classes
 * HashMap , LinkedHashMap and TreeMap.
 *
 */
public class MapImpl {

    public static void traverseThroughMap(Map map){
        Set set = map.entrySet();
        Iterator it = set.iterator();

        while (it.hasNext()){
            //converting to map.Entry so that we can get key and value separately
            Entry entry = (Entry)it.next();
            System.out.println(entry.getKey()+ " " +entry.getValue());
        }
    }

    public static void traverseThroughMap2(Map map){
       for (Object maps : map.entrySet()){
           System.out.println(((Map.Entry)maps).getKey() + " " + ((Map.Entry)maps).getValue());
       }
    }
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(55,"Dad");
        map.put(1,"Amit");
        map.put(2,"Avi");
        map.put(3,"Jai");
        map.put(4,"Amo");

        Map map1 = new HashMap<Book,Integer>();
        map1.put(new Book(1,"Game Of Thrones","R.R.Martin"),1);
        map1.put(new Book(2,"Harry Potter 1","Joseph Fanbuleh"),2);
        map1.put(new Book(3,"House of Dragons","Nick Jonas"),3);
        map1.put(new Book(4,"Harry Potter 2 ","Noah Lyles"),4);
        map1.put(new Book(5,"Harry Potter and the Goblet of Fire","Nate Diaz"),5);
        map1.put(new Book(6,"Harry Potter and the Half Bloody Prince","Henry Cavill"),6);
        //this will cause violation of rule as we cannot enter duplicate keys in hashmap ,
        //that is why we need to override equals and hashcode method
        map1.put(new Book(6,"Harry Potter and the Half Bloody Prince","Henry Cavill"),7);

        //Traversing map
        //Converting map to set so that we can traverse
        traverseThroughMap(map);
        System.out.println("*****************Traversing throught the Book Object************");
        traverseThroughMap2(map1);
    }
}
