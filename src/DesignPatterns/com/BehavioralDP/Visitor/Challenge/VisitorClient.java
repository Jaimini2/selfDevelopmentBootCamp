package src.DesignPatterns.com.BehavioralDP.Visitor.Challenge;

import java.util.ArrayList;

public class VisitorClient {

    //normal shopping cart stuff
    public static ArrayList<Visitable> itemcart = new ArrayList<Visitable>();

    public static double calculatePostage(Visitor visitor){
        //iterate through all items
        for (Visitable item: itemcart){
            item.accept(visitor);
        }
        return visitor.getTotalPostage();

    }

    public static void main(String[] args) {
        //create a bunch of visitors(Book , CD and DVD)
        Visitable   myBook = new Book(25,56.4);
        Visitable myDvd = new DVD(56,23);
        Visitable myCD = new CD(12,2);

        //add each visitor to the arrayList
        itemcart.add(myBook);
        itemcart.add(myDvd);
        itemcart.add(myCD);

        Visitor visitor = new USPostageVisitor();
        double myPostage = calculatePostage(visitor);

        System.out.println("Total Postage for my Items shipped to US is : " + myPostage);

        System.out.println("===========================================================");

        visitor = new SouthAmeriaPostageVisitor();
        System.out.println("Total Postage for my Items shipped to SOuth America is : "+ calculatePostage(visitor));



    }
}
