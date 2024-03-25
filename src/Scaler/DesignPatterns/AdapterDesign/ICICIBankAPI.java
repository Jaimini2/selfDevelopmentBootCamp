package src.Scaler.DesignPatterns.AdapterDesign;

public class ICICIBankAPI{

    int balance = 1000000;

    public int balanceCheck(){
        return this.balance;
    }

    public boolean transferMoney(){
        return true;
    }
}
