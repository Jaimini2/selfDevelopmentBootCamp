package src.finalDSARevisionScaler.recurrsion2;

import java.util.ArrayList;

/**
 * Q32) Generate all PAranthesis
 * Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
 */
public class GenerateParanthesisII {

    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> ans  = new ArrayList<>();
        func("",0,0,A,ans);

        return ans;
    }
    void func(String asf, int openBraces, int closedBraces, int totalBraces, ArrayList<String> ans) {

        if(openBraces == closedBraces && openBraces == totalBraces){
            ans.add(asf);
            return;
        }
        if(openBraces < totalBraces){
            func(asf + "(",openBraces+1,closedBraces,totalBraces,ans);
        }

        if(closedBraces < openBraces){
            func(asf + ")",openBraces,closedBraces + 1,totalBraces,ans);
        }
    }

    public static void main(String[] args) {

        GenerateParanthesisII gp = new GenerateParanthesisII();

       ArrayList<String> ans =  gp.generateParenthesis(3);

       ans.forEach(p -> System.out.println(p));

    }
}
