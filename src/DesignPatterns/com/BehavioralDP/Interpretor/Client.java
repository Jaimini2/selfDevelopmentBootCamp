package DesignPatterns.com.BehavioralDP.Interpretor;

public class Client {

    //Creating a helper method for us
    public static Expression getMaleExpression(){
        Expression Robert = new TerminalExpression("Robert");
        Expression John = new TerminalExpression("John");
        return new ORExpression(Robert,John);
    }

    public static Expression getMarriedWomanExression(){
        Expression julie = new TerminalExpression("Julie");
        Expression Married = new TerminalExpression("Married");
        return new AndExpression(julie,Married);
    }

    public static void main(String [] args){
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExression();

        Context ic = new Context("John");
        System.out.println("John is Male ? " + isMale.interpret(ic));

        Context ic2 = new Context("Married Julie");
        System.out.println("Julie is Married ? " + isMarriedWoman.interpret(ic2));

        Context ic3 = new Context("Lucy");
        System.out.println("Lucy is Male ? " + isMale.interpret(ic3));
    }
}
