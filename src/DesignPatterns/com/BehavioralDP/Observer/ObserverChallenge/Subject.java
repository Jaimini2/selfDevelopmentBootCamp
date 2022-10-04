package DesignPatterns.com.BehavioralDP.Observer.ObserverChallenge;

import java.util.ArrayList;
import java.util.Iterator;

public interface Subject {

//implemented by cricket data to communicate with  observers
    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObservers();
}

class CricketData implements Subject{
    private int runs;
    int wickets;
    float over;

    ArrayList<Observer> observerList;

    public CricketData(){
        observerList = new ArrayList<Observer>();
    }


    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }

    @Override
    public void notifyObservers() {
        for (Iterator<Observer> iter = observerList.iterator(); iter.hasNext(); ) {
            Observer o = iter.next();
            o.update(runs,wickets,over);
        }
        ;
    }

    //get latest runs from stadium
    private int getLatestRuns(){
        return 90;
    }

    //get latest wickets from stadium
    private int getLatestWickets(){
        return 2;
    }

    //get latest overs from stadium
    private float getLatestOvers(){
        return(float)10.2;
    }

    //this method is used to update displays when data changes
    public void dataChanged(){
        //get latest data
        runs = getLatestRuns();
        wickets = getLatestWickets();
        over = getLatestOvers();

        notifyObservers();
    }
}