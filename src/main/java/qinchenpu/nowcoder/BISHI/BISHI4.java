package qinchenpu.nowcoder.BISHI;

import java.util.*;

/**
 * @author qinchenpu
 * @project java-code-training
 * @Date 2026/11/10
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BISHI4 {

    // 使用TreeSet而不是HashSet原因，TreeSet自带排序，方便获取前驱和后继
    static TreeSet<Integer> set = new TreeSet<>();

    public static void insertValue(int x) {
        set.add(x);
    }

    public static void eraseValue(int x) {
        set.remove(x);
    }

    public static boolean xInSet(int x) {
        return set.contains(x);
    }

    public static int sizeOfSet() {
        return set.size();
    }

    public static int getPre(int x) {
        Integer pre = set.lower(x);
        return pre == null ? -1 : pre;
    }

    public static int getBack(int x) {
        Integer back = set.higher(x);
        return back == null ? -1 : back;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q-- > 0) {
            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    insertValue(scanner.nextInt());
                    break;
                case 2:
                    eraseValue(scanner.nextInt());
                    break;
                case 3:
                    System.out.println(xInSet(scanner.nextInt()) ? "YES" : "NO");
                    break;
                case 4:
                    System.out.println(sizeOfSet());
                    break;
                case 5:
                    System.out.println(getPre(scanner.nextInt()));
                    break;
                case 6:
                    System.out.println(getBack(scanner.nextInt()));
                    break;
            }
        }
        scanner.close();
    }
}
