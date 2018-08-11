package linklist;

import java.util.Stack;

public class AddTwoNumbersII {

	/**
	 * @param args
	 */
	public int getValue(Stack<ListNode> stack){
		if(stack.isEmpty())
			return 0;
		return stack.pop().val;
	}
	
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
	 public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		 Stack<ListNode> stackL1=new Stack<>();
		 Stack<ListNode> stackL2=new Stack<>();
		 
		 while(l1 != null){
			 stackL1.add(l1);
			 l1=l1.next;
		 }
		 
		 while(l2 != null){
			 stackL2.add(l2);
			 l2=l2.next;
		 }
		 
		 int carry=0;
		 ListNode result=null,resultNext=null;
		 while(!stackL1.isEmpty() || !stackL2.isEmpty()){
			 int sum=getValue(stackL1)+getValue(stackL2)+carry;
			 carry=sum/10;
			 result=new ListNode(sum%10);
			 result.next=resultNext;
			 resultNext=result;
		 }
		 
		 if(carry>0){
			 result=new ListNode(carry);
			 result.next=resultNext;
			 resultNext=result; 
		 }
		 return result;
	 }
	 
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 l1=reverse(l1);
		 l2=reverse(l2);
		 int carry=0;
		 ListNode result=null,resultNext=null;
		 while(l1!=null && l2!=null){
			 int sum=l2.val+l1.val+carry;
			 l1=l1.next;
			 l2=l2.next;
			 carry=sum/10;
			 result=new ListNode(sum%10);
			 result.next=resultNext;
			 resultNext=result;
		 }
		 while(l1!=null){
			 int sum=l1.val+carry;
			 l1=l1.next;
			 carry=sum/10;
			 result=new ListNode(sum%10);
			 result.next=resultNext;
			 resultNext=result;
		 }
		 while(l2!=null){
			 int sum=l2.val+carry;
			 l2=l2.next;
			 carry=sum/10;
			 result=new ListNode(sum%10);
			 result.next=resultNext;
			 resultNext=result;
		 }
		 
		 if(carry>0){
			 result=new ListNode(carry);
			 result.next=resultNext;
			 resultNext=result; 
		 }
		 return result;
	 }
	 
	 
	public static void main(String[] args) {
		ListNode l1=new ListNode(7);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(4);
		l1.next.next.next=new ListNode(3);
		
		ListNode l2=new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(4);
		
		ListNode.printList(new AddTwoNumbersII().addTwoNumbers(l1, l2));
	}

}
