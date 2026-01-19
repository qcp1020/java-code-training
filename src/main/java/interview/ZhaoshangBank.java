package interview;

import java.util.Arrays;

public class ZhaoshangBank {

	public static void main(String[] args) throws Exception {
		int[] arrA = { -1, 3, 9 };
		int K = 6;
		int[] arr = tranArr(arrA, K);
		System.out.println(Arrays.toString(arr));

		int[] nums = { 1, 3, 5, 2, 4 };
		int[] values = { 1, 2, 3, 4, 5 };
		int result = getMaxValue(nums, values);
		System.out.println(result);

//		String str = "若存在着多组结果";
		String str = "abcdefgh";
		System.out.println(str.length());
		System.out.println(str.getBytes("UTF-8").length);
	}

	public static int getMaxValue(int[] nums, int[] values) {
		if (nums.length == 1) {
			return nums[0] * values[0];
		}
		int result = 0;
		int start = 0;
		int end = nums.length - 1;
		for (int i = 0; i < values.length - 1; i++) {
			int a = values[i];
			int b = values[i + 1];
			if (nums[start] * a + nums[end] * b < nums[end] * a + nums[start] * b) {
				result += nums[end] * a;
				end--;
			} else {
				result += nums[start] * a;
				start++;

			}
			if (i == values.length - 2) {
				result += b * nums[end];
			}
		}
		return result;
	}

	/**
	 * 给定一个数组arrA 和一个整数K，令数组每个元素加上任一[-K, K]的整数，得到另一个数组arrB, 使得
	 * arrB的最大值max与最小值min差值最小，返回max与min；若存在着多组结果，则返回两者和最小的情况。 例：1. arrA = { -1, 3,
	 * 9} ，K = 6 ，结果为{4,4}；2. arrA = { 1, 8 } ，K = 3 ，结果为{4,5}。
	 * 
	 * @Author qinchenpu
	 * @Date 2021年3月28日
	 * @ReturnType int[]
	 */
	public static int[] tranArr(int[] arrA, int K) {
		int[] result = new int[2];
		if (arrA.length == 1) {
			result[0] = arrA[0];
			result[1] = arrA[0];
		} else {
			int max = arrA[0];
			int min = arrA[0];
			for (int num : arrA) {
				max = num > max ? num : max;
				min = num < min ? num : min;
			}
			int decNum = max - min;
			if (decNum <= K * 2) {
				result[0] = min + decNum / 2;
				result[1] = max - decNum / 2;
			} else {
				result[0] = min + K;
				result[1] = max - K;
			}
		}
		return result;
	}

}
