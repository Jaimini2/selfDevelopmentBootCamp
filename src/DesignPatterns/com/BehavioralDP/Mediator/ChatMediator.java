package DesignPatterns.com.BehavioralDP.Mediator;

import java.util.ArrayList;
import java.util.List;

public interface ChatMediator {
    public void sendMessage(String msg , User user);
    void addUser(User user);
}

class ChatMediatorImpl implements ChatMediator{
    private List<User> users;

    public  ChatMediatorImpl(){
    this.users = new ArrayList<>();

    }

    @Override
    public void sendMessage(String msg, User user) {
        for(User u : users){
            if(u != user){
                u.receive(msg);
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}
