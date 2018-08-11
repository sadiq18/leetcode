package linklist;

public class ReverseLinkedListII {
	
	private ListNode reverseBetweenHelper(ListNode start,int len) {
		ListNode tmp=start,prev=null,tmp2;
		for(int i=0;i<len;i++) {
			tmp2=tmp.next;
			tmp.next=prev;
			prev=tmp;
			tmp=tmp2;
		}
		start.next=tmp;
		return prev;
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tmp=head,prev=null;
        for(int i=1;i<m;i++) {
        	prev=tmp;
        	tmp=tmp.next;
        }
        ListNode result=reverseBetweenHelper(tmp,n-m+1);
        if(prev==null)
        	return result;
        prev.next=result;
        return head;
    }
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(3);
		l1.next.next.next=new ListNode(4);
		l1.next.next.next.next=new ListNode(5);
		
		ReverseLinkedListII obj=new ReverseLinkedListII();
		ListNode.printList(obj.reverseBetween(l1, 3, 3));
	}

}
