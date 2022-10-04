package ConceptRevision.DSA.Hashtable;

import ConceptRevision.DSA.Lists.ArrayList.Main;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashTable {
    private LinkedList<StoredEmployee>[] linkedHashTable;

    public ChainedHashTable() {
        linkedHashTable = new LinkedList[10];
        for (int i = 0; i < linkedHashTable.length; i++) {
            linkedHashTable[i] = new LinkedList<StoredEmployee>();
        }
    }

    private int hashKey(String key) {
        return Math.abs(key.hashCode() % linkedHashTable.length);
        //return key.length() % linkedHashTable.length;
    }

    public void put(String key, Employee employee) {
        int hasedkey = hashKey(key);
        linkedHashTable[hasedkey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> itr = linkedHashTable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while (itr.hasNext()) {
            employee = itr.next();
            if (employee.key.equals(key)) {
                return employee.employee;
            }
        }
        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);

        ListIterator<StoredEmployee> itr = linkedHashTable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int counter =-1;
        while (itr.hasNext()) {
            employee = itr.next();
            counter++;
            if (employee.key.equals(key)) {
                break;
            }
        }
        if (employee == null || !employee.key.equals(key)){
            return null;
        }else{
            linkedHashTable[hashedKey].remove(counter);
            return employee.employee;
        }
    }

    public void printHashTable(){
            for (int i =0; i< linkedHashTable.length;i++){
                if (linkedHashTable[i].isEmpty()){
                    System.out.println("Position "+i+ " : is empty");
                }
                else{
                    System.out.println("Position : "+i+" :");
                    ListIterator<StoredEmployee> itr = linkedHashTable[i].listIterator();
                    while (itr.hasNext()){
                        System.out.print(itr.next().employee);
                        System.out.print("---->");
                    }
                    System.out.println("null");
                }
            }
    }
}
