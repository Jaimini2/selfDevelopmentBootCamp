package src.Scaler.DesignPatterns.ObserverDesign;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData wd = new WeatherData();

        CurrentConditionsDisplay cd = new CurrentConditionsDisplay(wd);
        ForeCastDisplay fd = new ForeCastDisplay(wd);
        StatisticsDisplay st = new StatisticsDisplay(wd);

        //----------------------------------------------
        wd.setMeasurements(80, 65, 30.4f);
        wd.setMeasurements(82, 70, 29.2f);
        wd.setMeasurements(78, 90, 29.2f);

        cd.deRegister();
        wd.setMeasurements(62, 90, 28.1f);
        cd.registerTOGetUpdates();
        wd.setMeasurements(99, 90, 28.1f);
    }
}
