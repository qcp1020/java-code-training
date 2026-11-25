package qinchenpu.hy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 题目：移动爱家 APP 账单区间统计（LeetCode 327「区间和的个数」ACM 版）
 *
 * 题目描述：
 *   移动爱家 APP 保存了连续 N 个月家庭业务的扣费流水记录。数组中每一个数值
 *   代表当月净账单：正数代表扣费，负数代表优惠返还。
 *   现在给定统计下限 lower、统计上限 upper，需要统计：一共有多少个
 *   连续月份区间，区间内所有月份账单之和满足 lower <= 区间账单总和 <= upper。
 *
 * 输入格式（ACM 平台）：
 *   第一行：三个整数 n, lower, upper —— 账单月份总数、统计下限、统计上限
 *   第二行：n 个整数，依次为每个月的账单流水值
 * 输出格式：
 *   一个整数 —— 满足条件的连续月份区间总数
 *
 * 思路（前缀和 + 归并排序分治计数）：
 *   设前缀和 P[0] = 0，P[i] = a[1] + a[2] + ... + a[i]，
 *   则连续区间 [i+1, j]（1 <= i < j <= n）的区间和为 P[j] - P[i]。
 *   问题转化为：统计所有数对 (i, j)（0 <= i < j <= n），
 *   满足 lower <= P[j] - P[i] <= upper。
 *
 *   若对每个 j 暴力枚举 i 是 O(n^2)，n 较大时会超时。采用归并排序分治：
 *   - 对前缀和数组做归并排序；
 *   - 合并左右两个【有序】半区 [lo, mid) 与 [mid, hi) 时，
 *     对左半区每个 P[i]，右半区已排序，可用两个同向递增指针 low、high
 *     在 O(1) 均摊时间内定位满足 P[j] - P[i] >= lower 的最小 j'
 *     和满足 P[j] - P[i] <= upper 的最大 j''，
 *     该 P[i] 贡献的数对个数即 (high - low)（右半区下标区间长度）；
 *   - 左右半区各自有序，双指针整体各走一遍，合并计数总代价 O(hi - lo)；
 *   - 随后标准归并（合并两个有序半区），保证上层递归继续有序。
 *
 *   注意点：
 *   1. 前缀和与账单值可能超出 int 范围（累加溢出），统一使用 long。
 *   2. 归并前先把 P[0] = 0 放入数组（长度 n + 1），才能统计以第 1 个月
 *      开头的区间（i 从 0 开始）。
 *
 * 复杂度：
 *   时间 O(n log n) —— 归并排序每层 O(n)，共 log n 层；
 *   空间 O(n) —— 归并辅助数组 + 前缀和数组。
 *
 * 样例验证：
 *   输入: 3 -2 2 / -2 5 -1 -> 输出 3
 *   前缀和 P = [0, -2, 3, 2]
 *   满足条件的区间: [-2]（和 -2）、[-2,5,-1]（和 2）、[-1]（和 -1），共 3 个
 */
public class MobileAiAppBillRangeCount {

    /** 统计下限（区间和下界） */
    private static long lower;
    /** 统计上限（区间和上界） */
    private static long upper;
    /** 归并排序辅助数组 */
    private static long[] tmp;

    public static void main(String[] args) throws IOException {
        // ACM 平台使用标准输入输出；StreamTokenizer 逐 token 读取，足够快
        StreamTokenizer in = new StreamTokenizer(
                new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        lower = (long) in.nval;
        in.nextToken();
        upper = (long) in.nval;

        // 前缀和数组：P[0] = 0，P[i] 为前 i 个月账单之和
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            prefix[i] = prefix[i - 1] + (long) in.nval;
        }

        tmp = new long[n + 1];
        long answer = countWhileSort(prefix, 0, n + 1);
        System.out.println(answer);
    }

    /**
     * 对 prefix[lo, hi) 归并排序，并在排序过程中统计
     * 满足 lower <= P[j] - P[i] <= upper 且 lo <= i < j < hi 的数对个数。
     *
     * @return 该区间内的合法数对个数
     */
    private static long countWhileSort(long[] prefix, int lo, int hi) {
        if (hi - lo <= 1) {
            return 0; // 长度为 0 或 1，无数对
        }
        int mid = (lo + hi) >>> 1;
        // 分：左右两半分别递归计数
        long count = countWhileSort(prefix, lo, mid) + countWhileSort(prefix, mid, hi);

        // 治：利用左右两半均已有序，双指针统计跨半区的数对
        int low = mid;  // 第一个满足 P[low] - P[i] >= lower 的右半区下标
        int high = mid; // 第一个不满足 P[high] - P[i] <= upper 的右半区下标
        for (int i = lo; i < mid; i++) {
            // 双指针只前进不后退，整体 O(hi - lo)
            while (low < hi && prefix[low] - prefix[i] < lower) {
                low++;
            }
            while (high < hi && prefix[high] - prefix[i] <= upper) {
                high++;
            }
            // 右半区中 [low, high) 内的每个 j 都满足 lower <= P[j]-P[i] <= upper
            count += high - low;
        }

        // 标准归并：合并左右两个有序半区，供上层递归使用
        merge(prefix, lo, mid, hi);
        return count;
    }

    /** 合并 prefix[lo, mid) 与 prefix[mid, hi) 两个有序段（升序） */
    private static void merge(long[] prefix, int lo, int mid, int hi) {
        int i = lo, j = mid, k = lo;
        while (i < mid && j < hi) {
            tmp[k++] = prefix[i] <= prefix[j] ? prefix[i++] : prefix[j++];
        }
        while (i < mid) {
            tmp[k++] = prefix[i++];
        }
        while (j < hi) {
            tmp[k++] = prefix[j++];
        }
        System.arraycopy(tmp, lo, prefix, lo, hi - lo);
    }
}
