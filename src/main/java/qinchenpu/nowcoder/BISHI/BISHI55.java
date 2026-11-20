package qinchenpu.nowcoder.BISHI;

import java.util.Scanner;

/**
 * @author qinchenpu
 * @project java-code-training
 * @Date 2026/11/19
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BISHI55 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        if (num == 1) {
            System.out.println("No");
        } else if (num == 2) {
            System.out.println("Yes");
        } else {
            long dec = Long.MAX_VALUE;
            String isPrime = "Yes";
            for (int i = 3; i <= dec; ) {
                if (num % i == 0) {
                    isPrime = "No";
                    break;
                } else {
                    dec = num / i;
                }
                // 除了2之外，质数一定为奇数
                i += 2;
            }
            System.out.println(isPrime);
        }

    }
}
