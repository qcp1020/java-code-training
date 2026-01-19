package qinchenpu.leetcode.one;

public class ReverseNum {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(-2147483648);
		System.out.println(soulutionOne(-2147483648));
	}

	public static int soulutionOne(int x) {
		long result = 0;
		long temp = x;
		
		while (temp / 10 != 0) {
			result = result * 10 + temp % 10;
			temp = temp / 10;
		}

		result = result * 10 + temp % 10;
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			result = 0;
		}
		return (int) result;
	}
}
