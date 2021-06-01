package com.justdoit;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        int x = 16;
		// String s = "whdqcudjpisufnrtsyupwtnnbsvfptrcgvobbjglmpynebblpigaflpbezjvjgbmofejyjssdhbgghgrhzuplbeptpaecfdanhlylgusptlgobkqnulxvnwuzwauewcplnvcwowmbxxnhsdmgxtvbfgnuqdpxennqglgmspbagvmjcmzmbsuacxlqfxjggrwsnbblnnwisvmpwwhomyjylbtedzrptejjsaiqzprnadkjxeqfdpkddmbzokkegtypxaafodjdwirynzurzkjzrkufsokhcdkajwmqvhcbzcnysrbsfxhfvtodqabvbuosxtonbpmgoemcgkudandrioncjigbyizekiakmrfjvezuzddjxqyevyenuebfwugqelxwpirsoyixowcmtgosuggrkdciehktojageynqkazsqxraimeopcsjxcdtzhlbvtlvzytgblwkmbfwmggrkpioeofkrmfdgfwknrbaimhefpzckrzwdvddhdqujffwvtvfyjlimkljrsnnhudyejcrtrwvtsbkxaplchgbikscfcbhovlepdojmqybzhbiionyjxqsmquehkhzdiawfxunguhqhkxqdiiwsbuhosebxrpcstpklukjcsnnzpbylzaoyrmyjatuovmaqiwfdfwyhugbeehdzeozdrvcvghekusiahfxhlzclhbegdnvkzeoafodnqbtanfwixjzirnoaiqamjgkcapeopbzbgtxsjhqurbpbuduqjziznblrhxbydxsmtjdfeepntijqpkuwmqezkhnkwbvwgnkxmkyhlbfuwaslmjzlhocsgtoujabbexvxweigplmlewumcone";
        System.out.println(longestPalindrome());
        // System.out.println(longestPalindromeHaha(s));
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
	    String s = "whdqcudjpisufnrtsyupwtnnbsvfptrcgvobbjglmpynebblpigaflpbezjvjgbmofejyjssdhbgghgrhzuplbeptpaecfdanhlylgusptlgobkqnulxvnwuzwauewcplnvcwowmbxxnhsdmgxtvbfgnuqdpxennqglgmspbagvmjcmzmbsuacxlqfxjggrwsnbblnnwisvmpwwhomyjylbtedzrptejjsaiqzprnadkjxeqfdpkddmbzokkegtypxaafodjdwirynzurzkjzrkufsokhcdkajwmqvhcbzcnysrbsfxhfvtodqabvbuosxtonbpmgoemcgkudandrioncjigbyizekiakmrfjvezuzddjxqyevyenuebfwugqelxwpirsoyixowcmtgosuggrkdciehktojageynqkazsqxraimeopcsjxcdtzhlbvtlvzytgblwkmbfwmggrkpioeofkrmfdgfwknrbaimhefpzckrzwdvddhdqujffwvtvfyjlimkljrsnnhudyejcrtrwvtsbkxaplchgbikscfcbhovlepdojmqybzhbiionyjxqsmquehkhzdiawfxunguhqhkxqdiiwsbuhosebxrpcstpklukjcsnnzpbylzaoyrmyjatuovmaqiwfdfwyhugbeehdzeozdrvcvghekusiahfxhlzclhbegdnvkzeoafodnqbtanfwixjzirnoaiqamjgkcapeopbzbgtxsjhqurbpbuduqjziznblrhxbydxsmtjdfeepntijqpkuwmqezkhnkwbvwgnkxmkyhlbfuwaslmjzlhocsgtoujabbexvxweigplmlewumcone";
	    int sLen = s.length();
        if (sLen < 2) {
            return s;
        }
        char[] sCharList = s.toCharArray();
        StringBuffer longestX = new StringBuffer();
		StringBuffer longestY = new StringBuffer();
        for (int i = 0; i < sLen; i++) {
            char[] sTwoCharList = s.toCharArray();
            for (char c2 : sTwoCharList) {
                longestX.append(c2);
                if (isPalinaStr(longestX) && longestX.length() > longestY.length()) {
                    String trLongest = longestX.toString();
                    longestY = new StringBuffer(trLongest);
                }
            }
            longestX = new StringBuffer();
            StringBuffer new_s = new StringBuffer(s);
            new_s.delete(0, 1);
            s = new_s.toString();
        }
        return longestY.toString();
	}
    

    public static boolean isPalinaStr(StringBuffer sb) {
        String oldLongest = sb.toString();
        StringBuffer newLongestX = new StringBuffer(oldLongest);
        String newLongest = newLongestX.reverse().toString();
        return oldLongest.equals(newLongest);
    }

    public static String longestPalindromeHaha(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }
    
    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}
