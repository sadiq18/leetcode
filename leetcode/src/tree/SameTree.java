package tree;

public class SameTree {
	
	public boolean isSameTree(Tree root1,Tree root2) {
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		return root1.val==root2.val && isSameTree(root1.left,root2.left)
				&& isSameTree(root1.right,root2.right);
	}
	
	public static void main(String ... args) {
		Tree root1=new Tree(11);
		root1.left=new Tree(15);
		root1.right=new Tree(18);
		root1.right.left=new Tree(21);
		
		Tree root2=new Tree(11);
		root2.left=new Tree(15);
		root2.right=new Tree(18);
		
		System.out.println(new SameTree().isSameTree(root1, root2));
	}
}
