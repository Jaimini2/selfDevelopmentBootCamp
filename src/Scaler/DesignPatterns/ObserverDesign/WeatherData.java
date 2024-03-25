package src.Scaler.DesignPatterns.ObserverDesign;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
    private List<Observer> observers;

    private float temperature;

    private float humidity;

    private float pressure;

    public WeatherData(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {

        observers.add(o);
        System.out.println(" Observer registered : -----");
    }

    @Override
    public void removeObserver(Observer o) {
            observers.remove(o);
        System.out.println("Removed observer ..........");
    }


    @Override
    public void notifyObservers() {

        for (Observer o : observers){
            o.update(temperature,humidity,pressure);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

}
