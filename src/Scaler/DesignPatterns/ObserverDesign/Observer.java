package src.Scaler.DesignPatterns.ObserverDesign;

public interface Observer {

     void update(float temp,float humitidty,float pressure);

     /**
      * Anybody who is observer must have the above update method
      */
}
