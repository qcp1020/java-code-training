package qinchenpu.leetcode;

/**
 * @Description 题号：9. 给你一个整数 x ，如果x是一个回文整数，返回ture ；否则返回false
 * @Description 解释: 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121是回文，而123不是。
 * @Project leetcode
 * @File LongestPalindrome.java
 * @Date 2021年3月4日
 * @Author_CopyRight qinchenpu
 */
class SmallestPowersOfTwo {

	public static void main(String[] args) {
		System.out.println(soulutionOne(121));
		System.out.println(soulutionTwo(5));
	}

	private static int soulutionOne(int i) {
		int n = i | (i >>> 1);
		n |= (n >>> 2);
		n |= (n >>> 4);
		n |= (n >>> 8);
		n |= (n >>> 16);
		return n < 0 ? 0 : n + 1;
	}

	private static int soulutionTwo(int i) {
		String str = Integer.toBinaryString(i);
		return Integer.valueOf(str.replace('0', '1'), 2) + 1;
	}
}
