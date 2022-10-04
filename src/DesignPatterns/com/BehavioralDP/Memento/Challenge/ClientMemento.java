package DesignPatterns.com.BehavioralDP.Memento.Challenge;

public class ClientMemento {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("State #1");
        originator.setState("State #2");

        careTaker.add(originator.saveStatetoMemento());

        originator.setState("State #3");

        careTaker.add(originator.saveStatetoMemento());

        originator.setState("State #4");
        System.out.println("Current state : "+originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First Saved  state : " + originator.getState());

        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Sceond saved state : "+originator.getState());
    }
}
