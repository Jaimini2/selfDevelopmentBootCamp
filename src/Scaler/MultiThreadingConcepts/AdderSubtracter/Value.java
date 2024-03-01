package src.Scaler.MultiThreadingConcepts.AdderSubtracter;

public class Value {
    int val ;

    public Value(int x){
        this.val = x;
    }

    public synchronized  void incrementBy(){
        this.val += 1;
    }

    public synchronized void decrementBy(){
        this.val-=1;
    }
}
