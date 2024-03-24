package  src.ConceptRevision.BasicPrograms;

/*Armstrong number is a positive m-digit number that
 is equal to the sum of the mth powers of their digits*/
public class ArmstrongNumber {
    public static void main(String[] args) {
        int num = 1635;
        int temp = num;
        int num2 = num;
        int rem , sum = 0, power=0;

        while(num2 > 0){
            num2 = num2/10;
            power++;
        }

        while(num > 0){
            rem = num%10;
            sum = sum + (int) Math.pow(rem,power);
            num = num / 10;
        }
        if(sum == temp)
            System.out.println(temp + " is an Armstrong number ");
        else
            System.out.println(temp  + " is not an Armstrong Number");


    }
}
