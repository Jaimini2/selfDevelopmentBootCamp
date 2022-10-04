package DesignPatterns.com.BehavioralDP.Mediator;

abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator med,String name){
        this.mediator = med;
        this.name = name;
    }

    public abstract void send(String name);
    public abstract void receive(String msg);
}

class UserImpl extends User{
    public UserImpl(ChatMediator med,String name){
        super(med,name);
    }

    @Override
    public void send(String msg){
        System.out.println(this.name+ ": sending message = "+msg);
        mediator.sendMessage(msg,this);
    }

    @Override
    public void receive(String msg){
        System.out.println(this.name+ ": Received message: "+msg);
    }
}
