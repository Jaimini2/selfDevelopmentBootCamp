package DesignPatterns.com.BehavioralDP.Iterator;

public interface Collection {
    public NotificationIterator createIterator();
}

class NotificationCollection implements Collection{
    static final int MAX_ITEMS = 6;
    int numOfItems = 0;
    Notification [] notificationList;

    public NotificationCollection(){
        notificationList = new Notification[MAX_ITEMS];

        addItem("Notification 1");
        addItem("Notification 2");

        addItem("Notification 3");

    }

    private void addItem(String s) {
        Notification notification = new Notification(s);
        if(numOfItems > MAX_ITEMS){
            System.err.println("Full");
        }else{
            notificationList[numOfItems] = notification;
            numOfItems = numOfItems +1;
        }
    }

    @Override
    public NotificationIterator createIterator() {
        return new  NotificationIterator(notificationList);
    }
}