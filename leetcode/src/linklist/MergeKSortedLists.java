package linklist;

public class MergeKSortedLists {

	/**
	 * @param args
	 */
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	int getMinIndex(ListNode[] lists){
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null && lists[i].val<=min){
                min=lists[i].val;
                index=i;
            }
        }
        return index;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result=new ListNode(0);
        ListNode tmp=result;
        int index=getMinIndex(lists);
        while(index!=-1){
            tmp.next=lists[index];
            lists[index]=lists[index].next;
            tmp=tmp.next;
            index=getMinIndex(lists);
        }
        return result.next;
    }
    
    static void printList(ListNode head){
    	ListNode tmp=head;
		while(tmp!=null){
			System.out.print(tmp.val + " ");
			tmp=tmp.next;
		}
		System.out.println();
		
	}
    
	public static void main(String[] args) {
		// [[1,4,5],[1,3,4],[2,6]]
		ListNode[] lists=new ListNode[3];
		
		ListNode tmp=new ListNode(1);
		tmp.next=new ListNode(4);
		tmp.next.next=new ListNode(5);
		lists[0]=tmp;
		
		tmp=new ListNode(1);
		tmp.next=new ListNode(3);
		tmp.next.next=new ListNode(4);
		lists[1]=tmp;
		
		tmp=new ListNode(2);
		tmp.next=new ListNode(6);
		lists[2]=tmp;
		
		MergeKSortedLists obj=new MergeKSortedLists();
		printList(obj.mergeKLists(lists));
	}

}
