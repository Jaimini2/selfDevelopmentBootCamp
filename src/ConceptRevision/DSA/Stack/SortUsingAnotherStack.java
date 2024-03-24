package  src.ConceptRevision.DSA.Stack;

public class SortUsingAnotherStack {
    int []stack;
    int[]stack2;
    int top = -1;
    int top2 = -1;

    public int[] solve(int[] A) {
        for(int i =0 ; i < A.length;i++){
            if(isEmpty2()){
                push2(A[i]);
                continue;
            }
            if (A[i] >= peek() && A[i] <= peek2()){
                push2(A[i]);
            }else if(A[i] > peek2()){
                while(!isEmpty2() && A[i] > peek2()){
                    push(pop2());
                }
                push2(A[i]);
            }else if(A[i] < peek()){
                while (!isEmpty() && A[i] < peek()){
                    push2(pop());
                }
                push2(A[i]);
            }
            if (i == A.length - 1) {
                while (!isEmpty()) {
                    push2(pop());
                }
            }
        }

        for (int i =0 ; i < stack2.length;i++){
                A[i] = pop2();
        }
        return A;
    }

    int[] createStack(int length) {
        return new int[length];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isEmpty2() {
        return top2 == -1;
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack[top];
    }

    int peek2() {
        if (isEmpty2()) {
            return -1;
        }
        return stack2[top2];
    }

    void push(int value) {
        if (top == stack.length - 1) {
            return;
        } else {
            top = top + 1;
            stack[top] = value;
        }
    }

    void push2(int value) {
        if (top2 == stack2.length - 1) {
            return;
        } else {
            top2 = top2 + 1;
            stack2[top2] = value;
        }
    }
    int pop() {
        if (top == -1) {
            return -1;
        } else {
            int val = stack[top];
            top--;
            return val;
        }
    }

    int pop2() {
        if (top2 == -1) {
            return -1;
        } else {
            int val = stack2[top2];
            top2--;
            return val;
        }
    }

    void cleanStack(int[] stack) {
        while (!isEmpty()) {
            pop();
        }
    }

    public  void displaySortedArray(int[] intArray){
        for (int i =0 ; i < intArray.length;i++){
            System.out.print(intArray[i] + " ,");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortUsingAnotherStack s1 = new SortUsingAnotherStack();
        int A[] = {40, 74, 53, 40, 100, 85, 57, 95, 2, 11, 74, 50, 27, 74, 81, 34, 27, 41, 92, 40, 65, 82, 32};
        s1.stack = s1.createStack(A.length);
        s1.stack2 = s1.createStack(A.length);

        int ans[] = s1.solve(A);

        s1.displaySortedArray(ans);
    }
}
