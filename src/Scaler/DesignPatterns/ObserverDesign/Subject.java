package src.Scaler.DesignPatterns.ObserverDesign;

public interface Subject {

    /**
     * whoever wants to be provider needs to make sure they are implementingb these 3 metyhods
     *
     * @param o
     */


    public void registerObserver(Observer o);

    void removeObserver(Observer o);

    public void notifyObservers();


}
