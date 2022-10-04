package DesignPatterns.com.BehavioralDP.Iterator;

public class IteratorClient {
    public static void main(String[] args) {
        NotificationCollection nc = new NotificationCollection();
        NotificationBar nb = new NotificationBar(nc);
        nb.printNotifications();
    }
}
