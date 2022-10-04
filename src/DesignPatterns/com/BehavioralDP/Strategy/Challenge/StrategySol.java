package DesignPatterns.com.BehavioralDP.Strategy.Challenge;

public interface StrategySol {
    public int performOperation(int i1, int i2);
}

class OperationAdd implements StrategySol{


    @Override
    public int performOperation(int i1, int i2) {
        return  i1 + i2;
    }
}

class OperationSub implements StrategySol{

    @Override
    public int performOperation(int i1, int i2) {
        return i1 - i2;
    }
}

class OperationMul implements StrategySol{

    @Override
    public int performOperation(int i1, int i2) {
        return i1 * i2;
    }
}
