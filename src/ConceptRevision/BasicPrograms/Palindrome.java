package  src.ConceptRevision.BasicPrograms;

//palindrome numbers are numbers that will be same even after it has been reversed

/*Palindrome Algorithm
Get the number to be checked for Palindrome
* 1.Hold the number in temp variable
* 2.Reverse the number
  3.Compare the remp number with the Reversed number
  4.if both are same , print Palindrom
  5. Else print Not Palindrome*/
public class Palindrome {

    static void checkPalindrome(int num){

        int rem,num2 = 0, temp = num;
        while(temp > 0){
            rem = temp%10;
            num2 = (num2 * 10)+rem;
            temp = temp/10;
        }
        if(num == num2)
            System.out.println(num + " is a Palindrome number");
        else{
            System.out.println(num + " is not a palindrome number");
        }
    }

    public static void main(String[] args) {
        checkPalindrome(7667);
    }
}
