package src.Scaler.DesignPatterns.AdapterDesign;

public class AdapterCLient {

    public static void main(String[] args) {
        BankAPI ICICBankAdapter = new ICICIBankAdapter();

        BankAPI yesBankAdapter = new YesBankAPIAdapter();
        PhonePe ph = new PhonePe(yesBankAdapter);

        System.out.println(ph.checkAmount());

        System.out.println(ph.transferMoney());

    }
}
