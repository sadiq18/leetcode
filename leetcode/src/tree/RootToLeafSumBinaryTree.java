package tree;

import java.util.ArrayList;

public class RootToLeafSumBinaryTree {
	
	boolean isSumRootToLeaf(Tree root,int sum,ArrayList<Integer> result) {
		if(root==null) {
			return false;
		}
		if(root.left==null && root.right==null) {
			if(root.val==sum) {
				result.add(root.val);
				return true;
			}
			return false;
		}
		if(isSumRootToLeaf(root.left,sum-root.val,result)) {
			result.add(root.val);
			return true;
		}
		
		if(isSumRootToLeaf(root.right,sum-root.val,result)) {
			result.add(root.val);
			return true;
		}
		
		return  false;
	}

	public static void main(String[] args) {
		Tree root=new Tree(10);
		root.left=new Tree(16);
		root.right=new Tree(5);
		root.left.right=new Tree(-3);
		root.right.left=new Tree(6);
		root.right.right=new Tree(11);
		
		RootToLeafSumBinaryTree rootToLeafSumBinaryTree=new RootToLeafSumBinaryTree();
		
		ArrayList<Integer> result=new ArrayList<>();
		System.out.println(rootToLeafSumBinaryTree.isSumRootToLeaf(root, 26, result));
		for(int i : result)
			System.out.println(i);

	}

}
