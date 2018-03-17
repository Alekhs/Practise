package com.sample;

public class InsertInBST {

	static TreeNode Insert(TreeNode root, int value) {
		TreeNode newNode = new TreeNode();
		newNode.data = value;
		
		TreeNode temp = root;
		if(temp == null) {
			return newNode;
		}
		if(value < temp.data)
			temp.left = Insert(temp.left, value);
		else
			temp .right = Insert(temp.right, value);
		
		return root;
	}

}
