package DesignPatterns.com.BehavioralDP.Observer;

import java.util.ArrayList;
import java.util.List;


public interface Subject {

    //method to register an observer
    public void register(Observer observer);

    //method to unregister an observer
    public void unregister(Observer observer);

    //method to notify observers of changes
    public void notifyObservers();

    //method to get updates from subject , not required but added so observers can query
    public Object getUpdate(Observer obj);
}

class MyTopic implements Subject{
    private List<Observer> observers;
    private String message;
    private boolean changed;

    public MyTopic(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if(observer ==null)throw new NullPointerException("Null Observer");
        if(!observers.contains(observer))observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
    observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        List<DesignPatterns.com.BehavioralDP.Observer.Observer> localObserver = null;

        if(!changed) return;

        localObserver = new ArrayList(this.observers);
        this.changed = false;
        for(DesignPatterns.com.BehavioralDP.Observer.Observer obj : localObserver){
            obj.update();
        }

    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    //method to post the message to the topic , change state(trigger notifications)
    public void postMessage(String msg){
        System.out.println("Message posted to topic : " + msg);
        this.message = msg;
        changed = true;
        notifyObservers();
    }
}