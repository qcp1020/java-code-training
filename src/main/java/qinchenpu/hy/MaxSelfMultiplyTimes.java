package qinchenpu.hy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 题目：自乘变换（求最多的自乘次数）
 *
 * <p>给定正整数 a、b，每次操作可以把 a 乘以一个大于 1 的正整数，问 a 能否经过若干次操作变为 b；
 * 若能，输出最多的操作次数；若不能，输出 -1。
 *
 * <p>思路：
 * 1. 记 k = b / a。若 a 不能整除 b（或 a &gt; b），永远变不到 b，输出 -1；
 *    a == b 时为 0 次，直接输出 0。
 * 2. 每次操作的乘数都大于 1，设为 m1*m2*...*mt = k，且每个 mi &gt;= 2。
 *    要让 t 尽量大，就要求每个 mi 尽量小，即取成质数：
 *    t 的最大值 = k 的质因数个数（按重数计，即 Ω(k)）。
 * 3. 因为 a、b &lt;= 1e9，k &lt;= 1e9，试除到 sqrt(k)（约 31623）即可，单次 O(sqrt(k))。
 *    注意 a == 1 时 k = b，同样只做质因数分解即可（例如 1 -&gt; 2 -&gt; 4 -&gt; ... -&gt; b）。
 *
 * <p>时间复杂度：O(sqrt(b/a))（最坏约 3.2 万次试除，可忽略）；空间复杂度：O(1)。
 * 因平台是多行测试数据，需要一直读到输入结束（EOF）。
 *
 * @author qinchenpu
 * @project java-code-training
 * @Date 2026/11/01
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class MaxSelfMultiplyTimes {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder out = new StringBuilder();

        // ACM 模式：反复读取，直到输入结束
        while (true) {
            // 取下一个整数字符串，跨行也能正确衔接
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    System.out.print(out);
                    return;
                }
                st = new StringTokenizer(line);
            }
            String aToken = st.nextToken();
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) { // 数据不完整（只有 a 没有 b），直接结束
                    System.out.print(out);
                    return;
                }
                st = new StringTokenizer(line);
            }
            String bToken = st.nextToken();

            long a = Long.parseLong(aToken);
            long b = Long.parseLong(bToken);
            out.append(solve(a, b)).append('\n');
        }
    }

    /**
     * 计算 a 变到 b 的最多自乘次数。
     *
     * @param a 起始值
     * @param b 目标值
     * @return 最多操作次数；不可能则返回 -1
     */
    private static long solve(long a, long b) {
        if (a == b) {
            return 0; // 已经是目标值，0 次
        }
        if (a > b) {
            return -1; // 只会变大，不可能变小
        }
        if (b % a != 0) {
            return -1; // b 不是 a 的整数倍，永远到不了
        }
        // k = b / a，答案就是 k 的质因数个数（按重数计）
        return countPrimeFactors(b / a);
    }

    /**
     * 统计 n 的质因数个数（按重数计）。例：12 = 2*2*3，返回 3。
     * 时间复杂度 O(sqrt(n))，空间 O(1)。
     */
    private static int countPrimeFactors(long n) {
        int count = 0;
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }
        for (long p = 3; p * p <= n; p += 2) {
            while (n % p == 0) {
                count++;
                n /= p;
            }
        }
        if (n > 1) {
            count++; // 剩下一个大质数
        }
        return count;
    }
}
