package src.DesignPatterns.com.BehavioralDP.Visitor.Challenge;

public interface Visitor {
    public void visit(Book book);
    public void visit(CD cd);
    public void visit(DVD dvd);

    public double getTotalPostage();
}

class USPostageVisitor implements Visitor{

    private double totalPostageCart = 0;

    //collect data about the book
    @Override
    public void visit(Book book) {
        //assume we have a calculation here related to weight and price
        //free postage for a book over 20
        if(book.getPrice() < 20.0)totalPostageCart += book.getPrice() * 2;
    }

    @Override
    public void visit(CD cd) {
        if(cd.getPrice() < 20.0)totalPostageCart += cd.getPrice() * 2.5;
    }

    @Override
    public void visit(DVD dvd) {
        if (dvd.getPrice() < 20.0){
            totalPostageCart += dvd.getPrice() * 3;
        }
    }

    @Override
    public double getTotalPostage() {
        return totalPostageCart;
    }
}

class SouthAmeriaPostageVisitor implements Visitor{
    private double totalPostageCart = 0;

    //collect data about the book
    @Override
    public void visit(Book book) {
        //assume we have a calculation here related to weight and price
        //free postage for a book over 20
        if(book.getPrice() < 30.0)totalPostageCart += book.getPrice() * 2;
    }

    @Override
    public void visit(CD cd) {
        if(cd.getPrice() < 30.0)totalPostageCart += cd.getPrice() * 2.5;
    }

    @Override
    public void visit(DVD dvd) {
        if (dvd.getPrice() < 30.0){
            totalPostageCart += dvd.getPrice() * 3;
        }
    }

    @Override
    public double getTotalPostage() {
        return totalPostageCart;
    }

}