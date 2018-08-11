package linklist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
	
	public ListNode detectCycleExtraSpace(ListNode head) {
        ListNode tmp=head;
        Set<ListNode> set=new HashSet<>();
        while(tmp!=null) {
        	if(set.contains(tmp))
        		return tmp;
        	set.add(tmp);
        	tmp=tmp.next;
        }
        return tmp;
    }
	
	public ListNode detectCycle(ListNode head) {
        // Find the collision point if the list has a cycle
        if (head == null) return null;
         
        ListNode slow = head;
        ListNode fast = head;
         
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
             
            if (slow == fast) break;
        }
         
        // check if the list has no cycle
        if (fast == null || fast.next == null) 
            return null;
         
        // find the entrance of the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
	
	public static void main(String[] args) {

	}

}
