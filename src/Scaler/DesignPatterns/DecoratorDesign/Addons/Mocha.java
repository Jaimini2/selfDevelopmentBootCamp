package src.Scaler.DesignPatterns.DecoratorDesign.Addons;

import src.Scaler.DesignPatterns.DecoratorDesign.Beverage;

public class Mocha implements Beverage {

    Beverage cb;

    public Mocha(Beverage b){
        this.cb = b;
    }
    @Override
    public int getCost() {
        return  30 + cb.getCost();
    }
}
