package DesignPatterns.com.BehavioralDP.Mediator.Challenge;

public class MediatorChallengeClient {
    public static void main(String[] args) {

        AuctionMediator med = new AuctionMediator();
        AuctionBuyer b1 = new AuctionBuyer(med,"AMoli");
        AuctionBuyer b2 = new AuctionBuyer(med,"Jaimini");
        AuctionBuyer b3 = new AuctionBuyer(med,"Naruto");

        //create and add buyers
        med.addBuyer(b1);
        med.addBuyer(b2);
        med.addBuyer(b3);

        System.out.println("Welcome to the auction .Tonight we are selling a vacation to Vanquover...");
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("Waiting for the buyers offers .... ");

        //Making bids
        b1.bid(18000);
        b2.bid(34000);
        b3.bid(12000);

        System.out.println("-------------------------------------------------------------------");
        med.findHighestBidder();
        b2.cancelTheBid();
        System.out.println(b2.name +" has cancel the bid , in that case ...");

        med.findHighestBidder();

    }
}
