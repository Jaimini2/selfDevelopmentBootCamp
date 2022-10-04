package DesignPatterns.com.BehavioralDP.Visitor;

public interface ItemElement {
     int accept(ShoppingCartVisitor visitor);
}

class Book implements ItemElement{

    private int price;
    private String isbnNumber;

    Book(int price, String isbnNumber){
        this.isbnNumber = isbnNumber;
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

    public String getIsbnNumber(){
        return this.isbnNumber;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}

class Fruit implements ItemElement{

    private int pricePerKg;
    private String name;
    private int weight;


    Fruit(int pricePerKg,String name,int weight){
        this.pricePerKg = pricePerKg;
        this.name = name;
        this.weight = weight;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
