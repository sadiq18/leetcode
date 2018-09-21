package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	public void levelOrderTraversal(Tree root) {
		if(root==null)
			return;
		
		Queue<Tree> queue=new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Tree temp=queue.poll();
			System.out.println(temp.val);
			if(temp.left!=null) 
				queue.offer(temp.left);
			if(temp.right!=null)
				queue.offer(temp.right);
		}
	}
	public static void main(String[] args) {
		Tree root=new Tree(11);
		root.left=new Tree(9);
		root.right=new Tree(14);
		root.left.right=new Tree(10);
		root.right.left=new Tree(13);
		root.right.right=new Tree(15);
		
		new LevelOrderTraversal().levelOrderTraversal(root);

	}

}
