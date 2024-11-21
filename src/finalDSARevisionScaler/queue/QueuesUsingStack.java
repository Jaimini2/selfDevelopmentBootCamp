package src.finalDSARevisionScaler.queue;

import src.finalDSARevisionScaler.stack.Stack;

/**
 * Q43)Queue using stack
 *
 */
public class QueuesUsingStack {
    Stack stack1;

    Stack stack2;

        public void buildQueue(){
            stack1 = new Stack();

            stack2 = new Stack();
        }

        public void enqueue(int data){
            stack1.push(data);
        }

        public int dequeue(){
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }

                return stack2.pop();
            }else{
               return stack2.pop();
            }
        }

        public int front(){
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.peek();
            }else{
                return stack2.peek();
            }
        }

    public static void main(String[] args) {

    }
}
