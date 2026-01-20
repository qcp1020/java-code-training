package qinchenpu.nowcoder;

import java.util.Arrays;

/**
 * @author qinchenpu
 * @project LeetCode
 * @Date 2026/1/14
 * @Description: 合并两个有序数组,
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BM87 {
    public static void main(String[] args) {
        int[] arrA = {1, 2, 3, 9, 0, 0, 0, 0, 0};
        int[] arrB = {4, 5, 6, 7, 8};
        merge(arrA, 4, arrB, arrB.length);
        System.out.println(Arrays.toString(arrA));
    }

    /**
     * @Description: 数组 B 合并到数组 A 中，变成一个有序的升序数组, A 和 B 中初始的元素数目分别为 m 和 n，A的数组空间大小为 m+n
     */
    private static void merge(int A[], int m, int B[], int n) {
        if (m == 0 && n != 0) {
            for (int i = 0; i < n; i++) {
                A[i] = B[i];
            }
        }
        int index = m + n - 1;
        int indexA = m - 1;
        int indexB = n - 1;
        while (indexA >= 0 && indexB >= 0) {
            if (A[indexA] > B[indexB]) {
                A[index--] = A[indexA--];
            } else {
                A[index--] = B[indexB--];
            }
        }
        if (indexA < 0) {
            for (int i = 0; i <= indexB; i++) {
                A[i] = B[i];
            }
        }
    }
}
