package DesignPatterns.com.BehavioralDP.StateDP;

public class TV {
    public RemoteControl state;

    public RemoteControl getState(){
        return state;
    }

    public void setState(RemoteControl state){
        this.state = state;
    }
    public TV(RemoteControl state){
        this.state = state;
    }


    public void pressButton(){
        state.pressSwitch(this);
    }

}
