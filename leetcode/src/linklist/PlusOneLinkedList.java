package linklist;

public class PlusOneLinkedList {

	/**
	 * @param args
	 */
	
	/**static Node plusOneInList(Node head,int val){
		if(head == null)
			return null;
		int sum=head.val + val;
		head.next=plusOneInList(head.next,sum/10);
		head.val;
		
	}*/
	
	Node reverse(Node head){
		Node prev=null,tmp=null;
		while(head!=null){
			tmp=head.next;
			head.next=prev;
			prev=head;
			head=tmp;
		}
		return prev;
	}
	
	Node plusOneInList(Node head){
		Node head2=reverse(head);
		Node tmp=head2;
		int val=1;
		while(tmp!=null){
			int sum=tmp.val+val;
			tmp.val=sum%10;
			val=sum/10;
			if(val==0)
				break;
			tmp=tmp.next;
		}
		head=reverse(head2);
		if(val!=0){
			Node newNode=new Node(val);
			newNode.next=head;
			head=newNode;
		}
		return head;
	}
	
	void printList(Node head){
		Node tmp=head;
		while(tmp!=null){
			System.out.print(tmp.val + " ");
			tmp=tmp.next;
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		PlusOneLinkedList obj=new PlusOneLinkedList();
		Node head=new Node(9);
		head.next=new Node(9);
		head.next.next=new Node(9);
		obj.printList(head);
		//obj.printList(obj.reverse(head));
		obj.printList(obj.plusOneInList(head));
	}

}
