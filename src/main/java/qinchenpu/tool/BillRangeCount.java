package qinchenpu.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * E(5). 移动爱家 APP 账单区间统计
 *
 * 题意：给定 n 个月的账单流水 nums，统计有多少个连续子区间 [i..j]
 *       满足 lower <= 区间和 <= upper。
 *
 * 分析：设前缀和 S[0]=0, S[k]=nums[0..k-1] 之和，则区间 [i..j] (0<=i<j<=n) 的和
 *       为 S[j] - S[i]，问题转化为统计数对 (i, j)，i < j 且
 *       lower <= S[j] - S[i] <= upper。
 *
 *       暴力枚举 O(n^2) 在 n 较大时会超时（时限 1000MS），
 *       采用「归并排序 + 双指针」在归并过程中统计，时间复杂度 O(n log n)。
 *       归并后左半、右半均有序，对右半每个 j，用两个不回退指针 low/high
 *       在左半中定位满足 S[j]-S[i] in [lower, upper] 的 i 的个数。
 *
 * 复杂度：时间 O(n log n)；空间 O(n)。
 *
 * ACM 平台输入输出规范：
 *   输入：第一行 n lower upper；第二行 n 个整数。
 *   输出：一个整数，使用 StreamTokenizer/BufferedReader 快速读写。
 *   注意：前缀和与账单值用 long，防止累加溢出。
 */
public class BillRangeCount {

    private int lower;
    private int upper;
    private long[] tmp; // 归并辅助数组

    public long countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        tmp = new long[n + 1];
        return mergeCount(sum, 0, n + 1);
    }

    /** 统计并对 sum[lo, hi) 排序，返回其中的合法数对个数。 */
    private long mergeCount(long[] sum, int lo, int hi) {
        if (hi - lo <= 1) {
            return 0;
        }
        int mid = (lo + hi) >>> 1;
        long cnt = mergeCount(sum, lo, mid) + mergeCount(sum, mid, hi);

        // 双指针统计：对右半每个 sum[j]，左半中满足
        // sum[j] - upper <= sum[i] <= sum[j] - lower 的 i 的个数
        int low = lo, high = lo;
        for (int j = mid; j < hi; j++) {
            long targetLow = sum[j] - upper;  // sum[i] >= targetLow
            long targetHigh = sum[j] - lower; // sum[i] <= targetHigh
            while (low < mid && sum[low] < targetLow) {
                low++;
            }
            while (high < mid && sum[high] <= targetHigh) {
                high++;
            }
            cnt += high - low;
        }

        // 归并两段有序区间
        System.arraycopy(sum, lo, tmp, lo, hi - lo);
        int i = lo, j = mid, k = lo;
        while (i < mid && j < hi) {
            sum[k++] = (tmp[i] <= tmp[j]) ? tmp[i++] : tmp[j++];
        }
        while (i < mid) {
            sum[k++] = tmp[i++];
        }
        while (j < hi) {
            sum[k++] = tmp[j++];
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int lower = (int) in.nval;
        in.nextToken();
        int upper = (int) in.nval;

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            nums[i] = (int) in.nval;
        }

        System.out.println(new BillRangeCount().countRangeSum(nums, lower, upper));
    }
}
