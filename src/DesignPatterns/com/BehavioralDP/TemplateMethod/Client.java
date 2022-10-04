package DesignPatterns.com.BehavioralDP.TemplateMethod;

public class Client {
    public static void main(String[] args) {
        HouseTemplate houseTemplate = new WoodenHouse();

        //using the template method
        houseTemplate.buildHouse();
        System.out.println("****************");

        houseTemplate = new GlassHouse();
        houseTemplate.buildHouse();
    }
}
