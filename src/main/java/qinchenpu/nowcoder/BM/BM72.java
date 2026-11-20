package qinchenpu.nowcoder.BM;

/**
 * @author qinchenpu
 * @project java-code-training
 * @Date 2026/10/19
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BM72 {
    public static void main(String[] args) {

    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        // write code here
        int max = array[0];
        int sum = array[0];
        for (int i = 0; i < array.length; i++) {
            sum = Math.max(sum + array[i], 0);
            max = Math.max(max, sum);
        }
        return max;
    }

}
