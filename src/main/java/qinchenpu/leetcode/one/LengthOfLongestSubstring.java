package qinchenpu.leetcode.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 题号：3. 给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度。 示例 1: 输入: s = "abcabcbb", 输出: 3 
 * @Description 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 * @Project leetcode
 * @File LongestPalindrome.java
 * @Date 2021年2月8日
 * @Author_CopyRight qinchenpu
 */
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		System.out.println(soulutionTwo("abcabcbbdce"));
		System.out.println(soulutionTwo("pwwkew"));
		System.out.println(soulutionTwo("abcadebcdbba"));
		System.out.println(soulutionTwo("abcd"));
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	private static int soulutionTwo(String str) {
		/*
		 * 将HashMap换成整型数组，字符转换成数字后，将其最近位置存进数组，存储空间占用更少
		 * int[] last = new int[128]; for (int i = 0; i < 128; i++) { last[i] = -1; }
		 */

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int length = 0;
		for (int i = 0; i < str.length(); i++) {
			Character key = str.charAt(i);
			if (map.containsKey(key)) {
				start = Math.max(start, map.get(key) + 1);
			}
			length = Math.max(length, i - start + 1);
			map.put(key, i);

		}
		return length;
	}

	/**
	 * 滑动窗口
	 * 
	 * @param str
	 * @return
	 */
	public static int soulutionOne(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int count = 1;
		int temp = 1;
		String tempStr = "" + str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			// 判断字符是否已存在与窗口
			int index = tempStr.indexOf(str.charAt(i));
			if (index < 0) {
				tempStr += str.charAt(i);
				temp++;
			} else {
				count = count > temp ? count : temp;
				if (index == tempStr.length() - 1) {
					tempStr = "" + str.charAt(i);
				} else {
					tempStr = tempStr.substring(index + 1, tempStr.length()) + str.charAt(i);
				}
				temp = tempStr.length();
			}
		}

		count = count > temp ? count : temp;
		return count;
	}

}
