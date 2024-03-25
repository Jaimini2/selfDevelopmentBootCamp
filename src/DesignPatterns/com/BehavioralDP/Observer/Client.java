package src.DesignPatterns.com.BehavioralDP.Observer;

public class Client {
    public static void main(String[] args) {
        //create Subject
       MyTopic topic  = new MyTopic();

        //create observers
        Observer o1 = new TopicSubscriber("obj1");
        Observer o2 = new TopicSubscriber("obj2");
        Observer o3 = new TopicSubscriber("obj3");

        //register  observers to the subject ,could have added the registration as a part of the observer constructor passing the subject
        topic.register(o1);
        topic.register(o2);
        topic.register(o3);

        //attach observers to the subject (not required , coud have passed in subject state to update method)
        o1.setSubject(topic);
        o2.setSubject(topic);
        o3.setSubject(topic);
        //Check if any update is available, not required
        o1.update();

        //now send message to subject, trigger notifyAll
        topic.postMessage("New Message");
    }
}
