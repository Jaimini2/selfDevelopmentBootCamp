package src.Scaler.DesignPatterns.ObserverDesign;

public class CurrentConditionsDisplay implements Observer,DisplayInterface{

    private float temperature;

    private float humidity;

    private WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData wd){
        this.weatherData = wd;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humitidty, float pressure) {
            this.temperature = temp;
            this.humidity = humitidty;
            display();
    }

    public void registerTOGetUpdates(){
        this.weatherData.removeObserver(this);
    }

    public void deRegister(){
        this.weatherData.removeObserver(this);
    }
}
