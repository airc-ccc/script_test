package com.justdoit;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        int x = 16;
        System.out.println(longestPalindrome());
    }


    public static int reverse(int x) {
        if (x == 0) {
            return x;
        }
        String x_str = String.valueOf(x);
        StringBuilder res = new StringBuilder();
        x_str.lines().forEach(res::append);
        res.reverse();
        char code = res.charAt(res.length() - 1);
        if (code == '-') {
            res.delete(res.length() - 1, res.length());
            res.insert(0, "-");
        }
        String resStr = res.toString();
        long resLong = Long.parseLong(resStr);
        if (Integer.MIN_VALUE <= resLong && resLong <= Integer.MAX_VALUE) {
            return Integer.parseInt(resStr);
        }
        return 0;
    }


	/**
	 * 回文数
	 */
	public static boolean palindromeNumber(int x) {
        int stX = x;
        if (x < 10) {
            return false;
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (x != 0) {
            res.push(x % 10);
            x = x / 10;
        }
        int mid = 0;
        for (int i = res.size(); i >= 1; i--) {
            Integer arg = res.get(i - 1);
            if (arg != -1) {
                if (mid == 0) {
                    mid = mid + arg;
                } else {
                    mid = mid * 10 + arg;
                }
            }
        }
        return stX == mid;
    }



	/**
	 * 回文数第二种解法
	 */
	public static boolean palindromeNumberTwo(int x) {

		if (x == 0 || x < 10) {
			return false;
		}
		int origin_x = x;
		int rem = 0;
		while(x != 0) {
			rem = rem * 10 + x % 10;	
			x = x / 10;
		}		
		return origin_x == rem;
	}



	public static boolean isPowerOfFour(int n) {
		// n 必须大于0
		// n 必须大于0
		return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
	}


	public static String longestPalindrome() {
	    String s = "aaf";
	    int sLen = s.length();
        StringBuilder longestX = new StringBuilder();
		StringBuilder longestY = new StringBuilder();
		int i = 0;
		while(i < sLen) {
            for (char c : s.toCharArray()) {
                longestX.append(String.valueOf(c));
                String oldLongest = longestX.toString();
                String newLongest = longestX.reverse().toString();
                if (newLongest.equals(oldLongest) && longestX.length() > longestY.length()) {
                    // Is palindrome
                    longestY = longestX;
                    longestX = new StringBuilder();
                } else {
                    longestX.reverse();
                }
            }
            longestX = new StringBuilder();
            StringBuilder new_s = new StringBuilder(s);
            new_s.delete(0, 1);
            s = new_s.toString();
            i++;
        }
        return String.valueOf(longestY);
	}
}
