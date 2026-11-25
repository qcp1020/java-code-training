import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 移动伴学词语闯关（单词接龙 / Word Ladder）—— ACM 输入输出模式
 *
 * 组内输入格式（已由通过的测试点验证）：
 *   beginWord endWord
 *   m
 *   word1 ... wordm        （token 化读取，逐行或同行均兼容）
 *
 * ACM 多组兼容：
 *   1. 首 token 为纯整数 t —— 按「t 组测试数据」处理，输出 t 行
 *   2. 否则 —— 循环处理到 EOF（隐式多组），每组输出一行
 *   3. 单组输入自然兼容（两种模式均只解析出一组）
 *
 * 输出：每组一行，最短闯关序列总长度；无法完成输出 0。
 *
 * 算法：无权图最短路 —— BFS + 通配符模式邻接表。
 * 每个词生成 L 个模式（hot -> *ot / h*t / ho*），模式相同即恰差一个字符，
 * 不依赖小写字符集假设。起始词语算第 1 关；begin == end 输出 1；
 * endWord 不在词库输出 0。
 *
 * 时间复杂度：O(N * L^2)（N 为词库词数，L 为词长）
 * 空间复杂度：O(N * L)（词库集合 + 模式桶 + 队列 + 访问标记）
 *
 * 样例：
 *   hit cog / 6 / [hot,dot,dog,lot,log,cog] -> 5 (hit->hot->dot->dog->cog)
 */
public class WordLadderBFS {

    public static void main(String[] args) throws IOException {
        // 全量 token 化：容忍空行、行内多空格、\r\n、逐行或同行词库
        List<String> tokens = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            for (StringTokenizer st = new StringTokenizer(line); st.hasMoreTokens(); ) {
                tokens.add(st.nextToken());
            }
        }
        if (tokens.isEmpty()) {
            return;
        }

        StringBuilder out = new StringBuilder();

        // 模式一：首 token 为纯整数 -> 组数 t
        Integer t = tryParseInt(tokens.get(0));
        boolean handled = false;
        if (t != null && t > 0) {
            int idx = 1;
            int parsed = 0;
            while (parsed < t) {
                int next = solveOneGroup(tokens, idx, out);
                if (next < 0) {
                    break; // 数据不足，按已解析的组输出
                }
                idx = next;
                parsed++;
            }
            handled = parsed > 0;
        }

        // 模式二：无 t 前缀 -> 循环处理到 EOF
        if (!handled) {
            int idx = 0;
            while (true) {
                int next = solveOneGroup(tokens, idx, out);
                if (next < 0) {
                    break;
                }
                idx = next;
            }
        }

        System.out.print(out);
    }

    /**
     * 解析并求解一组 [beginWord endWord m word*m]，答案追加一行到 out。
     * 返回消费后的 token 下标；格式不符 / token 不足返回 -1。
     */
    static int solveOneGroup(List<String> tokens, int idx, StringBuilder out) {
        int n = tokens.size();
        if (idx + 3 > n) {
            return -1;
        }
        String begin = tokens.get(idx);
        String end = tokens.get(idx + 1);
        Integer m = tryParseInt(tokens.get(idx + 2));
        if (m == null || m < 0 || idx + 3 + m > n) {
            return -1;
        }
        Set<String> dict = new HashSet<>();
        for (int i = 0; i < m; i++) {
            dict.add(tokens.get(idx + 3 + i));
        }
        out.append(ladderLength(begin, end, dict)).append('\n');
        return idx + 3 + m;
    }

    /** 纯整数（>=0）解析，非整数返回 null */
    static Integer tryParseInt(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return null;
            }
        }
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e) {
            return null; // 超长数字串
        }
    }

    /** BFS 求最短变换序列长度；不可达返回 0 */
    static int ladderLength(String beginWord, String endWord, Set<String> dict) {
        if (beginWord.equals(endWord)) {
            return 1; // 起始词即目标，算第 1 关
        }
        if (!dict.contains(endWord)) {
            return 0;
        }

        // 通配符模式 -> 词列表：模式相同的词恰好一个字符不同
        Map<String, List<String>> patterns = new HashMap<>();
        for (String w : dict) {
            char[] cs = w.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char old = cs[i];
                cs[i] = '*';
                patterns.computeIfAbsent(new String(cs), k -> new ArrayList<>()).add(w);
                cs[i] = old;
            }
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int steps = 1; // 起始词语算第 1 关

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                String cur = queue.poll();
                char[] cs = cur.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    char old = cs[i];
                    cs[i] = '*';
                    List<String> bucket = patterns.get(new String(cs));
                    cs[i] = old; // 还原
                    if (bucket == null) {
                        continue;
                    }
                    for (String next : bucket) {
                        if (next.equals(endWord)) {
                            return steps + 1;
                        }
                        if (visited.add(next)) {
                            queue.offer(next);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}
