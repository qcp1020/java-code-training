package qinchenpu.nowcoder.BM;

import java.util.Arrays;

/**
 * @author qinchenpu
 * @project java-code-training
 * @Date 2026/10/13
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BM20 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(arr));
        Arrays.sort(arr);
        int[] nums = Arrays.copyOf(arr, arr.length);

    }

    public static int InversePairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    result++;
                }
            }
        }
        return result;
    }
}
