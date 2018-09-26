package tree;

import java.util.Stack;

public class IterativeInorderTraversalOfBinaryTree {
	public void inorderIterative(Tree root) {
		if(root==null)
			return;
		Stack<Tree> stack=new Stack<>();
		Tree tmp=root;
		while(true) {
			if(tmp!=null) {
				stack.push(tmp);
				tmp=tmp.left;
			}else {
				if(stack.isEmpty()) 
					break;
				tmp=stack.pop();
				System.out.print(tmp.val+" ");
				tmp=tmp.right;
			}
		}
	}
	public static void main(String[] args) {
		Tree root=new Tree(1);
		root.left=new Tree(-2);
		root.right=new Tree(11);
		root.left.left=new Tree(-3);
		root.left.right=new Tree(3);
		root.left.right.right=new Tree(5);
		root.right.left=new Tree(21);
		root.right.right=new Tree(6);
		
		new IterativeInorderTraversalOfBinaryTree().inorderIterative(root);

	}

}
