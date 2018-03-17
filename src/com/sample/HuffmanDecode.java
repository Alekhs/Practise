package com.sample;

public class HuffmanDecode {

	static void decode(String S, CharNode root) {
		CharNode temp = root;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '0')
				temp = temp.left;
			if (c == '1')
				temp = temp.right;
			
			if (temp.left == null && temp.right == null) {
				System.out.print(temp.data);
				temp = root;
			}
		}
	}
	
	public static void main(String[] args) {
		CharNode root = new CharNode();
		root.frequency = -1;
		root.data = '*';
		root.left = new CharNode();
		root.left.frequency = 0;
		root.left.data = '*';
		root.right = new CharNode();
		root.right.frequency = 1;
		root.right.data = 'A';
		root.left.left = new CharNode();
		root.left.left.frequency = 0;
		root.left.left.data = 'B';
		root.left.right = new CharNode();
		root.left.right.frequency = 1;
		root.left.right.data = 'C';
		
		decode("1001011", root);
	}

}
