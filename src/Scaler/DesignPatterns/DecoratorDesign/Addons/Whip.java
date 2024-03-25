package src.Scaler.DesignPatterns.DecoratorDesign.Addons;

import src.Scaler.DesignPatterns.DecoratorDesign.Beverage;

public class Whip implements Beverage {

    Beverage cb ;

    Whip(Beverage b){
        this.cb = b;
    }
    @Override
    public int getCost() {
        return  10 + cb.getCost();
    }
}
