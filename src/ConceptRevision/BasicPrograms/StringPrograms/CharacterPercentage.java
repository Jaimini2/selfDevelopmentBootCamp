package  src.ConceptRevision.BasicPrograms.StringPrograms;

import java.text.DecimalFormat;

/**
 * Program to find the percentage of uppercase,lowercase,
 * digits and special characters in a String
 */
public class CharacterPercentage {

    static void CharacterString(String input){
        int totalCharacter = input.length();
        int uppercase = 0;
        int lowerCase = 0;
        int digits = 0;
        int others = 0;

        for(int i =0; i < input.length();i++){
            char ch = input.charAt(i);
            if(Character.isUpperCase(ch)){
                uppercase++;
            }
            else if(Character.isLowerCase(ch)){
                lowerCase++;
            }
            else if(Character.isDigit(ch)){
                digits++;
            }
            else {
                others++;
            }
        }

        double upperCaseletterPrecentage = (uppercase  *100 )/totalCharacter;
        double lowerCaseLetterPercentage = (lowerCase * 100 ) / totalCharacter;
        double digitsPercentage = (digits * 100)/totalCharacter;
        double otherCharPercentage = (others * 100)/totalCharacter;

        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        System.out.println("Input  : " +input + ":");
        System.out.println("Counts are UpperCase : "+uppercase + "LowerCase are :"+lowerCase + "Digits are : "+digits + " others : "+others);
        System.out.println("Upper Case letters are : "+decimalFormat.format(upperCaseletterPrecentage) + "%");
        System.out.println("Lower Case letters are : "+decimalFormat.format(lowerCaseLetterPercentage) + "%");
        System.out.println("Digits are : "+decimalFormat.format(digitsPercentage) + "%");
        System.out.println("Other  letters are : "+decimalFormat.format(otherCharPercentage) + "%");

    }

    public static void main(String[] args) {
        CharacterString("This is 95 back street Boys");
    }
}
