package DesignPatterns.com.BehavioralDP.Strategy.Challenge;

public class Client {
    public static void main(String[] args) {
        StrategyContext context = new StrategyContext();

        //Addition Strrategy
       System.out.println("Addition Strategy : "+context.executeOperation(new OperationAdd(),56,43));

       //Subtraction Strategy
        System.out.println("Subtraction Strategy : "+context.executeOperation(new OperationSub(),13,23));

        //Multiplication Strategy
        System.out.println("Multiplication Strategy : "+context.executeOperation(new OperationMul(),12,12));
    }
}
