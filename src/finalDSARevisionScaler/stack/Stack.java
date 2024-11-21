package src.finalDSARevisionScaler.stack;

public class Stack {

    int[] stack;
    int top = -1;

     public Stack(){
        stack = new int[3];

    }

    public void push(int data){
         if(top == -1){
             top++;
             stack[top] = data;
         }
         else {
             if(top < stack.length - 1){
               //  top++;
                 stack[++top] = data;
             }else{
                 int arr[] = new int[stack.length*2];
                 System.arraycopy(stack,0,arr,0,stack.length);
                 stack = arr;
                 stack[++top] = data;

             }

         }
    }

    public int pop(){
         if (top == -1){
             return top;
         }else{
             int data = stack[top--];
             return data;
         }
    }

    public int peek(){
         if(isEmpty()){{
             return -1;
         }}
         return stack[top];
    }

    public boolean isEmpty(){
         return top == -1;
    }

    public void printStack(){
        for (int i = top;i >= 0;i--){
            System.out.print(stack[i] + "  ");
        }
    }

    public int size(){
         return top + 1;
    }

}
