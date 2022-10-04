package DesignPatterns.com.BehavioralDP.Strategy;

//client creates and passes the concrete strategy object to the context
public class Client {
    public static void main(String[] args) {

            ShoppingCart cart = new ShoppingCart();
            Item it1 = new Item("1234",10);

            Item it2 = new Item("4567",35);
            cart.addItem(it1);
            cart.addItem(it2);

            //pay by paypal
            cart.pay(new PayPalStrategy("Jaimini.mehta@fiserv.com","1234"));

            //pay by credit card
            cart.pay(new CreditCarStrategy("Jam","1234567788","456","14/04/2023"));

    }
}
