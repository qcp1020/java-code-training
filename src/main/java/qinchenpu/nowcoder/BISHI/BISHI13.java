package qinchenpu.nowcoder.BISHI;

import java.util.Scanner;

/**
 * @author qinchenpu
 * @project java-code-training
 * @Date 2026/11/10
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BISHI13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= n; i++) {
            String line = in.nextLine();
            while (line.length() > 15) {
                String prefix = line.substring(0, 15);
                long preNum = Long.parseLong(prefix);
                long mod = preNum % 9;
                if (mod == 0) {
                    line = line.substring(15);
                } else {
                    line = mod + line.substring(15);
                }
            }

            long num = Long.parseLong(line);
            if (num % 9 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}
