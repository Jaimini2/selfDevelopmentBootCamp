package DesignPatterns.com.BehavioralDP.Visitor.Challenge;

public interface Visitable {
    public void accept(Visitor visitor);
}

class Book implements  Visitable{

    private double price;
    private double weight;

    Book(double price,double weight){
        this.price = price;
        this.weight = weight;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

}

class CD implements  Visitable{

    private double price;
    private double weight;

    CD(double price,double weight){
        this.price = price;
        this.weight = weight;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }
}

class DVD implements  Visitable{

    private double price;
    private double weight;

    DVD(double price,double weight){
        this.price = price;
        this.weight = weight;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }
}