package DesignPatterns.com.BehavioralDP.Strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Item> items;

    public ShoppingCart(){
        items = new ArrayList<Item>();

    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public int calculateData(){
        int sum = 0;
        for (Item item : items){
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod){
        int amount = calculateData();
        paymentMethod.pay(amount);
    }

}
