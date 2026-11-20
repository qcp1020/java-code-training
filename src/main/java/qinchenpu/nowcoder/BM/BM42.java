package qinchenpu.nowcoder.BM;

import java.util.Stack;

/**
 * @author qinchenpu
 * @project java-code-training
 * @Date 2026/10/19
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BM42 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public static void main(String[] args) {
    }

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }
}
