package DesignPatterns.com.BehavioralDP.Visitor;

public class Client {

    private static int calculatePrice(ItemElement[] items){
    ShoppingCartVisitor visitor = new ShoppingCartImpl();

    int sum = 0;

    for(ItemElement item : items){
        sum = sum + item.accept(visitor);
    }
    return sum;
    }


    public static void main(String[] args) {

        ItemElement[] items = new ItemElement[]{new Book(20,"1234"),new Book(65,"4567"),new Book(90,"9999")
        ,new Fruit(54,"Apple",4),new Fruit(30,"Chikuu",2)};

        int total = calculatePrice(items);
        System.out.println("Total Cost : "+total);
    }
}
