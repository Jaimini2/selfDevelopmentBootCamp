package  src.ConceptRevision.DSA.Stack;

public class LargestRectangleInHistogram {
    int[] stack;
    int top = -1;

    public int largestRectangleArea(int[] A) {
        int areaOfLargestRectangle = 0;
        int[] leftSmallerSide = new int[A.length];
        int[] rightSmallerSide = new int[A.length];
        stack = createStack(A.length);

        //approach for having leftSmallerSide
        for (int i = 0; i < A.length; i++) {
            while (!isEmpty() && A[i] <= A[peek()]) {
                pop();
            }

            if (isEmpty()) {
                leftSmallerSide[i] = -1;
            } else {
                leftSmallerSide[i] = peek();
            }

            push(i);

        }

        //cleaning stack
        while (!isEmpty()) {
            pop();
        }

        //approach for having rightSmallerSide
        for (int i = A.length - 1; i >= 0; i--) {
            while (!isEmpty() && A[i] <= A[peek()]) {
                pop();
            }

            if (isEmpty()) {
                rightSmallerSide[i] = A.length;
            } else {
                rightSmallerSide[i] = peek();
            }
            push(i);
        }

        // find area of largest Rectangle via Contribution technique

        for (int i = 0; i < A.length; i++) {
            areaOfLargestRectangle = Math.max(areaOfLargestRectangle, A[i] *
                    (rightSmallerSide[i] - leftSmallerSide[i] - 1));
        }

        return areaOfLargestRectangle;
    }

    int[] createStack(int length) {
        return new int[length];
    }

    boolean isEmpty() {
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
    }

    public static void main(String[] args) {
        int[] A = {47, 69, 67};
        LargestRectangleInHistogram lrh = new LargestRectangleInHistogram();

     int ans =   lrh.largestRectangleArea(A);
        System.out.println(ans);

    }


}


