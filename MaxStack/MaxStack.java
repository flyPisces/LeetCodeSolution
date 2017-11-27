package MaxStack;

import java.util.*;

/**
 * Design a max stack that supports push, pop, top, peekMax and popMax.

 push(x) -- Push element x onto stack.
 pop() -- Remove the element on top of the stack and return it.
 top() -- Get the element on the top.
 peekMax() -- Retrieve the maximum element in the stack.
 popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
 Example 1:
 MaxStack stack = new MaxStack();
 stack.push(5);
 stack.push(1);
 stack.push(5);
 stack.top(); -> 5
 stack.popMax(); -> 5
 stack.top(); -> 1
 stack.peekMax(); -> 5
 stack.pop(); -> 1
 stack.top(); -> 5
 */
public class MaxStack {

    class Node {
        int val;
        int max;

        public Node(int val, int max) {
            this.val = val;
            this.max = max;
        }
    }

    Stack<Node> stack;

    public MaxStack() {
        stack = new Stack<Node>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Node(x, x));
        } else {
            int max = stack.peek().max;
            stack.push(new Node(x, Math.max(max, x)));
        }
    }

    public int pop() {
        return stack.pop().val;
    }

    public int top() {
        return stack.peek().val;
    }

    public int peekMax() {
        return stack.peek().max;
    }

    public int popMax() {
        int max = stack.peek().max;
        Stack<Node> temp = new Stack<Node>();
        boolean found = false;

        while (!stack.empty()) {
            Node top = stack.pop();

            if (top.val == max && !found) {
                found = true;
                continue;
            } else {
                temp.push(top);
            }
        }

        int result = max;
        max = Integer.MIN_VALUE;

        while (!temp.isEmpty()) {
            Node top = temp.pop();

            max = Math.max(top.val, max);
            top.max = max;

            stack.push(top);
        }

        return result;
    }
}
