package DesignPatterns.com.BehavioralDP.Observer.ObserverChallenge;
//this interface is implemented by all the classes that
//are to be updated whenever there is an update from Cricket data
public interface Observer {
    public void update(int runs,int wickets,float overs);
}

class AverageScoreDisplay implements  Observer{
    private float runRate;
    private int predictedScore;

    @Override
    public void update(int runs, int wickets, float overs) {
        this.runRate = (float)runs/overs;
        this.predictedScore = (int)(this.runRate * 50);
        display();

    }

    private void display() {
        System.out.println("Average score display : \n" + "Run Rate :" + runRate +
                "\nPredictedScore: " + predictedScore);
    }

}

class CurrentScoreDisplay implements Observer{
    private int runs,wickets;
    private float overs;

    @Override
    public void update(int runs, int wickets, float overs) {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        display();
    }

    private void display() {
        System.out.println("Current score display : \n" + "Run  :" + runs +
                "\nwickets: " + wickets + "\n Overs : "+overs);
    }
}