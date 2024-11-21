package src.finalDSARevisionScaler.stack;

/**
 * Q39) Balanced Paranthesis using Stack
 */
public class BalancedParanthesis {

    CharStack stack;

    public CharStack createStack(){
        return new CharStack();
    }

    public int solve(String A){
        stack = createStack();

        for (int i = 0; i < A.length();i++){
            if (isOPenBraces(A.charAt(i))){
                stack.push(A.charAt(i));
            }else if(isCLosedBraces(A.charAt(i))){
                if(stack.peek() == openBraceChar(A.charAt(i))){
                    stack.pop();
                }else {
                    return 0;
                }
            }
        }
        if (stack.isEmpty()){
            return 1;
        }

        stack.printStack();

        return 0;
    }

    private int openBraceChar(char c) {
        return c == '}' ? '{' : c == ')' ? '(' : c == ']' ? '[' : null;
    }

    boolean isOPenBraces(char a){
        return a == '{' || a==  '(' || a ==  '[';
    }

    boolean isCLosedBraces(char a){
        return a == '}' || a == ')' || a == ']';
    }



    public static void main(String[] args) {

        BalancedParanthesis br = new BalancedParanthesis();
        String A = "{{{((([[]]{}}}";

        int ans = br.solve(A);
        System.out.println(ans);
    }
}
