package com.sample;

public class TopViewBinaryTree1 {
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.right = new TreeNode(14);
		tree.right.left = new TreeNode(3);
		tree.right.right = new TreeNode(15);
		tree.right.left.left = new TreeNode(2);
		tree.right.left.right = new TreeNode(7);
		tree.right.left.right.left = new TreeNode(4);
		tree.right.left.right.right = new TreeNode(13);
		tree.right.left.right.left.right = new TreeNode(5);
		tree.right.left.right.left.right.left = new TreeNode(8);
		tree.right.left.right.left.right.right = new TreeNode(6);
		tree.right.left.right.left.right.left.right = new TreeNode(9);
		tree.right.left.right.right.left = new TreeNode(10);
		tree.right.left.right.right.left.right = new TreeNode(11);
		tree.right.left.right.right.left.right.right = new TreeNode(12);
		
		top_view(tree);		
	}
	
	static void goLeft(TreeNode node) {
	    if(node.left != null) {
	        goLeft(node.left);
	    }
	    System.out.print(node.data + " ");
	}

	static void goRight(TreeNode node) {
	    System.out.print(node.data + " ");
	    
	    if(node.right != null) {
	        goRight(node.right);
	    }
	}

	static void top_view(TreeNode root) {
	    if(root.left != null) {
	        goLeft(root.left);
	    }
	    
	    System.out.print(root.data + " ");
	    
	    if(root.right != null) {
	        goRight(root.right);
	    }
	}

}
