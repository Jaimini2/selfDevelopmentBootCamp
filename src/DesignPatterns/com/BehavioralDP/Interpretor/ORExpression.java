package DesignPatterns.com.BehavioralDP.Interpretor;

public class ORExpression implements  Expression {
    private Expression exp1 = null;
    private Expression exp2 = null;

    public ORExpression(Expression exp1, Expression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
    }


    @Override
    public boolean interpret(Context context) {
        return exp1.interpret(context) || exp2.interpret(context);
    }
}
