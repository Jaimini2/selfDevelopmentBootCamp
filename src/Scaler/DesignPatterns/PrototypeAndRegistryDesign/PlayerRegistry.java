package src.Scaler.DesignPatterns.PrototypeAndRegistryDesign;


import java.util.HashMap;
import java.util.Map;

public class PlayerRegistry {

    public Map<String , Player> hm = new HashMap<>();

    public void register(String key ,
                         Player std){
        hm.put(key,std);
    }

    public Player get(String key){
        return hm.get(key).clone();
    }
}
