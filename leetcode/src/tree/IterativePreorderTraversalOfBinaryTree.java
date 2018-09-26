package tree;

import java.util.Stack;

public class IterativePreorderTraversalOfBinaryTree {
	public void inroderIterative(Tree root) {
		if(root==null)
			return;
		Stack<Tree> stack=new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Tree tmp=stack.pop();
			System.out.print(tmp.val+" ");
			if(tmp.right!=null)
				stack.push(tmp.right);
			if(tmp.left!=null)
				stack.push(tmp.left);
		}
		System.out.println();
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
		
		new IterativePreorderTraversalOfBinaryTree().inroderIterative(root);

	}

}
