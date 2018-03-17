package com.sample;

import java.util.List;

public class Test {
	
	public static int jump_over_numbers(List<Integer> list) {
        // Write your code here

        int pos = 1;
        int size = list.size();
        if(list == null || list.isEmpty())
            return -1;
        
        int count = 0;
        while(true) {
            if(pos > size)
                return count;
            
            int ele = list.get(pos-1);
            if(ele == 0) {
                return -1;
            } else {
                pos = pos + ele;
                count++;
            }
        }
    }
	
	public static int digit_sum(long number) {
		// Write your code here
		long div = Math.abs(number), rem = 0;
		int sum = 0;
		while(div > 0) {
			rem = div%10;
			sum += rem;
			div = div/10;
		}
		return sum;
	}
	
	public static boolean is_numeric_palindrome(long number) {
		// Write your code here
		long div = number, rem = 0;
		long[] arr = new long[11];
		int index = 0;
		while(div > 0) {
			rem = div%10;
			arr[index++] = rem;
			div = div/10;
		}
		
		int low = 0, high = index - 1;
		while(low < high) {
			if(arr[low] != arr[high])
				return false;
			low++;
			high--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(is_numeric_palindrome(2334));
	}

}
