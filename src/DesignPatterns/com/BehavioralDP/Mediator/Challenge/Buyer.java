package DesignPatterns.com.BehavioralDP.Mediator.Challenge;

abstract class Buyer {
    //this class holds the Buyer
    protected Mediator mediator;
    protected String name;
    protected  int price;

    public Buyer(Mediator med,String name){
            this.mediator = med;
            this.name = name;
    }

    public abstract void bid(int price);
    public abstract void cancelTheBid();
    public abstract void auctionHasEnded();
}

class AuctionBuyer extends Buyer{
    //implementation of the bidding process .There is an option to bid and option to

    public AuctionBuyer(Mediator med,String name){
        super(med,name);
    }

    @Override
    public void bid(int price) {
        this.price = price;
    }

    @Override
    public void cancelTheBid() {
    this.price = -1;
    }

    @Override
    public void auctionHasEnded() {
        System.out.println("Received message that the acution is over :  " + name);
    }
}