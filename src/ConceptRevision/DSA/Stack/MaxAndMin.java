package ConceptRevision.DSA.Stack;

import ConceptRevision.DSA.Arrays.MergeSort;

public class MaxAndMin {
    int[] stack;
    int top = -1;
    long[] leftSmallerSide;
    long[] rightSmallerSide;
    long[] leftLargerSide;
    long[] rightLargerSide ;

    public int solve(int[] A) {
        long ans = 0;
        long maxAns = 0;
        long minAns = 0;
        long mod = 1000000007;

       leftSmallerSide = new long[A.length];
        rightSmallerSide = new long[A.length];
         leftLargerSide = new long[A.length];
         rightLargerSide = new long[A.length];

        stack = createStack(A.length);

        //handling edge cases like only one element in an array

        if (A.length == 1) {
            return 0;
        }
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
        cleanStack(stack);

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


        //cleaning stack
        cleanStack(stack);

        //approach for having leftLargerSide
        for (int i = 0; i < A.length; i++) {
            while (!isEmpty() && A[i] >= A[peek()]) {
                pop();
            }

            if (isEmpty()) {
                leftLargerSide[i] = -1;
            } else {
                leftLargerSide[i] = peek();
            }

            push(i);

        }

            cleanStack(stack);
        //approach for rightLargerSide
        //{992387, 932142, 971117, 934674, 988917, 967890, 948508, 970347 };

     //   stack 1 : 932142 934674 948508

    //    stack 2 : 992387  988917  971117  970347 967890  948508 934674 932142
        //
        for (int i = A.length - 1; i >= 0; i--) {
            while (!isEmpty() && A[i] >= A[peek()]) {
                pop();
            }

            if (isEmpty()) {
                rightLargerSide[i] = A.length;
            } else {
                rightLargerSide[i] = peek();
            }
            push(i);
        }


        // find max and min contribution of each element

        for (int i = 0; i < A.length; i++) {
            maxAns =( maxAns % mod + ((i - leftLargerSide[i]) * (rightLargerSide[i] - i) * A[i])%mod) % mod;
            minAns = (minAns % mod + ((i - leftSmallerSide[i]) * (rightSmallerSide[i] - i) * A[i]) % mod) % mod;
        }

        ans = maxAns - minAns;

        return (int)(ans % mod);
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

    void cleanStack(int[] stack) {
        while (!isEmpty()) {
            pop();
        }
    }

    public  void displaySortedArray(long[] intArray){
        for (int i =0 ; i < intArray.length;i++){
            System.out.print(intArray[i] + " ,");

        }
        System.out.println();
    }
    public static void main(String[] args) {
        MaxAndMin mm = new MaxAndMin();
        int []A = {992387, 932142, 971117, 934674, 988917, 967890, 948508, 970347 };
        int ans = mm.solve(A);

        mm.displaySortedArray(mm.leftLargerSide);
        mm.displaySortedArray(mm.leftSmallerSide);
        mm.displaySortedArray(mm.rightLargerSide);
        mm.displaySortedArray(mm.rightSmallerSide);

        System.out.println(ans);
    }

}
