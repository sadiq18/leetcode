package tree;

public class TreeSize {
	
	public int size(Tree root) {
		if(root==null)
			return 0;
		int left=size(root.left);
		int right=size(root.right);
		return 1+left+right;
	}
	public static void main(String[] args) {
		TreeSize ts=new TreeSize();
		Tree root1=new Tree(11);
		root1.left=new Tree(15);
		root1.right=new Tree(18);
		root1.right.left=new Tree(21);
		
		Tree root2=new Tree(11);
		root2.left=new Tree(15);
		root2.right=new Tree(18);
		
		System.out.println(ts.size(root1));
		System.out.println(ts.size(root2));
	}

}
