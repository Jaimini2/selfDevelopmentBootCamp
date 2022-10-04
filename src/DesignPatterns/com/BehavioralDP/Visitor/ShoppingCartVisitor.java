package DesignPatterns.com.BehavioralDP.Visitor;

public interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}

class ShoppingCartImpl implements ShoppingCartVisitor {

    @Override
    public int visit(Book book) {
        int cost = 0;
        //give 5% discount if book is greater than 50
        if(book.getPrice() > 50){
            cost = book.getPrice() - 5;
        }else{
            cost = book.getPrice();
        }
        System.out.println("Book isbN : "+book.getIsbnNumber() + "Cost : "+ cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();

        System.out.println("Fruit : "+ fruit.getName() + "Cost : "+cost);

        return cost;
    }
}