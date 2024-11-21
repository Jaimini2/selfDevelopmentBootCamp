package src.finalDSARevisionScaler.stack;

public class CharStack {
    char[] stack;
    int top = -1;

    CharStack(){
        stack = new char[3];

    }

    public void push(char data){
        if(top == -1){
            top++;
            stack[top] = data;
        }
        else {
            if(top < stack.length - 1){
                //  top++;
                stack[++top] = data;
            }else{
                char arr[] = new char[stack.length*2];
                System.arraycopy(stack,0,arr,0,stack.length);
                stack = arr;
                stack[++top] = data;

            }

        }
    }

    public char pop(){
        if (top == -1){
            return (char)top;
        }else{
            char data = stack[top--];
            return data;
        }
    }

    public char peek(){
        if(isEmpty()){{
            return (char)-1;
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
