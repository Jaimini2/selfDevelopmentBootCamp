package DesignPatterns.com.BehavioralDP.TemplateMethod.Challenge;

public class Client {
    public static void main(String[] args) {
        OrderProcessTemplate NetOrder = new NetOrder();
        NetOrder.processOrder(true);

        System.out.println("\n ********** We changed the template to a store Order*****************\n");

        OrderProcessTemplate storeOrder = new StarOrder();
        storeOrder.processOrder(false);
    }
}
