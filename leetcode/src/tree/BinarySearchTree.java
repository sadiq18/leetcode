package tree;

import java.util.Random;

public class BinarySearchTree {
	
	Tree root;
	
	public BinarySearchTree(){
		root=null;
	}
	
	public void insert(int val) {
		if(root==null) {
			root=new Tree(val);
			return;
		}
		Tree temp=root;
		Tree prev=null;
		while(temp!=null) {
			prev=temp;
			if(temp.val<=val)
				temp=temp.right;
			else
				temp=temp.left;
		}
		if(prev.val<=val)
			prev.right=new Tree(val);
		else
			prev.left=new Tree(val);
	}

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6};
		BinarySearchTree tree=new BinarySearchTree();
		for(int i=0;i<arr.length;i++) {
			int val=arr[new Random().nextInt(arr.length)];
			System.out.print(val+" ");
			tree.insert(val);
		}
		System.out.println();
		TreeTraversal.inorder(tree.root);
	}
}
