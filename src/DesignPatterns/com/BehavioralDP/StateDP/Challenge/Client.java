package DesignPatterns.com.BehavioralDP.StateDP.Challenge;

public class Client {
    public static void main(String[] args) {
        AlertStateContext stateContext = new AlertStateContext();

        stateContext.alert();
        stateContext.alert();

        //changing the state
        stateContext.setState(new Silent());
        stateContext.alert();
        stateContext.alert();
        stateContext.alert();
    }
}
