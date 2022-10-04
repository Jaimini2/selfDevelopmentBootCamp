package DesignPatterns.com.BehavioralDP.StateDP.Challenge;

public class AlertStateContext {
    private Phone currentState;

    public AlertStateContext(){
        currentState = new Vibration(); //default state
    }

    public void setState(Phone state){
        currentState = state;
    }

    public void alert(){
        currentState.ringAlert();
    }
}

