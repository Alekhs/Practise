package com.sample;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsing2Stacks {

	Stack<Integer> st1 = new Stack<>();
	Stack<Integer> st2 = new Stack<>();

	void insert(int ele) {
		st1.push(ele);
	}

	int remove() {
		if (st1.empty() && st2.empty())
			return -1;

		if (st2.empty())
			while (!st1.empty())
				st2.push(st1.pop());

		return st2.pop();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for (int t = 1; t <= tests; t++) {
			int N = sc.nextInt();
			QueueUsing2Stacks queue = new QueueUsing2Stacks();
			while (N-- > 0) {
				int operation = sc.nextInt();
				if (operation == 1) {
					queue.insert(sc.nextInt());
				} else if (operation == 2) {
					System.out.print(queue.remove() + " ");
				}
			}
		}
		sc.close();
	}

}