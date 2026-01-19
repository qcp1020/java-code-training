package qinchenpu.leetcode.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author qinchenpu
 * @project leetcode
 * @Date 2022/4/18
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 15, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.CallerRunsPolicy());

        List<String> list = new ArrayList<>();
        list.add("12");
        System.out.println(method1());
    }

    public static String method1() {
        try {
            System.out.println("A");
            return method2();
        } finally {
            System.out.println("B");
        }
    }

    public static String method2() {
        System.out.println("C");
        return "D";

    }
}
