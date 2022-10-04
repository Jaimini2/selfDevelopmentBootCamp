package DesignPatterns.com.BehavioralDP.StateDP;

public class client {
    public static void main(String[] args) {

        System.out.println("***** State Pattern Demo *******");

        //initially TV is off
        Off initialState = new Off();

        TV tv = new TV(initialState);

        //first time press
        tv.pressButton();
        //second time press
        tv.pressButton();
    }
}
