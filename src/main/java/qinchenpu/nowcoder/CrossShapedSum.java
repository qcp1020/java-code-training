package qinchenpu.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author qinchenpu
 * @date 2025/12/26
 * @description 寻找矩阵十字形数字求和最大值
 * @CopyRight 版权所有 (C) 中国移动 杭州研发中心.
 */
public class CrossShapedSum {
    public static void main(String[] args) throws IOException {
//        solution();
//        solution2();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        // 三行缓存（物理内存连续，确保缓存命中率100%）
        int[] prevRow = new int[m];
        int[] currRow = new int[m];
        int[] nextRow = new int[m];

        // 读入前两行
        String[] tokens = reader.readLine().split(" ");
        for (int j = 0; j < m; j++) {
            prevRow[j] = Integer.parseInt(tokens[j]);
        }
        tokens = reader.readLine().split(" ");
        for (int j = 0; j < m; j++) {
            currRow[j] = Integer.parseInt(tokens[j]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n - 1; i++) {
            // 读入下一行
            tokens = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                nextRow[j] = Integer.parseInt(tokens[j]);
            }

            // 计算十字形最大值（j从1到m-2）
            for (int j = 1; j < m - 1; j++) {
                int sum = prevRow[j] + currRow[j - 1] + currRow[j] + currRow[j + 1] + nextRow[j];
                if (sum > max) {
                    max = sum;
                }
            }

            // 滚动数组，更新三行缓存：prev=curr, curr=next
            int[] temp = prevRow;
            prevRow = currRow;
            currRow = nextRow;
            nextRow = temp; // 重用内存，避免额外分配
        }

        System.out.println(max);

    }


    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int max = 0;
        int tempSum = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                tempSum = arr[i - 1][j] + arr[i][j - 1] + arr[i][j] + arr[i][j + 1] + arr[i + 1][j];
                if (tempSum > max) {
                    max = tempSum;
                }
            }
        }
        System.out.println(max);
    }

    public static void solution2() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        int tempSum = 0;
        int[] prevRow, currRow, nextRow = new int[m];
        for (int i = 1; i < n - 1; i++) {
            prevRow = arr[i - 1];
            currRow = arr[i];
            nextRow = arr[i + 1];
            for (int j = 1; j < m - 1; j++) {
                tempSum = prevRow[j] + currRow[j - 1] + currRow[j] + currRow[j + 1] + nextRow[j];
                if (tempSum > max) {
                    max = tempSum;
                }
            }
        }
        System.out.println(max);
    }

}
