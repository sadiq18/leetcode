package linklist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponent {

	/**
	 * @param args
	 */
	public int numComponents(ListNode head, int[] G) {
		if(head==null || G.length == 0)
			return 0;
		
		Set<Integer> set = new HashSet<>();
		for(int node : G){
			set.add(node);
		}
		int count=0;
		ListNode tmp=head;
		while(tmp != null){
			if(set.contains(tmp.val)){
				while(tmp!=null && set.contains(tmp.val))
					tmp=tmp.next;
				count++;
			}
			if(tmp!=null)
				tmp=tmp.next;
		}
		return count;
		
    }
	
	public static void main(String[] args) {
		ListNode list=new ListNode(0);
		list.next=new ListNode(1);
		list.next.next=new ListNode(2);
		list.next.next.next=new ListNode(3);
		
		int[] G=new int[]{0,1,2};
		
		LinkedListComponent obj=new LinkedListComponent();
		System.out.println(obj.numComponents(list, G));
	}

}
