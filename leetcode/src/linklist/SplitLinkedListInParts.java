package linklist;

public class SplitLinkedListInParts {

	/**
	 * @param args
	 */
	ListNode getSliceOflist(ListNode head,int slice){
		if(head==null || slice==0)
			return null;
		ListNode prev=null;
		while(head!=null && slice>0){
			prev=head;
			head=head.next;
			slice--;
		}
		if(prev!=null){
			prev.next=null;
		}
		return head;
	}
	
	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] result=new ListNode[k];
        int length=ListNode.length(root);
        int size=length/k;
        int remains=length%k;
        
        ListNode tmp=root;
        for(int i=0;i<k;i++){
        	result[i]=tmp;
        	tmp=getSliceOflist(tmp,size+(remains>0?1:0));
        	remains--;
        }
        return result;
    }
	public static void main(String[] args) {
		ListNode list=new ListNode(1);
		list.next=new ListNode(2);
		list.next.next=new ListNode(3);
		
		SplitLinkedListInParts obj=new SplitLinkedListInParts();
		ListNode[] result=obj.splitListToParts(list,5);
		for(int i=0;i<result.length;i++){
			ListNode.printList(result[i]);
		}
	}
}
