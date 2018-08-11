package linklist;

public class ReorderList {
	ListNode reverse(ListNode head){
		ListNode prev=null,tmp=null;
		while(head!=null){
			tmp=head.next;
			head.next=prev;
			prev=head;
			head=tmp;
		}
		return prev;
	}
	
	ListNode midNode(ListNode head) {
		if(head.next==null)
			return head;
		ListNode fast=head.next,slow=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}
	
	public void reorderList(ListNode head) {
        if(head==null)
        	return;
        ListNode mid=midNode(head),tmp=null,last=null;
        ListNode l1=head;
        ListNode l2=reverse(mid.next);
        mid.next=null;
        while(l2!=null) {
        	if(last!=null) {
        		last.next=l1;
        	}
        	tmp=l1.next;
        	l1.next=l2;
        	l1=tmp;
        	last=l2;
        	l2=l2.next;
        }
        if(last!=null)
        	last.next=l1;
    }
	public static void main(String[] args) {
		ListNode list=new ListNode(1);
		list.next=new ListNode(2);
		list.next.next=new ListNode(3);
		list.next.next.next=new ListNode(4);
		list.next.next.next.next=new ListNode(5);
		//list.next.next.next.next.next=new ListNode(6);
		
		ReorderList obj=new ReorderList();
		obj.reorderList(list);
		ListNode.printList(list);
	};
	

}
