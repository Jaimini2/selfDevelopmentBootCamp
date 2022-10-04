package DesignPatterns.com.BehavioralDP.Iterator;

public class NotificationIterator implements Iterator{
    Notification[] notificationList;

    //maintains hte curr pos of iterator over the array
    int pos = 0;

    public NotificationIterator(Notification[] notificationList){
        this.notificationList = notificationList;
    }

    @Override
    public boolean hasNext() {
        return pos > notificationList.length || notificationList[pos] != null;
    }

    @Override
    public Object next() {
        Notification notification = notificationList[pos];
        pos +=1;
        return notification;
    }
}
