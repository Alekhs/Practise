package com.sample;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	static void printLevelOrderTraversal(TreeNode tree) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(tree);
		
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			System.out.print(temp.data + " ");
			
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
	}
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.left.right = new TreeNode(5);
		tree.right.right = new TreeNode(6);
		
		printLevelOrderTraversal(tree);
	}

}
