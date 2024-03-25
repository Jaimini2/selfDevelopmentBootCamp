package src.Scaler.DesignPatterns.DecoratorDesign;

import src.Scaler.DesignPatterns.DecoratorDesign.Addons.Milk;
import src.Scaler.DesignPatterns.DecoratorDesign.Addons.Mocha;

public class DecoratorClient {

    public static void main(String[] args) {

        Beverage cb = new Decaf();

        cb = new Milk(cb);

        cb = new Mocha(cb);

        System.out.println(cb.getCost());
    }
}
