package ConceptRevision.SIngletonDP;
//Singleton best approach , Bill-pugh approach
public class SingleTon {

    private SingleTon(){

    }

    private static class SingleTonHelper{

        private static final SingleTon Singleton_instance = new SingleTon();
    }

    public static SingleTon getInstance(){
        return SingleTonHelper.Singleton_instance;
    }
}
