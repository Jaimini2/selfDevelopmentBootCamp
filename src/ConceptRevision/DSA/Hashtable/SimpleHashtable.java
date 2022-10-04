package ConceptRevision.DSA.Hashtable;

public class SimpleHashtable {
    private StoredEmployee[] hashtable ;

    SimpleHashtable(int capacity){
        hashtable = new StoredEmployee[capacity];
    }

    private  int hashKey(String key){
        return key.length()%hashtable.length;
    }

    public  void put(String key,Employee employee){
        int hashedKey = hashKey(key);
        if(occupied(hashedKey)){
            int stopIndex = hashedKey;
            if(hashedKey == hashtable.length-1){
                hashedKey = 0;
            }else{
                hashedKey++;
            }
            while (occupied(hashedKey) && hashedKey != stopIndex){
                hashedKey = (hashedKey + 1) %hashtable.length;
            }
        }

        if(occupied(hashedKey)){
            System.out.println("Sorry , already an employee at that position ");
        }else{
            hashtable[hashedKey] = new StoredEmployee(key,employee);
        }
    }

    public Employee get(String key){
        int hashedKey = findKey(key);
        if (hashedKey == -1){
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    private boolean occupied(int index){
        return hashtable[index] != null;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null &&
                hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }
        int stopIndex = hashedKey;
        if(hashedKey == hashtable.length-1){
            hashedKey = 0;
        }else{
            hashedKey++;
        }
        while (hashedKey != stopIndex &&
                hashtable[hashedKey] != null &&
                !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }
        if(hashtable[hashedKey]!= null &&
                hashtable[hashedKey].key.equals(key) ){
            return hashedKey;
        }else{
            return -1;
        }
    }

    public Employee remove(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        }
        Employee emp = hashtable[hashedKey].employee;

        hashtable[hashedKey] = null;

        //Rehashing over here to avoid the null value when we search for the particular employee which might have been
//        added later in the above hashedKey position
        StoredEmployee[] oldHashtable = hashtable;
        hashtable = new StoredEmployee[oldHashtable.length];
        for (int i = 0; i < oldHashtable.length;i++){
            if (oldHashtable[i] != null){
               put(oldHashtable[i].key,oldHashtable[i].employee);
            }
        }

        return emp;
    }


    public void printHashTable(){
        for (int i =0 ; i< hashtable.length;i++){
            if(hashtable[i] == null){
                System.out.println("empty");
            }else{
                System.out.println("Postion "+i+ ":" +hashtable[i].employee);
            }

        }
    }
}
