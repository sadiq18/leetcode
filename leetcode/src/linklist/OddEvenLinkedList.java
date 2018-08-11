package linklist;

public class OddEvenLinkedList {

	/**
	 * @param args
	 */
	public ListNode oddEvenListByValue(ListNode head) {
        if(head==null)
            return null;
        ListNode oddHead=new ListNode(0);
        ListNode evenHead=new ListNode(0);
        ListNode tmp=head,oddtmp=oddHead,eventmp=evenHead;
        
        while(tmp!=null){
            if(tmp.val%2==0){
                eventmp.next=tmp;
                eventmp=eventmp.next;
            }else{
                oddtmp.next=tmp;
                oddtmp=oddtmp.next;
            }
            tmp=tmp.next;
        }
        eventmp.next=null;
        oddtmp.next=null;
        oddHead=oddHead.next;
        evenHead=evenHead.next;
        
        if(head.val%2==0){
        	eventmp.next=oddHead;
        	return evenHead;
        }
        oddtmp.next=evenHead;
    	return oddHead;
    }
	
	public ListNode oddEvenListByNode(ListNode head) {
        if(head==null)
            return null;
        ListNode oddHead=new ListNode(0);
        ListNode evenHead=new ListNode(0);
        ListNode tmp=head,oddtmp=oddHead,eventmp=evenHead;
        int i=1;
        while(tmp!=null){
            if(i%2==0){
                eventmp.next=tmp;
                eventmp=eventmp.next;
            }else{
                oddtmp.next=tmp;
                oddtmp=oddtmp.next;
            }
            tmp=tmp.next;
        }
        eventmp.next=null;
        oddtmp.next=null;
        oddHead=oddHead.next;
        evenHead=evenHead.next;
        
        oddtmp.next=evenHead;
    	return oddHead;
    }
	
	public static void main(String[] args) {
		ListNode list=new ListNode(1);
		list.next=new ListNode(2);
		list.next.next=new ListNode(3);
		list.next.next.next=new ListNode(4);
		list.next.next.next.next=new ListNode(5);
		
		OddEvenLinkedList obj=new OddEvenLinkedList();
		ListNode.printList(obj.oddEvenListByNode(list));
	}

}
