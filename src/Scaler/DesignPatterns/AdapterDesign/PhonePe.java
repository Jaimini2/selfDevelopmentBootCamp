package src.Scaler.DesignPatterns.AdapterDesign;

public class PhonePe {

    int amount ;
    BankAPI bankAPI;

    PhonePe(BankAPI bankAPI){
        this.bankAPI = bankAPI;
    }

    int checkAmount(){
        return bankAPI.checkBalance();
    }

    boolean transferMoney(){
        return bankAPI.transferMoney();
    }
}
