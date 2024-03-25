package src.Scaler.DesignPatterns.AdapterDesign;

public class ICICIBankAdapter implements BankAPI{

    ICICIBankAPI iciciBankAPI;

    ICICIBankAdapter(){
        this.iciciBankAPI = new ICICIBankAPI();
    }
    @Override
    public int checkBalance() {
        return iciciBankAPI.balanceCheck();
    }

    @Override
    public boolean transferMoney() {
        return iciciBankAPI.transferMoney();
    }
}
