package qinchenpu.hy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 移动云电脑网页虚拟软键盘 —— 指令词命中检索（单词搜索 II / LeetCode 212 变体）。
 *
 * <p><b>题目</b>：给定 m 行 n 列小写字母矩阵（软键盘布局），后台有 k 条待检索的控制指令词。
 * 指令词可以沿矩阵“上、下、左、右”相邻格子依次拼接；同一条指令词的拼接过程中，
 * 同一个格子不允许重复使用（不同指令之间互不影响）。只要能在矩阵中拼出该指令词即判定命中。
 * 输出全部命中的指令词，字典序从小到大每行一条；没有任何命中则不输出内容。
 *
 * <p><b>解法：Trie（前缀树）+ 回溯 DFS</b>
 * <ol>
 *   <li>全部指令词先插入 Trie。检索时沿 Trie 同步下走，当前路径不构成任何词前缀就立即回溯，
 *       避免对每个词单独做一次 O(m·n) 的暴力搜索。</li>
 *   <li>DFS 中用 visited 标记格子占用、回溯时恢复，保证单条指令内部格子不重复使用。</li>
 *   <li>命中后立刻把该节点的单词标记置空（等价于从词典删除），同一单词有多条拼写路径也只输出一次。</li>
 *   <li>已无单词且无子节点的 Trie 节点在回溯时剪掉，减少后续无效搜索。</li>
 *   <li>入 Trie 前做必要条件预剪枝：词长超过格子总数、或某字母出现次数超过矩阵中的次数，必然拼不出。</li>
 * </ol>
 *
 * <p><b>复杂度</b>（L 为指令词最大长度，Σ=26，H 为命中数）：
 * <ul>
 *   <li>时间：O(Σ·m·n·3^(L-1) + 指令词总字符数 + H·log H)。从每格出发 DFS，
 *       除起点外每步最多向 3 个方向扩展（不会原路返回），深度被最长词长 L 限制；
 *       Trie 前缀剪枝使实际开销远小于该上界。</li>
 *   <li>空间：O(指令词总字符数 × Σ) 的 Trie（按需分配）+ O(m·n) 的 visited + O(L) 递归栈。</li>
 * </ul>
 *
 * <p><b>ACM 输入输出适配</b>（判题机不给方法骨架，全部自己读写 stdin/stdout）：
 * <ul>
 *   <li>矩阵每行既支持空格分隔（{@code o a a n}），也支持连续字母（{@code oaan}）；
 *       整块矩阵写成一个长串也能正确识别。</li>
 *   <li>支持一组数据，也支持多组数据首尾相接，或首行为测试组数 T 的组织方式；
 *       解析时先按题面格式（无 T）整体校验，失败再按带 T 的格式校验，取能完整解析的那种。</li>
 *   <li>兼容 Windows 换行（\r\n）、行首行尾多余空白与空行。</li>
 * </ul>
 */
public class VirtualKeyboardWordSearch {

    /** Trie 节点：26 个小写字母子指针 + 单词结束标记。 */
    private static final class TrieNode {
        final TrieNode[] children = new TrieNode[26];
        /** 非 null 表示从根到本节点的路径恰为一条完整指令词。 */
        String word;
    }

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private TrieNode root;
    private char[][] board;
    private boolean[][] visited;
    private List<String> found;

    /**
     * 在矩阵中检索全部可拼出的指令词。
     *
     * @param board 字母矩阵（小写字母）
     * @param words 指令词数组
     * @return 命中的全部指令词，字典序升序、已去重
     */
    public List<String> findWords(char[][] board, String[] words) {
        this.found = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return found;
        }
        this.board = board;
        this.root = new TrieNode();

        int m = board.length, n = board[0].length;
        this.visited = new boolean[m][n];

        // 统计矩阵各字母出现次数，用于“必然拼不出”的必要条件预剪枝
        int[] boardCount = new int[26];
        for (char[] row : board) {
            for (char c : row) {
                if (c >= 'a' && c <= 'z') {
                    boardCount[c - 'a']++;
                }
            }
        }

