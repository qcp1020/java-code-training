package qinchenpu.leetcode.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 题号：1. 给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
 * @Description 解释：假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * @Project leetcode
 * @File LongestPalindrome.java
 * @Date 2021年2月8日
 * @Author_CopyRight qinchenpu
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 18;
		System.out.println(Arrays.toString(soulutionOne(nums, target)));
	}

	public static int[] soulutionOne(int[] nums, int target) {
		int[] arr = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int key = target - nums[i];
			if (map.get(key) != null) {
				arr[0] = map.get(key);
				arr[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		return arr;
	}

}
