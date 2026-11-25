package qinchenpu.hy;

import java.io.IOException;
import java.io.InputStream;

/**
 * 移动看家异动告警框识别（最大全 1 矩形）—— ACM 赛制，自行处理输入输出
 *
 * 题目：给定 n x m 的 0/1 标记矩阵，找出内部元素全为 1 的最大矩形，输出该矩形包含的像素总数。
 *
 * 思路（流式 + 单调栈，边读边算）：
 *   逐行维护柱状图高度 height[j]（从当前格向上连续 1 的个数），
 *   每读入一行立即用「单调递增栈」求该行柱状图的最大矩形，滚动更新全局最大值。
 *
 * 关键优化（针对 ACM 大数据）：
 *   1. 用 InputStream.read 整块读入字节，避免逐行 readLine 的字符串开销；
 *   2. 不存储整个矩阵，只保留一维高度数组，内存 O(m)，大矩阵不爆 128MB；
 *   3. 输入同时兼容「1 0 1」空格分隔与「101」连续字符串两种矩阵行格式
 *      （跳过一切非 0/1 的字符，如空格、回车、换行）。
 *
 * 时间复杂度：O(n * m)，每行单调栈 O(m)。
 * 空间复杂度：O(m)（高度数组 + 栈）。
 */
public class MaxAlarmRectangle {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;

        // ---------- 读取 n、m（跳过非数字字符） ----------
        int n = readInt(in);
        int m = readInt(in);

        int[] heights = new int[m];
        int[] stack = new int[m + 1];
        long maxArea = 0;

        // ---------- 逐行读取并滚动计算 ----------
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 跳过该格的空白/分隔符，读取一个 0/1
                int c = readBit(in);
                if (c == 1) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            long area = largestRectangleArea(heights, stack);
            if (area > maxArea) maxArea = area;
        }

        System.out.println(maxArea);
    }

    /** 读取下一个非负整数（跳过前导非数字字符） */
    private static int readInt(InputStream in) throws IOException {
        int c = in.read();
        while (c != -1 && (c < '0' || c > '9')) c = in.read();
        int v = 0;
        while (c >= '0' && c <= '9') {
            v = v * 10 + (c - '0');
            c = in.read();
        }
        return v;
    }

    /** 读取下一个 0 或 1 比特（跳过空白/其他字符，连续字符串与空格分隔均兼容） */
    private static int readBit(InputStream in) throws IOException {
        int c = in.read();
        while (c != -1 && c != '0' && c != '1') c = in.read();
        return c - '0';
    }

    /**
     * 单调递增栈求柱状图中最大矩形。
     * 栈中保存下标，对应高度单调递增；遇到更矮的柱子时弹出并结算以该柱子为高的最大矩形宽度。
     * 哨兵技巧：循环多走一步（下标 m 处高度为 0），保证栈中所有柱子最终都被弹出结算。
     */
    private static long largestRectangleArea(int[] heights, int[] stack) {
        int m = heights.length;
        int top = -1;
        long max = 0;

        for (int j = 0; j <= m; j++) {
            int cur = (j == m) ? 0 : heights[j];
            while (top >= 0 && heights[stack[top]] >= cur) {
                long h = heights[stack[top--]];
                int left = (top >= 0) ? stack[top] + 1 : 0;
                max = Math.max(max, h * (j - left));
            }
            stack[++top] = j;
        }
        return max;
    }
}
