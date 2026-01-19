package interview;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class HongBao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(solution(100, 10)));

		BigDecimal[] arr = solution3(100, 10);
		System.out.println(Arrays.toString(arr));
		double sum = 0.0;
		for (BigDecimal bigDecimal : arr) {
			sum += bigDecimal.doubleValue();
		}
		System.out.println(sum);

	}

	public static int[] solution(int a, int b) {
		// 在这⾥写代码
		int[] result = new int[b];
		int tempSum = a;
		double limit = a * 9 / 10;
		for (int i = 0; i < b - 1; i++) {
			double num = tempSum * Math.random();
			if (i < b - 2) {
				while (num >= limit) {
					num = tempSum * Math.random();
				}
			} else {
				while (num >= limit || tempSum - num > limit) {
					num = tempSum * Math.random();
				}
			}
			result[i] = (int) Math.ceil(num);
			tempSum -= result[i];
		}
		result[b - 1] = (int) Math.ceil(tempSum);
		return result;
	}

	public static BigDecimal[] solution2(double a, int b) {
		// 在这⾥写代码
		BigDecimal[] result = new BigDecimal[b];
		double tempSum = a;
		double limit = a * 9 / 10;
		for (int i = 0; i < b - 1; i++) {
			double num = tempSum * Math.random();
			if (i < b - 2) {
				while (num >= limit) {
					num = tempSum * Math.random();
				}
			} else {
				while (num >= limit || tempSum - num > limit) {
					num = tempSum * Math.random();
				}
			}
			result[i] = new BigDecimal(num).setScale(2, RoundingMode.HALF_UP);
			tempSum -= num;
		}
		result[b - 1] = new BigDecimal(tempSum).setScale(2, RoundingMode.HALF_UP);
		return result;
	}

	public static BigDecimal[] solution3(double a, int b) {
		// 在这⾥写代码
		BigDecimal[] result = new BigDecimal[b];
		BigDecimal tempSum = new BigDecimal(a);
		BigDecimal limit = new BigDecimal(a * 9 / 10);
		for (int i = 0; i < b - 1; i++) {
			BigDecimal num = tempSum.multiply(new BigDecimal(Math.random())).setScale(2, RoundingMode.HALF_UP);
			if (i < b - 2) {
				while (num.compareTo(limit) >= 0
						|| tempSum.subtract(num).compareTo(new BigDecimal(0.01 * (b - i - 1))) < 0) {
					num = tempSum.multiply(new BigDecimal(Math.random())).setScale(2, RoundingMode.HALF_UP);
				}
			} else {
				while (num.compareTo(limit) >= 0 || tempSum.subtract(num).compareTo(new BigDecimal(0.01)) < 0) {
					num = tempSum.multiply(new BigDecimal(Math.random())).setScale(2, RoundingMode.HALF_UP);
				}
			}
			result[i] = num;
			tempSum = tempSum.subtract(num);
		}
		result[b - 1] = tempSum.setScale(2, RoundingMode.HALF_UP);
		return result;
	}

}
