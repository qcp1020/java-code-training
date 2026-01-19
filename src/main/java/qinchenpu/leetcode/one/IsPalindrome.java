package qinchenpu.leetcode.one;

/**
 * @Description 题号：9. 给你一个整数 x ，如果x是一个回文整数，返回ture ；否则返回false
 * @Description 解释: 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121是回文，而123不是。
 * @Project leetcode
 * @File LongestPalindrome.java
 * @Date 2021年2月8日
 * @Author_CopyRight qinchenpu
 */
public class IsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(soulutionOne(121));
		System.out.println(soulutionTwo(121));

	}

	/**
	 * 方法二的时间复杂度和空间复杂度均优于方法一
	 * @Author qinchenpu
	 * @Date 2021年2月8日
	 * @ReturnType boolean
	 */
	public static boolean soulutionTwo(int x) {
		if (x <0) {
			return false;
		}
		int a = 0;
		int b = x;
		do {
			a = a * 10 + b % 10;
			b = b / 10;
		} while (b > 0);
		return x == a;
	}

	public static boolean soulutionOne(int x) {
		String str = "" + x;
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
