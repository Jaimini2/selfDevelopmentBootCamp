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
                if(peek() == closedBracket(A.charAt(i))){
                    pop();
                }else{
                    return 0;
                }
             }
         }
        if(isEmpty()){
            return 1;
        }
        return 0;
    }

    private void pop() {
        if(isEmpty()){
            return;
        }else{
            top = top-1;
        }
    }

    private boolean isEmpty(){
        return top == -1;
    }

    char closedBracket(char ch){
       return ch == '}' ? '{' : ch == ')' ? '(' : ch == ']'?'[' :' ';
    }

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

    public static void main(String[] args) {
       // char A[] = { '{','(','[',']',')','}'};
        String A = "))))))))";

        int ans = new BalancedParanthesis().solve(A);

        System.out.println(ans);


    }
}
