package DesignPatterns.com.BehavioralDP.Strategy.Challenge;

public class StrategyContext {
    public int executeOperation(StrategySol strategy , int num1 , int num2){
        return strategy.performOperation(num1,num2);

    }
}
