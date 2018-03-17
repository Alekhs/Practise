package com.sample;

public class TreeOperations {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(5);
		tree.left.left = new TreeNode(1);
		tree.right.left = new TreeNode(4);
		tree.right.right = new TreeNode(6);
		tree.right.right.right = new TreeNode(7);

		System.out.println(height(tree));
	}

	static int height(TreeNode root) {
		// Write your code here.
		if (root == null  || (root.left == null && root.right == null))
			return 0;
		else {
			int lh = height(root.left);
			int rh = height(root.right);
			if (lh > rh)
				return lh + 1;
			else
				return rh + 1;
		}
	}

}
