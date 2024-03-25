package src.Scaler.DesignPatterns.DecoratorDesign.Addons;

import src.Scaler.DesignPatterns.DecoratorDesign.Beverage;

public class Milk implements Beverage{
    Beverage cb ;

    public Milk(Beverage b){
        this.cb = b;
    }
    @Override
    public int getCost() {
        return  20 + cb.getCost();
    }
}
