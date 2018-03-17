package com.sample;

import java.util.*;

public class T1 {

	static String timeConversion(String s) {
        // Complete this function
        String time = s.substring(s.length()-2);
        String rest = s.substring(0,s.length()-2);
        if("AM".equals(time)) {
        	int hour = Integer.parseInt(rest.substring(0,2));
            return hour == 12 ? "00" + rest.substring(2): rest;
        }
        else {
            int hour = Integer.parseInt(rest.substring(0,2));
            return ((hour + 12) == 24 ? "12" : (hour+12)) + rest.substring(2);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
