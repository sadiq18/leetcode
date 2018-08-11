package linklist;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null)
            return head;
        int len=0;
        ListNode tmp=head,last=null;
        while(tmp!=null){
            len++;
            last=tmp;
            tmp=tmp.next;
        }
        int requireRotation=k%len;
        if(requireRotation==0)
            return head;
        int requireRotationFromStart=len-requireRotation;
        tmp=head;
        ListNode prev=null;
        for(int i=0;i<requireRotationFromStart;i++){
            prev=tmp;
            tmp=tmp.next;
        }
        prev.next=null;
        last.next=head;
        return tmp;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
