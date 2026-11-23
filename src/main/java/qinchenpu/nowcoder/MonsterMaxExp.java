package qinchenpu.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 牛客算法题：小美打怪物（经验值最大化）
 *
 * 题目描述：
 *   小美按编号从小到大依次遇到 n 只怪物（编号 1~n），怪物 i 的生命为 a_i。
 *   对每只怪物可选择放走或击败：
 *   - 放走怪物 i：获得 i 点经验值；
 *   - 击败怪物 i：获得 a_i 点经验值，并额外获得 (x mod 10) * a_i 点经验值，
 *     其中 x 为击败的怪物数量（包括这一只）。
 *   求小美最多能获得的经验值。
 *
 * 数据范围：1 <= n <= 2*10^5，1 <= a_i <= 10^9
 *
 * 解题思路（DP，O(10n)）：
 *   关键观察：击败怪物时的额外经验倍率 (x mod 10) 只取决于「已击败数量 mod 10」。
 *   设 dp[r] 表示当前已击败数量 mod 10 = r 时能获得的最大经验值（初始 dp[0]=0，其余为负无穷）。
 *   从左到右遍历每只怪物 i：
 *   - 放走：击败数不变，经验 +i            -> newDp[r] = dp[r] + i
 *   - 击败：该怪物是第 (击败数) 只，名次 mod 10 = r，经验 + a_i * (1 + r)
 *                                          -> newDp[r] = dp[(r + 9) % 10] + a_i * (1 + r)
 *   答案为 max(dp[0..9])。
 *   用 long 存储结果（最大约 2*10^5 * 10 * 10^9 = 2*10^15，超出 int 范围）。
 *
 * 示例：
 *   输入：
 *     3
 *     5 3 2
 *   输出：
 *     27
 *   （三只全击败：5+5*1=10，3+3*2=9，2+2*3=8，合计 27）
 *
 * @author qinchenpu
 */
public class MonsterMaxExp {

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;

        long[] dp = new long[10];
        final long NEG = Long.MIN_VALUE / 2;
        java.util.Arrays.fill(dp, NEG);
        dp[0] = 0L;

        for (int i = 1; i <= n; i++) {
            in.nextToken();
            long a = (long) in.nval;
            long[] ndp = new long[10];
            for (int r = 0; r < 10; r++) {
                // 选择 1：放走怪物 i，获得 i 点经验，击败数量 mod 10 仍为 r
                long best = dp[r] + i;
                // 选择 2：击败怪物 i，它的名次 mod 10 = r，获得 a * (1 + r) 点经验
                long defeat = dp[(r + 9) % 10] + a * (1 + r);
                if (defeat > best) {
                    best = defeat;
                }
                ndp[r] = best;
            }
            dp = ndp;
        }

        long ans = 0;
        for (int r = 0; r < 10; r++) {
            ans = Math.max(ans, dp[r]);
        }
        System.out.println(ans);
    }
}
