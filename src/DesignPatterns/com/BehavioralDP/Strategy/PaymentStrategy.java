package DesignPatterns.com.BehavioralDP.Strategy;

public interface PaymentStrategy {
    public void pay(int amount);

}

class CreditCarStrategy implements PaymentStrategy{

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCarStrategy(String nm,String cardnm,String cvv,String doe){
        this.name = nm;
        this.cardNumber = cardnm;
        this.cvv = cvv;
        this.dateOfExpiry = doe;

    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "paid with credit/debit card");
    }
}

class PayPalStrategy implements  PaymentStrategy{

    private String email;
    private String password;

    PayPalStrategy(String email,String pass){
        this.email = email;
        this.password = pass;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "paid using Paypal.");
    }
}