package src.Scaler.Generics;

public class Pair <V, S>{

    V v;
    S s;

   public Pair(){

    }
    Pair(V v, S s){
        this.v = v;
        this.s = s;
    }

    public V getV() {
        return v;
    }

    public S getS() {
        return s;
    }
}
