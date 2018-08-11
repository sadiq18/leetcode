package linklist;

public class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
	
	public static void printList(ListNode head){
		ListNode tmp=head;
		while(tmp!=null){
			System.out.print(tmp.val + " ");
			tmp=tmp.next;
		}
		System.out.println(" .");
	}
	
	public static int length(ListNode head){
		ListNode tmp=head;
		int len=0;
		while(tmp!=null){
			tmp=tmp.next;
			len++;
		}
		return len;
	}

}
