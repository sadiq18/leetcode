package tree;

import java.util.Stack;

public class IterativePostorderTraversalOfBinaryTree {
	public void postorderIterative(Tree root) {
		if(root==null)
			return;
		Stack<Tree> stack1=new Stack<>();
		stack1.push(root);
		Stack<Integer> stack2=new Stack<>();
		
		while(!stack1.isEmpty()) {
			Tree tmp=stack1.pop();
			stack2.push(tmp.val);
			
			if(tmp.left!=null)
				stack1.push(tmp.left);
			if(tmp.right!=null)
				stack1.push(tmp.right);
		}
		
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop()+" ");
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
		
		new IterativePostorderTraversalOfBinaryTree().postorderIterative(root);

	}

}
