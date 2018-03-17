package com.sample;

import java.util.Scanner;
import java.util.Stack;

public class NextLargestNumber {
	
	static void printArray(int[] arr, int n) {
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
	
	static void nextLargestNumber(Num[] arr, int n, int[] S) {
		Stack<Num> st = new Stack<>();
		st.push(arr[0]);
		
		for(int i = 1; i < n; i++) {
			Num next = arr[i];

			while(!st.empty()) {
				Num element = st.pop();

				if(next.data > element.data) {
					S[element.index] = next.data;
					//System.out.println(element + "-->" + next);
				}
				else {
					st.push(element);
					break;
				}
			}
			
			st.push(next);
		}
		
		while(!st.empty()) {
			//System.out.println(st.pop() + "-->-1");
			S[st.pop().index] = -1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for(int t = 1; t <= tests; t++) {
			int N = sc.nextInt();
			Num[] arr = new Num[N];
			for(int i = 0; i < N; i++) {
				arr[i] = new Num(sc.nextInt(), i); 
			}
			
			int[] S = new int[N];
			nextLargestNumber(arr, N, S);
			printArray(S, N);
			System.out.println();
		}
		sc.close();
	}

}

class Num {
	int data;
	int index;
	
	Num(int data, int index) {
		this.data = data;
		this.index = index;
	}
}
