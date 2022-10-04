package DesignPatterns.com.BehavioralDP.TemplateMethod.Challenge;

public abstract class OrderProcessTemplate {

    public boolean isGift;
    public abstract void doSelect();
    public abstract void doPayment();
    public final void giftWrap(){
        System.out.println("Gift wrap successfull");
        }
    public abstract void doDelivery();

    //the actual template method

    public final void processOrder(boolean isGift){
        doSelect();
        doPayment();

        if(isGift){
            giftWrap();
        }

        doDelivery();
    }
}

class NetOrder extends OrderProcessTemplate{

    @Override
    public void doSelect() {
        System.out.println("Item added to online Shopping cart");
        System.out.println("Get gift prefferrence");
        System.out.println("Get delivery address");
    }

    @Override
    public void doPayment() {
        System.out.println("Online payment through Netbanking,card or Paypal");
    }

    @Override
    public void doDelivery() {
        System.out.println("Shipe the item through post office to delivery address");

    }
}

class StarOrder extends OrderProcessTemplate{

    @Override
    public void doSelect() {
        System.out.println("Customer chooses the item from shelf");
    }

    @Override
    public void doPayment() {
        System.out.println("Pays at counter trough POS");
    }

    @Override
    public void doDelivery() {
        System.out.println("Item delivered at the delivery counter");
    }
}
