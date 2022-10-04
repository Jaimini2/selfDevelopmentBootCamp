package DesignPatterns.com.BehavioralDP.Observer.ObserverChallenge;

public class Client {
    public static void main(String[] args) {
        //create objects for testing
        AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();

        //pass the displays to CricketData
        CricketData cricketData = new CricketData();

        //register display elements
        cricketData.registerObserver(averageScoreDisplay);
        cricketData.registerObserver(currentScoreDisplay);

        //in real life you will have some logic to call this function when data changes
        cricketData.dataChanged();

        //remove an observer
        cricketData.unregisterObserver(averageScoreDisplay);

        //now only current score display gets the notification
        cricketData.dataChanged();
    }
}
