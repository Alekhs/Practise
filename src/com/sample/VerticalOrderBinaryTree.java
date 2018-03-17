package com.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Values {
	int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
}

public class VerticalOrderBinaryTree {
	
	static void findMinMax(TreeNode tree, Values min, Values max, int dist) {
		if(tree == null)
			return;
		
		if(dist > max.max)
			max.max = dist;
		if(dist < min.min)
			min.min = dist;
		findMinMax(tree.left, min, max, dist-1);
		findMinMax(tree.right, min, max, dist+1);
	}
	
	static void getVerticalOrderTree(TreeNode tree, Map<Integer, List<Integer>> map, int pos) {
		if(tree == null)
			return;
		
		List<Integer> list = map.get(pos);
		if(list == null) {
			list = new ArrayList<>();
			map.put(pos, list);
		}
		list.add(tree.data);
		getVerticalOrderTree(tree.left, map, pos - 1);
		getVerticalOrderTree(tree.right, map, pos + 1);
	}
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(15);
		tree.left = new TreeNode(14);
		tree.left.left = new TreeNode(1);
		tree.left.right = new TreeNode(7);
		tree.left.right.left = new TreeNode(4);
		tree.left.right.left.left = new TreeNode(3);
		tree.left.right.left.left.right = new TreeNode(9);
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		getVerticalOrderTree(tree, map, 0);
		
		Values val = new Values();
		findMinMax(tree, val, val, 0);
		for(int i = val.min; i <= val.max; i++) {
			for(int data : map.get(i))
				System.out.print(data + " ");
			System.out.print("$");
		}
	}

}
