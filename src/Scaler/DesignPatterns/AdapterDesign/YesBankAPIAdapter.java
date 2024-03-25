package src.Scaler.DesignPatterns.AdapterDesign;

public class YesBankAPIAdapter implements BankAPI{

    YesBankAPI yesBankAPI;

    YesBankAPIAdapter(){
        this.yesBankAPI = new YesBankAPI();
    }

    @Override
    public int checkBalance() {
        return yesBankAPI.getBalance();
    }

    @Override
    public boolean transferMoney() {
        return yesBankAPI.sendMoney();
    }
}
