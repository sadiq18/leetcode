package linklist;

public class RemoveDuplicatesFromSortedListII {
	
	public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp=head,prev=null,lastNode=null,start=null;
        boolean isDuplicate=false;
        while(tmp!=null){
            start=tmp;
            prev=tmp;
            tmp=tmp.next;
            isDuplicate=false;
            while(tmp!=null &&  tmp.val==start.val){
                isDuplicate=true;
                tmp=tmp.next;
            }
            if(isDuplicate){
                if(lastNode==null){
                    head=tmp;
                }else{
                    lastNode.next=tmp;
                }
            }else{
                lastNode=prev;
            }
        }
        return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
