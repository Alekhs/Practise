package com.sample;

import java.awt.PageAttributes.PrintQualityType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class QItem
{
   TreeNode node;
   int hd;
   public QItem(TreeNode n, int h)
   {
        node = n;
        hd = h;
   }
}

public class TopViewBinaryTree {
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(15);
		tree.left = new TreeNode(14);
		tree.left.left = new TreeNode(1);
		tree.left.right = new TreeNode(7);
		tree.left.right.left = new TreeNode(4);
		tree.left.right.right = new TreeNode(20);
		tree.left.right.left.left = new TreeNode(3);
		tree.left.right.left.left.right = new TreeNode(9);
		
		printTopView(tree);		
	}

	static void printTopView(TreeNode root) {
		// base case
		if (root == null) {
			return;
		}

		Map<Integer, Integer> map = new HashMap<>();
		Queue<QItem> Q = new LinkedList<QItem>();
		Q.add(new QItem(root, 0)); // Horizontal distance of root is 0

		// Standard BFS or level order traversal loop
		while (!Q.isEmpty()) {
			QItem qi = Q.remove();
			int hd = qi.hd;
			TreeNode node = qi.node;

			if (!map.containsKey(hd)) {
				map.put(hd, node.data);
			}

			if (node.left != null)
				Q.add(new QItem(node.left, hd - 1));
			if (node.right != null)
				Q.add(new QItem(node.right, hd + 1));
		}
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int item : map.keySet()) {
			if(item > max)
				max = item;
			if(item < min)
				min = item;
		}
		
		for(int i = min; i <= max; i++) {
			System.out.print(map.get(i) + " ");
		}
	}

}
