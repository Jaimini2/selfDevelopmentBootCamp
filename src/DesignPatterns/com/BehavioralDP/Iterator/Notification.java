package DesignPatterns.com.BehavioralDP.Iterator;

public class Notification {
    //store notification messages
    String notification;

    public Notification(String notification){
        this.notification = notification;
    }

    public String getNotification(){
        return notification;
    }
}
