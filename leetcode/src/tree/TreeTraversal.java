package tree;

public class TreeTraversal {
	
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
	
	public static void main(String[] args) {
		

	}

}
