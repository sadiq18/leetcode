package tree;

public class Tree {
	int val;
	Tree left;
	Tree right;
	
	public Tree(int val) {
		this.val=val;
		left=null;
		right=null;
	}
	
	public static int height(Tree root) {
		if(root==null)
			return 0;
		int left=height(root.left);
		int right=height(root.right);
		return 1+Math.max(left, right);
	}
	
	public static int size(Tree root) {
		if(root==null)
			return 0;
		int left=size(root.left);
		int right=size(root.right);
		return 1+left+right;
	}
	
	public static void inorder(Tree tree) {
		if(tree==null) 
			return;
		inorder(tree.left);
		System.out.println(tree.val);
		inorder(tree.right);
	}
	
	public static void preorder(Tree tree) {
		if(tree==null) 
			return;
		System.out.println(tree.val);
		preorder(tree.left);
		preorder(tree.right);
	}
	
	public static void postorder(Tree tree) {
		if(tree==null) 
			return;
		postorder(tree.left);
		postorder(tree.right);
		System.out.println(tree.val);
	}
	
}
