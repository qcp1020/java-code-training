package qinchenpu.nowcoder.BISHI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author qinchenpu
 * @project java-code-training
 * @Date 2026/11/10
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BISHI2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int n = in.nextInt();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            String line = in.nextLine();
            if (line.startsWith("push")) {
                stack.add(line.substring(5));
            } else if (line.equals("size")) {
                System.out.println(stack.size());
            } else if (line.equals("pop")) {
                if (stack.size() == 0) {
                    System.out.println("Empty");
                } else {
                    stack.pop();
                }

            } else if (line.equals("query")) {
                if (stack.size() == 0) {
                    System.out.println("Empty");
                } else {
                    int size = stack.size();
                    System.out.println(stack.get(size - 1));
                }

            }
        }
    }
}
