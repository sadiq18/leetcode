package tree;

public class IsTreeBST {
	
	boolean isBST(Tree root,int min,int max) {
		if(root==null)
			return true;
		if(!(root.val>min && root.val<max)) {
			return false;
		}
		return isBST(root.left,min,root.val) && isBST(root.right,root.val,max);
	}

	public static void main(String[] args) {
		Tree root=new Tree(11);
		root.left=new Tree(9);
		root.right=new Tree(14);
		root.left.right=new Tree(10);
		root.right.left=new Tree(13);
		root.right.right=new Tree(15);
		
		IsTreeBST isTreeBST=new IsTreeBST();
		System.out.println(isTreeBST.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}

}
