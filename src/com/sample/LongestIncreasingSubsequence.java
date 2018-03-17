package com.sample;

import java.util.ArrayList;
import java.util.List;

class LongestIncreasingSubsequence {
	/*
	 * lis() returns the length of the longest increasing subsequence in arr[] of
	 * size n
	 */
	static int lis_count(int arr[], int n) {
		int lis[] = new int[n];
		int i, j, max = 0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++)
			lis[i] = 1;

		/* Compute optimized LIS values in bottom up manner */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;

		/* Pick maximum of all LIS values */
		for (i = 0; i < n; i++)
			if (max < lis[i])
				max = lis[i];

		return max;
	}

	static List<Integer> lis(List<Integer> sequence) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> inList = new ArrayList<>();
		list.add(inList);
		inList.add(sequence.get(0));
		int max = 1, result = 0;

		for (int i = 1; i < sequence.size(); i++) {
			list.add(i, new ArrayList<Integer>());
			for (int j = 0; j < i; j++) {
				if (sequence.get(i) > sequence.get(j) && list.get(i).size() < list.get(j).size() + 1) {
					//list.get(i).replaceAll(list.get(j)); 
					List<Integer> l = new ArrayList<>();
					l.addAll(list.get(j));
					list.set(i, l);
				}
			}
			list.get(i).add(sequence.get(i));
			int size = list.get(i).size();
			if (max <= size) {
				max = size;
				result = i;
			}
		}

		return list.get(result);
	}

	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("Length of lis is " + lis_count(arr, n));

		List<Integer> input = new ArrayList<>();
		input.add(10);
		input.add(22);
		input.add(9);
		input.add(33);
		input.add(21);
		input.add(50);
		input.add(41);
		input.add(60);
		List<Integer> list = lis(input);
		for(Integer item : list) {
			System.out.print(item + " ");
		}
	}
}