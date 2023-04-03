package Scaler.Stack;

public class BalancedParanthesis {
    int top = -1;
    char[] stack;
    public int solve(String A) {

         stack = createStack(A);
         for (int i =0; i < A.length();i++){
             if(isOpenBraces(A.charAt(i))){
                push(A.charAt(i));
             }else if(isClosingBraces(A.charAt(i))){
               // if(peek() == )
             }
         }
        return 0;
    }

//    char closedBracket(char ch){
//        if(ch == )
//    }

    private boolean isClosingBraces(char ch) {
        return ch == '}' || ch == ')' || ch == ']' ;
    }

    boolean isOpenBraces(char ch){
        return ch == '(' || ch == '{' || ch == '[' ;

    }
        void push(char c){
            if(top == stack.length){
                return ;
            }else{
                top++;
                stack[top] = c;
            }
        }

        char peek(){
        if(top == -1){
            return (char) top;
        }
        return stack[top];
        }

    char [] createStack(String A){
        return new char[A.length()];
    }
}
