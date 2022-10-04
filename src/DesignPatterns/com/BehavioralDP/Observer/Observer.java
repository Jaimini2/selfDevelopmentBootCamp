package DesignPatterns.com.BehavioralDP.Observer;

public interface Observer
{
    //method to update the observer used by subject
    public void update();

    //attach with subject to observe,not required ,but added
    //so that the observer can query the subject to see if an update has occurred
    public void setSubject(Subject sub);
}

class TopicSubscriber implements Observer{
    private String name;

    //not required could just pass state to update method ,but also used to attach
    private Subject topic;

    public TopicSubscriber(String nm){
        this.name = nm;
    }

    @Override
    public void update() {
    String msg = (String)topic.getUpdate(this);
    if(msg == null) System.out.println(" No new msg");
    else
        System.out.println(name + " :: Consuming message ::"+msg);
    }

    @Override
    public void setSubject(Subject sub) {
    //not required added so observer can ask subject for state
        this.topic = sub;
    }
}
