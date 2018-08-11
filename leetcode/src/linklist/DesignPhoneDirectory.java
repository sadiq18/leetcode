package linklist;

import java.util.*;

public class DesignPhoneDirectory {

	/**
	 * @param args
	 */
	int max;
	HashSet<Integer> set;
    LinkedList<Integer> queue;
    
    public DesignPhoneDirectory(int maxNumbers){
    	set = new HashSet<>();
        queue = new LinkedList<>();
        for(int i=0; i<maxNumbers; i++){
            queue.offer(i);
        }
        max=maxNumbers-1;
    }
    
    public int get() {
        if(queue.isEmpty())
            return -1;
 
        int e = queue.poll();
        set.add(e);
        return e;
    }
    
    public boolean check(int number) {
        return !set.contains(number) && number<=max;
    }
    
    public void release(int number) {
        if(set.contains(number)){
            set.remove(number);
            queue.offer(number);
        }
    }
    
	public static void main(String[] args) {
		
	}

}
