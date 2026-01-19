
package qinchenpu.leetcode.one;

/**
 * @Description 题号：5. 给你一个字符串 s，找到 s 中最长的回文子串
 * @Project leetcode
 * @File LongestPalindrome.java
 * @Date 2021年2月8日
 * @Author_CopyRight qinchenpu
 */
public class LongestPalindrome {

	/**
	 * @Author qinchenpu
	 * @Date 2021年2月8日
	 * @ReturnType void
	 */
	public static void main(String[] args) {
		System.out.println(soulutionOne("babad"));
	}

	public static String soulutionOne(String s) {
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int index = s.lastIndexOf(ch);
			String tempStr = s.substring(i, index + 1);
			if (isPalindromeStr(tempStr)) {
				return tempStr;
			}
		}
		return "";
	}

	private static boolean isPalindromeStr(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
