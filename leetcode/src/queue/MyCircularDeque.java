package queue;

import java.util.*;

class MyCircularDeque {
    List<Integer> queue;
    int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.queue=new LinkedList<>();
        this.size=k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(queue.size()==size)
        	return false;
    	queue.add(0,value);
    	return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
    	if(queue.size()==size)
        	return false;
    	return queue.add(value);
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
    	if(queue.isEmpty())
    		return false;
    	queue.remove(0);
    	return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
    	if(queue.isEmpty())
    		return false;
    	queue.remove(queue.size()-1);
    	return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
    	if(queue.isEmpty())
    		return -1;
    	return queue.get(0);
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
    	if(queue.isEmpty())
    		return -1;
    	return queue.get(queue.size()-1);
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public boolean isFull() {
    	return queue.size()==size;
    }
}
