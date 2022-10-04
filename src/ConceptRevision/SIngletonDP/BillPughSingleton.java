package ConceptRevision.SIngletonDP;


/*Here when the Singleton class is loaded at that time SingletonHelper class is
* not loaded into memory , it is only loaded when the getInstance method is called*/
public class BillPughSingleton {
    private BillPughSingleton(){

    }

    private static class SingletonHelper {
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public static  BillPughSingleton getInstance(){
        return SingletonHelper.instance;
    }
}
