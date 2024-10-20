package DesignPatterns.com.BehavioralDP.Mediator;

public class Client {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new UserImpl(mediator, "Jason");
        User user2 = new UserImpl(mediator, "Jaimini");
        User user3 = new UserImpl(mediator, "Amoli");
        User user4 = new UserImpl(mediator, "Naruto");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hi All");


    }
}
