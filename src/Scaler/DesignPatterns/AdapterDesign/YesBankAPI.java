package src.Scaler.DesignPatterns.AdapterDesign;

public class YesBankAPI{

    int balance = 50000;

         public   int getBalance(){
                return this.balance;
            }

            public boolean sendMoney(){
             return false;
            }

}
