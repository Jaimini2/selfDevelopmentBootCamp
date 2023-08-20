package ConceptRevision.DSA.Stack;

public class MinStack {
    long []stack = new long[5];
    int top =-1;
    long min = Integer.MAX_VALUE;

    public void push(int x) {
        if(top == stack.length-1){
            long arr[] = new long[stack.length * 2];
            System.arraycopy(stack,0,arr,0,stack.length);

            stack = arr;
        }

        if (isEmpty()){
            top = top+1;
            stack[top] = x;
            min = Math.min(x,min);
            return;
        }
        top=top+1;


        if(x < min){
            stack[top] = 2 * x - min;
        }else{
            stack[top] = x;
        }
        min = Math.min(x,min);

    }

    public void pop() {
            if (isEmpty()){
                return;
            }
            long x = stack[top];
            if(x < min){
                min = 2 * min - x;
            }
            top = top-1;
    }

    public int top() {
        if(isEmpty()){
            return  -1;
        }
        return stack[top] < min ? (int)(2 * min - stack[top]) : (int)stack[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int getMin() {
        return (int)min;
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(644643544);
        System.out.println(ms.getMin());
        System.out.println(ms.top());
        System.out.println(ms.top());
        System.out.println(ms.top());
    }

}
