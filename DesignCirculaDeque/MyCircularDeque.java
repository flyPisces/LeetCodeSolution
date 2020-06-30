package DesignCirculaDeque;

/**
 * Design your implementation of the circular double-ended queue (deque).
 *
 * Your implementation should support following operations:
 *
 * MyCircularDeque(k): Constructor, set the size of the deque to be k.
 * insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
 * insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
 * deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
 * deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
 * getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
 * getRear(): Gets the last item from Deque. If the deque is empty, return -1.
 * isEmpty(): Checks whether Deque is empty or not.
 * isFull(): Checks whether Deque is full or not.
 *
 *
 * Example:
 *
 * MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
 * circularDeque.insertLast(1);			// return true
 * circularDeque.insertLast(2);			// return true
 * circularDeque.insertFront(3);			// return true
 * circularDeque.insertFront(4);			// return false, the queue is full
 * circularDeque.getRear();  			// return 2
 * circularDeque.isFull();				// return true
 * circularDeque.deleteLast();			// return true
 * circularDeque.insertFront(4);			// return true
 * circularDeque.getFront();			// return 4
 */
public class MyCircularDeque {
    int[] arr;
    int rear, start = 0;
    int LEN = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        LEN = k + 1;
        arr = new int[k + 1];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        arr[start] = value;
        start = (start + 1) % LEN;

        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear - 1 + LEN) % LEN;
        arr[rear] = value;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        start = (start - 1 + LEN) % LEN;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear + 1) % LEN;

        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : arr[(start - 1 + LEN) % LEN];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : arr[rear];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return start == rear;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (start + 1) % LEN == rear;
    }
}
