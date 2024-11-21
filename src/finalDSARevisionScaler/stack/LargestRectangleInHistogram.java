package src.finalDSARevisionScaler.stack;

/**
 * Q41)Largest Rectangle in Histogram
 */
public class LargestRectangleInHistogram {
    Stack stck;
    /*int[] stack;
    int top = -1;*/

    public Stack createStack() {
        return new Stack();
    }

  /*  int[] createStack(int length) {
        return new int[length];
    }*/

   /* boolean isEmpty() {
        return top == -1;
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack[top];
    }

    void push(int value) {
        if (top == stack.length - 1) {
            return;
        } else {
            top = top + 1;
            stack[top] = value;
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
    }*/

    public int largestRectangleArea(int[] A) {
        stck = createStack();

        int[] leftSmallerElements = new int[A.length];
        int[] rightSmallerElements = new int[A.length];

        //handling edge cases
        if (A.length == 0) {
            return 1;
        }

        // leftsmaller elements oepration
        for (int i = 0; i < A.length; i++) {
            while (!stck.isEmpty() && A[stck.peek()] >= A[i]) {
                stck.pop();
            }
            if (!stck.isEmpty())
                leftSmallerElements[i] = stck.peek();
            else
                leftSmallerElements[i] = -1;
            stck.push(i);
        }

        //cleaning stack
        while (!stck.isEmpty()) {
            stck.pop();
        }

        //right smaller elements operation
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stck.isEmpty() && A[stck.peek()] >= A[i]) {
                stck.pop();
            }

            if (!stck.isEmpty())
                rightSmallerElements[i] = stck.peek();
            else
                rightSmallerElements[i] = -1;
            stck.push(i);
        }

        //find area of largest rectangle
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans = Math.max(ans, A[i] * (rightSmallerElements[i] - leftSmallerElements[i] - 1));
        }

        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram lrh = new LargestRectangleInHistogram();
        int A[] = {2, 1, 5, 6, 2, 3};
        int ans = lrh.largestRectangleArea(A);
        System.out.println(ans);
    }
}