        boolean anyInserted = false;
        for (String w : words) {
            if (w == null || w.isEmpty() || w.length() > m * n) {
                continue;                       // 空词或词长超过格子总数，不可能拼出
            }
            if (!canPossiblyForm(w, boardCount)) {
                continue;                       // 字母数量不足，必然拼不出
            }
            insert(w);
            anyInserted = true;
        }
        if (!anyInserted) {
            return found;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = board[i][j] - 'a';
                if (idx >= 0 && idx < 26 && root.children[idx] != null) {
                    dfs(i, j, root);
                }
            }
        }

        Collections.sort(found);
        return found;
    }

    /** 必要条件：词中每个字母出现次数不超过矩阵中的出现次数（矩阵只含小写字母）。 */
    private boolean canPossiblyForm(String word, int[] boardCount) {
        int[] need = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c < 'a' || c > 'z') {
                return false;
            }
            if (++need[c - 'a'] > boardCount[c - 'a']) {
                return false;
            }
        }
        return true;
    }

    private void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.word = word;
    }

    /** 从格子 (i, j) 出发，沿 Trie 节点 parent 继续回溯匹配。 */
    private void dfs(int i, int j, TrieNode parent) {
        char c = board[i][j];
        TrieNode node = parent.children[c - 'a'];
        if (node == null) {
            return; // 前缀不匹配
        }

        // 命中完整指令词：收集后“删除”，防止同一单词经多条路径重复输出
        if (node.word != null) {
            found.add(node.word);
            node.word = null;
        }

        visited[i][j] = true; // 占用当前格子：单条指令内不可重复使用
        int m = board.length, n = board[0].length;
        for (int[] d : DIRECTIONS) {
            int ni = i + d[0], nj = j + d[1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n || visited[ni][nj]) {
                continue;
            }
            int idx = board[ni][nj] - 'a';
            if (idx < 0 || idx >= 26 || node.children[idx] == null) {
                continue; // Trie 剪枝：该字符不可能是任何指令词的下一个字符
            }
            dfs(ni, nj, node);
        }
        visited[i][j] = false; // 回溯：恢复格子可用

        // 该节点已无单词、也无子节点，剩余搜索中再无用途，剪掉
        if (isDeadBranch(node)) {
            parent.children[c - 'a'] = null;
        }
    }

    private boolean isDeadBranch(TrieNode node) {
        if (node.word != null) {
            return false;
        }
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    // ==================================================================
    //  以下为 ACM 判题所需的输入输出处理
    // ==================================================================

    /** 一组测试数据的解析结果。 */
    private static final class CaseData {
        char[][] board;
        String[] words;
    }

    /**
     * 基于“已切分的空白 token 流”的解析器。
     * 矩阵字母按字符推进读取，因此单个 token 内放多个字母（{@code oaan}）也能正确读入。
     */
    private static final class TokenParser {
        private final List<String> tokens;
        private int ti;   // 当前 token 下标
        private int ci;   // 当前 token 内字符偏移
        private boolean failed;

        TokenParser(List<String> tokens) {
            this.tokens = tokens;
        }

        /** 跳过已读完的 token。 */
        private void sync() {
            while (ti < tokens.size() && ci >= tokens.get(ti).length()) {
                ti++;
                ci = 0;
            }
        }

        boolean atEnd() {
            sync();
            return ti >= tokens.size();
        }

        /** 是否停在某个 token 的中间（说明剩余字符与预期结构不符）。 */
        private boolean midToken() {
            sync();
            return ti < tokens.size() && ci > 0;
        }

        /** 读一个字符（矩阵字母用）。 */
        char nextChar() {
            sync();
            if (ti >= tokens.size()) {
                failed = true;
                return 0;
            }
            return tokens.get(ti).charAt(ci++);
        }

        /** 读一个整数；结构不符则置失败标记并返回 -1。 */
        int nextInt() {
            sync();
            if (ti >= tokens.size() || ci != 0) { // 整数必须独占一个 token
                failed = true;
                return -1;
            }
            String t = tokens.get(ti);
            int p = 0, sign = 1;
            if (p < t.length() && (t.charAt(p) == '-' || t.charAt(p) == '+')) {
                sign = t.charAt(p) == '-' ? -1 : 1;
                p++;
            }
            if (p >= t.length()) {
                failed = true;
                return -1;
            }
            long v = 0;
            for (; p < t.length(); p++) {
                char ch = t.charAt(p);
                if (ch < '0' || ch > '9') {
                    failed = true;
                    return -1;
                }
                v = v * 10 + (ch - '0');
                if (v > Integer.MAX_VALUE) {
                    failed = true;
                    return -1;
                }
            }
            ti++;
            ci = 0;
            return (int) (sign * v);
        }

        /** 读一个指令词 token。 */
        String nextToken() {
            sync();
            if (ti >= tokens.size() || ci != 0) {
                failed = true;
                return null;
            }
            String t = tokens.get(ti);
            ti++;
            ci = 0;
            return t;
        }

        boolean failed() {
            return failed;
        }
    }

    /** 解析全部测试数据；结构不合法返回 null。 */
    private static List<CaseData> parseAll(List<String> tokens, boolean leadingCaseCount) {
        TokenParser p = new TokenParser(tokens);
        List<CaseData> cases = new ArrayList<>();
        int caseCount = -1;

        if (leadingCaseCount) {
            caseCount = p.nextInt();
            if (p.failed() || caseCount <= 0) {
                return null;
            }
        }

        while ((caseCount < 0 || cases.size() < caseCount) && !p.atEnd()) {
            int m = p.nextInt();
            int n = p.nextInt();
            if (p.failed() || m <= 0 || n <= 0) {
                return null;
            }
            char[][] board = new char[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char c = p.nextChar();
                    if (p.failed()) {
                        return null;
                    }
                    board[i][j] = Character.toLowerCase(c);
                }
            }
            // 矩阵读完后必须正好落在 token 边界，否则说明行列数与数据不符
            if (p.midToken()) {
                return null;
            }

            int k = p.nextInt();
            if (p.failed() || k < 0) {
                return null;
            }
            String[] words = new String[k];
            for (int i = 0; i < k; i++) {
                String w = p.nextToken();
                if (p.failed()) {
                    return null;
                }
                words[i] = w.toLowerCase();
            }
            CaseData cd = new CaseData();
            cd.board = board;
            cd.words = words;
            cases.add(cd);
        }

        if (p.failed() || !p.atEnd()) {   // 必须把输入恰好读完
            return null;
        }
        if (leadingCaseCount && cases.size() != caseCount) {
            return null;
        }
        return cases.isEmpty() ? null : cases;
    }

    private static List<String> tokenize(String text) {
        List<String> tokens = new ArrayList<>();
        int i = 0, len = text.length();
        while (i < len) {
            while (i < len && Character.isWhitespace(text.charAt(i))) {
                i++;
            }
            int start = i;
            while (i < len && !Character.isWhitespace(text.charAt(i))) {
                i++;
            }
            if (i > start) {
                tokens.add(text.substring(start, i));
            }
        }
        return tokens;
    }

    private static String readAll() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] buf = new char[1 << 13];
        int len;
        while ((len = br.read(buf)) != -1) {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }

    /** OJ 入口：读全部输入 → 解析 → 逐组求解并按字典序输出。 */
    public static void main(String[] args) throws IOException {
        List<String> tokens = tokenize(readAll());
        if (tokens.isEmpty()) {
            return;
        }

        // 先按题面格式（单组或多组首尾相接，无前置组数）解析；失败再尝试首行为 T 的格式
        List<CaseData> cases = parseAll(tokens, false);
        if (cases == null) {
            cases = parseAll(tokens, true);
        }
        if (cases == null) {
            return; // 结构无法识别，不输出内容
        }

        StringBuilder out = new StringBuilder();
        for (CaseData cd : cases) {
            List<String> hit = new VirtualKeyboardWordSearch().findWords(cd.board, cd.words);
            for (String w : hit) {
                out.append(w).append('\n');
            }
        }
        System.out.print(out);
    }
}
