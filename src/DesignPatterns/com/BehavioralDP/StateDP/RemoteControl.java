package DesignPatterns.com.BehavioralDP.StateDP;

abstract class RemoteControl {

    public abstract void pressSwitch(TV context);

}

class On extends RemoteControl{

    @Override
    public void pressSwitch(TV context) {
        System.out.println("I was off  , I have started On");
        context.setState(new Off());
    }
}

class Off extends RemoteControl{

    @Override
    public void pressSwitch(TV context) {
        System.out.println("I am already On , Going to be off now");
        context.setState(new On());
    }
}