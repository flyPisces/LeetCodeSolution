package MinStack;

import java.util.*;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.

 * Created by aoshen on 7/7/16.
 */
public class MinStack {

    class Element {
        int val;
        int min;
        Element next;

        public Element(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Element top;

    public MinStack() {
        top = null;
    }

    public void push(int x) {
        if (top == null) {
            top = new Element(x, x);
        } else {
            Element ele = new Element(x, Math.min(x, top.min));
            ele.next = top;
            top = ele;
        }
    }

    public void pop() {
        if (top != null) {
            top = top.next;
        }
    }

    public int top() {
        if (top != null) {
            return top.val;
        }

        return -1;
    }

    public int getMin() {
        if (top != null) {
            return top.min;
        }

        return -1;
    }
}
