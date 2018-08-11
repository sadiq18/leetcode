package linklist;

public class ReverseNodesInkGroup {
	
	private int length(ListNode head) {
		int len=0;
		ListNode tmp=head;
		while(tmp!=null) {
			tmp=tmp.next;
			len++;
		}
		return len;
	}
	private ListNode reverseKGroupHelper(ListNode start,int len) {
		ListNode tmp=start,prev=null,tmp2;
		
		for(int i=0;i<len && tmp!=null;i++) {
			tmp2=tmp.next;
			tmp.next=prev;
			prev=tmp;
			tmp=tmp2;
		}
		start.next=tmp;
		return prev;
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1)
        	return head;
        int len=length(head);
        ListNode tmp=head,prev=null;
        while(tmp!=null) {
        	if(k>len)
        		break;
        	len=len-k;
        	System.out.println(len);
        	if(prev==null) {
        		head=reverseKGroupHelper(tmp,k);
        	}else {
        		prev.next=reverseKGroupHelper(tmp,k);
        	}
        	prev=tmp;
        	tmp=tmp.next;
        }
        return head;
    }
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(3);
		l1.next.next.next=new ListNode(4);
		l1.next.next.next.next=new ListNode(5);
		
		ReverseNodesInkGroup obj=new ReverseNodesInkGroup();
		ListNode.printList(obj.reverseKGroup(l1, 1));
	}

}
