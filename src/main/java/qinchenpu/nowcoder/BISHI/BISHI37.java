package qinchenpu.nowcoder.BISHI;

import java.util.Scanner;

/**
 * @author qinchenpu
 * @project java-code-training
 * @Date 2026/11/17
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BISHI37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int originNum = in.nextInt();
            int sum = sumNum(originNum);
            String target = String.valueOf(originNum);
            int detuct = sum / 2;
            int m = 0;
            int x = 0;
            int index = target.length() - 1;
            while (detuct > 0 && index >= 0) {
                int cha = target.charAt(index) - '0';
                if (cha > detuct) {
                    m += detuct * (int) Math.pow(10, x);
                } else {
                    m += cha * (int) Math.pow(10, x);
                }
                index--;
                x++;
                detuct -= cha;
            }
            System.out.println(m + " " + (originNum - m));
        }
    }

    private static int sumNum(int target) {
        int sum = 0;
        while (target > 0) {
            sum += target % 10;
            target /= 10;
        }
        return sum;
    }
}
