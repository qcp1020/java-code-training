package qinchenpu.nowcoder.BM;

/**
 * @author qinchenpu
 * @project java-code-training
 * @Date 2026/10/20
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BM71 {
    public static void main(String[] args) {
        System.out.println(LIS(new int[]{6, 3, 1, 5, 2, 3, 7}));
    }

    public static int LIS(int[] arr) {
        // write code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = 1;
        int minMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > minMax) {
                dp[i] = max + 1;
            } else {
                dp[i] = dp[i - 1];
                minMax = arr[i];
            }
        }
        return 0;
    }
}
