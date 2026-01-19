/**
 * @project ecs-web
 * @File Algorithm.java
 * @Date 2021年7月1日
 * @CopyRight 版权所有 (C) 中国移动 杭州研发中心.
 */
package qinchenpu.leetcode.nowcoder;

import common.ListNode;
import common.TreeNode;

import java.util.*;

import static common.CommonUtils.generateListNodes;

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problemset/all/
 *
 * @author qinchenpu
 * @project ecs-web
 * @File Algorithm.java
 * @Date 2021年7月1日
 * @CopyRight 版权所有 (C) 中国移动 杭州研发中心.
 */
public class Algorithm {

    /**
     * @Author qinchenpu
     * @Date 2021年7月1日
     * @ReturnType void
     */
    public static void main(String[] args) {
        // 假设m>=n
        // int m = 45;
        // int n = 12;
        // int maxDivisor = maxCommonDivisor(m, n);
        // System.out.println(maxDivisor);
        // int minMultiple = minCommonMultiple(m, n);
        // System.out.println(minMultiple);
        // System.out.println(romanToInt("MCMXCIV"));

        // System.out.println(mySqrt(3));
        // System.out.println(climbStairs(1));
        // System.out.println(addBinary("1", "1"));
        // System.out.println(Arrays.toString(plusOne(arr)));
        // int[] arr = { 0, 0, 0, 0 };
        // System.out.println(maxSubArray(arr));
        // TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3),
        // null));
        // System.out.println(inorderTraversal(root));
        //
        // String[] strs = { "flower", "flow", "flight", "fun" };
        // System.out.println(longestCommonPrefix(strs));

        // System.out.println(multiply("123456789", "987654321"));
        // System.out.println(multiply("1234", "5678"));
        // System.out.println(Arrays.toString(twoSum(arr, -4)));
        // System.out.println(fourSum(arr, 4).toString());

        // ListNode listNode = addTwoNumbers(new ListNode(2, new ListNode(9, new
        // ListNode(9))), new ListNode(9));
        // while (listNode != null) {
        // System.out.println(listNode.val);
        // listNode = listNode.next;
        // }

//        int[] arr = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
//		 int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
//		 System.out.println(findMedianSortedArrays({1,2}, {3,4}));
//		 System.out.println(longestPalindrome("cbbd"));
        // System.out.println(convert("A", 1));
        // System.out.println(convert("PAYPALISHIRING", 3));
        // System.out.println(maxArea(height));
        // System.out.println(removeDuplicates(arr));
        // System.out.println(removeElement(arr, 2));
//        System.out.println(strStr("abcdef", "bcd"));
//        System.out.println("abc");
//        System.out.println(Arrays.toString(searchRange(arr, 3)));
//        String s = "barfoothefoobarman";
//        String[] words = {"foo", "bar"};
//        System.out.println(findSubstring(s, words));


//        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

//        System.out.println(numberOfMatches(14));
        int[] nums1 = {1, 2, 4, 6};
        int[] nums2 = {1, 3, 5, 8, 10};
//        System.out.println(minOperations(nums, 1å0));


//        String str3 = new String("123");
//        String str2 = "123";
//        String str1 = "123";
//        System.out.println(str1 == str2); // true
//        System.out.println(str1 == str3); // false

//        int count = jizhanCount(4, 8);
//        System.out.println(count);

//        ListNode node1 = generateListNodes(nums1);
//        ListNode node2 = generateListNodes(nums2);
//        ListNode node = mergeTwoLists(node1, node2);
//        soutListNode(node);
//        String ss = "barfoofoobarthefoobarman";

//        String ss = "wordgoodgoodgoodbestword";
//        String ss = "barfoothefoobarman";
//        String[] strArr = new String[]{"foo", "bar"};
        //        String[] strArr = new String[]{"a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"};

//        System.out.println(ss.length());
//        System.out.println(strArr.length);
//        List<Integer> list = findSubstring(ss, strArr);
//        list.forEach(System.out::println);

        int[] arr = {1, 2, 3, 4, 5};
        ListNode node = generateListNodes(arr);
        soutListNode(node);
    }


    /**
     * 30. 串联所有单词的子串
     * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     *
     * @param str
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String str, String[] words) {
        List<Integer> list = new ArrayList<>(8);
        Map<String, Integer> map = new HashMap<>();
        int strlen = words[0].length() * words.length;
        Map<String, Integer> wordMap = new HashMap<>(words.length);
        for (int i = 0; i < words.length; i++) {
            int num = wordMap.get(words[i]) == null ? 0 : wordMap.get(words[i]);
            wordMap.put(words[i], num + 1);
        }
        int len = words[0].length();
        for (int j = 0; j <= str.length() - strlen; j++) {
            String string = str.substring(j, j + strlen);
            Map<String, Integer> strMap = new HashMap<>(words.length);
            for (int i = 0; i < strlen; i += len) {
                String subStr = string.substring(i, i + len);
                int num = strMap.get(subStr) == null ? 0 : strMap.get(subStr);
                strMap.put(subStr, num + 1);
            }
            boolean flag = true;
            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                if (!entry.getValue().equals(strMap.get(entry.getKey()))) {
                    flag = false;
                }
            }
            if (flag) {
                list.add(j);
            }
        }
        return list;
    }

    private static Boolean isMergeStr(String string, String[] words) {

        return true;
    }

    private static void soutListNode(ListNode node1) {
        ListNode node = node1;
        do {
            System.out.println(node);
            node = node.next;
        } while (node != null);
    }



    /**
     * 21. 合并两个有序链表
     *
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        }

        ListNode node = node1.val <= node2.val ? node1 : node2;
        ListNode preNode = node;
        ListNode preNode1 = node1.val <= node2.val ? node1.next : node1;
        ;
        ListNode preNode2 = node1.val <= node2.val ? node2 : node2.next;
        while (preNode1 != null && preNode2 != null) {
            if (preNode1.val <= preNode2.val) {
                preNode.next = preNode1;
                preNode1 = preNode1.next;
            } else {
                preNode.next = preNode2;
                preNode2 = preNode2.next;
            }
            preNode = preNode.next;
        }
        if (preNode1 == null) {
            preNode.next = preNode2;
        } else if (preNode2 == null) {
            preNode.next = preNode1;
        }
        return node;

    }

    /**
     * n个城市建立m个基站，一共有多少种方案。1、2、3和1、3、2算一种
     *
     * @param n
     * @param m
     * @return
     */
    public static int jizhanCount(int n, int m) {
        if (n == 1) return 1;
        if (n == 2) return m / 2 + 1;
        if (n > m) return m;
        int count = 0;
        while (m >= 0) {
            count += jizhanCount(n - 1, m);
            m -= n;
        }
        return count;
    }

    public static int maximalRectangle(char[][] matrix) {
        System.out.println("你好");
        return 5;
    }

    /**
     * 1658. 将 x 减到 0 的最小操作数
     *
     * @param nums
     * @param x
     * @return
     */
    public static int minOperations(int[] nums, int x) {
        if (nums[0] > x && nums[nums.length - 1] > x) return -1;
        int left = minOperations(Arrays.copyOf(nums, nums.length - 2), x - nums[0]);
        int right = minOperations(Arrays.copyOfRange(nums, 1, nums.length - 1), x - nums[0]);
        return 0;
    }

    public static int numberOfMatches(int n) {
//        最优解：
//        return n - 1；
        int num = 0;
        while (n > 1) {
            num += n >> 1;
            if ((n & 1) != 0) {
                n++;
            }
            n = n >> 1;
        }
        return num;
    }

    public static int[] searchRange2(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        return result;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (nums[i] == target && nums[j] == target) {
                result[0] = i;
                result[1] = j;
                break;
            }
            if (nums[i] != target) {
                i++;
            }
            if (nums[j] != target) {
                j--;
            }
        }
        return result;
    }

    /**
     * @Author qinchenpu
     * @Date 2021年7月21日
     * @ReturnType char []
     */
    private static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int index = -1;
        char[] hay = haystack.toCharArray();
        haystack.charAt(0);
        char[] need = needle.toCharArray();
        outer:
        for (int i = 0; i <= hay.length - need.length; i++) {
            int j = 0;
            for (; j < need.length; j++) {
                if (hay[i + j] != need[j]) {
                    continue outer;
                }
            }
            if (j == need.length) {
                index = i;
                break;
            }
        }
        return index;

    }

    /**
     * 27. 移除元素
     *
     * @Author qinchenpu
     * @Date 2021年7月21日
     * @ReturnType int
     */
    private static int removeElement(int[] nums, int val) {
        // 元素顺序不变
        // int index = 0;
        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] != val) {
        // nums[index++] = nums[i];
        // }
        // }
        // return index;

        // 双指针，元素顺序可以改变
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == val) {
                nums[start] = nums[end--];
            } else {
                start++;
            }
        }
        return start;
    }

    /**
     * 26. 删除有序数组中的重复项
     *
     * @Author qinchenpu
     * @Date 2021年7月20日
     * @ReturnType char []
     */
    private static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    /**
     * @Author qinchenpu
     * @Date 2021年7月20日
     * @ReturnType Object
     */
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 1 && i < nums.length - 3 && nums[i] == nums[i - 1]) {
                i++;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                while (j - i > 1 && j < nums.length - 2 && nums[j] == nums[j - 1]) {
                    j++;
                }
                int num = target - nums[i] - nums[j];
                int k = j + 1, l = nums.length - 1, sum = nums[k] + nums[l];
                while (k < l) {
                    sum = nums[k] + nums[l];
                    if (sum == num) {
                        List<Integer> subList = new ArrayList<Integer>();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[k]);
                        subList.add(nums[l]);
                        if (!list.contains(subList)) {
                            list.add(subList);
                        }
                        k++;
                        l--;
                    } else if (sum < num) {
                        k++;
                    } else if (sum > num) {
                        l--;
                    }

                }
            }
        }
        return list;

    }

    /**
     * 11. 盛最多水的容器
     *
     * @Author qinchenpu
     * @Date 2021年7月20日
     * @ReturnType char []
     */
    private static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            if (Math.min(height[i], height[j]) * (j - i) > maxArea) {
                maxArea = Math.min(height[i], height[j]) * (j - i);
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    /**
     * 6. Z 字形变换
     *
     * @Author qinchenpu
     * @Date 2021年7月19日
     * @ReturnType char []
     */
    private static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        int tempLen = 2 * numRows - 2;
        int i = 0, j = tempLen;
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            i = k;
            j = tempLen - k;
            while (i < len || j < len) {
                if (i < len) {
                    result.append(s.charAt(i));
                    i += tempLen;
                }
                if (j < len && (i - j) % tempLen != 0) {
                    result.append(s.charAt(j));
                }
                j += tempLen;
            }
        }
        return result.toString();
    }

    /**
     * 5. 最长回文子串
     *
     * @Author qinchenpu
     * @Date 2021年7月19日
     * @ReturnType char []
     */
    private static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] arr = s.toCharArray();
        int start = 0, len = 1;
        for (int index = 0; index < arr.length; index++) {
            int i = index, j = index;
            while (i >= 0 && j < arr.length) {
                if (arr[i] != arr[j]) {
                    break;
                }
                if (j - i + 1 > len) {
                    len = j - i + 1;
                    start = i;
                }
                i--;
                j++;
            }
            i = index;
            j = index + 1;
            while (i >= 0 && j < arr.length) {
                if (arr[i] != arr[j]) {
                    break;
                }
                if (j - i + 1 > len) {
                    len = j - i + 1;
                    start = i;
                }
                i--;
                j++;
            }
        }
        return s.substring(start, start + len);
    }

    /**
     * 4. 寻找两个正序数组的中位数
     *
     * @Author qinchenpu
     * @Date 2021年7月15日
     * @ReturnType char []
     */
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] arr = new int[length];
        int index = 0, i = 0, j = 0;
        while (index < length) {
            if (i > nums1.length - 1) {
                arr[index] = nums2[j++];
            } else if (j > nums2.length - 1) {
                arr[index] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                arr[index] = nums1[i++];
            } else {
                arr[index] = nums2[j++];
            }
            index++;
        }
        double result = 0.0;

        if (length % 2 == 0) {
            result = (arr[length / 2 - 1] + arr[length / 2]) / 2.0;
        } else {
            result = (arr[length / 2]);
        }
        return result;
    }

    /**
     * 2. 两数相加
     *
     * @Author qinchenpu
     * @Date 2021年7月14日
     * @ReturnType ListNode
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, node = null;
        int temp = 0;

        while (l1 != null || l2 != null) {
            int keyA = l1 == null ? 0 : l1.val;
            int keyB = l2 == null ? 0 : l2.val;
            temp = keyA + keyB + temp;
            if (head == null) {
                head = node = new ListNode(temp % 10);
            } else {
                node.next = new ListNode(temp % 10);
                node = node.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            temp = temp / 10;
        }
        if (temp > 0) {
            node.next = new ListNode(temp % 10);
        }
        return head;
    }

    /**
     * 1.两数之和
     *
     * @Author qinchenpu
     * @Date 2021年7月13日
     * @ReturnType int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.get(key) != null) {
                arr[0] = map.get(key);
                arr[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return arr;
    }

    /**
     * 15.三数之和,找出所有【和为 0且不重复】 的三元组
     *
     * @Author qinchenpu
     * @Date 2021年7月13日
     * @ReturnType char []
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            while (i > 0 && i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
            int target = -nums[i];
            for (int j = i + 1, l = nums.length - 1; j < l; ) {
                if (nums[j] + nums[l] == target) {
                    List<Integer> subList = new ArrayList<Integer>();
                    subList.add(nums[i]);
                    subList.add(nums[j]);
                    subList.add(nums[l]);
                    list.add(subList);
                    do {
                        j++;
                    } while (nums[j] == nums[j - 1] && j < l);
                } else if (nums[j] + nums[l] > target) {
                    do {
                        l--;
                    } while (nums[l] == nums[l + 1] && l > j);
                } else {
                    do {
                        j++;
                    } while (nums[j] == nums[j - 1] && j < l);
                }
            }
        }
        return list;
    }

    /**
     * 字符串相乘
     *
     * @Author qinchenpu
     * @Date 2021年7月12日
     * @ReturnType char []
     */
    private static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuilder str = new StringBuilder();
        int temp = 0;
        int i, j, m, n;
        for (int index = num1.length() + num2.length() - 2; index >= 0; index--) {
            i = Math.min(index, num1.length() - 1);
            j = index - i;
            for (; i >= 0 && j < num2.length(); i--, j++) {
                m = num1.charAt(i) - '0';
                n = num2.charAt(j) - '0';
                temp += m * n;
            }
            str.append(temp % 10);
            temp = temp / 10;
        }

        String result = temp + str.reverse().toString();
        if (result.startsWith("0")) {
            result = result.substring(1);
        }
        return result;
    }

    /**
     * @Author qinchenpu
     * @Date 2021年7月8日
     * @ReturnType char []
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = commonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    /**
     * @Author qinchenpu
     * @Date 2021年7月8日
     * @ReturnType Object
     */
    private static String commonPrefix(String strA, String strB) {
        int index = 0;
        int len = Math.min(strA.length(), strB.length());
        while (index < len && strA.charAt(index) == strB.charAt(index)) {
            index++;
        }
        return strA.substring(0, index);
    }

    /**
     * 二叉树中序遍历
     *
     * @Author qinchenpu
     * @Date 2021年7月8日
     * @ReturnType char []
     */
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(list, root);
        return list;
    }

    /**
     * @Author qinchenpu
     * @Date 2021年7月8日
     * @ReturnType void
     */
    private static void inorder(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(list, node.left);
        list.add(node.val);
        inorder(list, node.right);
    }

    /**
     * 最小子序和
     *
     * @Author qinchenpu
     * @Date 2021年7月7日
     * @ReturnType char []
     */
    private static int maxSubArray(int[] nums) {
        int max = nums[0];
        int num = max;
        for (int i = 1; i < nums.length; i++) {
            if (max < 0) {
                max = max > nums[i] ? max : nums[i];
            } else {
                max += nums[i];
            }
            num = max > num ? max : num;
        }
        return max;

    }

    /**
     * @Author qinchenpu
     * @Date 2021年7月7日
     * @ReturnType char []
     */
    private static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            digits = new int[len + 1];
            digits[0] = 1;
        }
        return digits;
    }

    /**
     * 二进制求和
     *
     * @Author qinchenpu
     * @Date 2021年7月7日
     * @ReturnType String
     */
    private static String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tempStr = b;
            b = a;
            a = tempStr;
        }
        a = "0" + a;
        while (a.length() > b.length()) {
            b = "0" + b;
        }
        String str = "";
        char temp = '0';
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == b.charAt(i)) {
                if (temp == '0') {
                    str = "0" + str;
                } else {
                    str = "1" + str;
                }
                if (a.charAt(i) == '1') {
                    temp = '1';
                } else {
                    temp = '0';
                }
            } else {
                if (temp == '0') {
                    str = "1" + str;
                } else {
                    str = "0" + str;
                    temp = '1';
                }
            }
        }
        // 两个参数均为0时的处理
        if (str.startsWith("0")) {
            str = str.substring(1);
        }
        return str;
    }

    /**
     * 楼层有n阶，每次可以爬 1 或 2 个台阶，有多少种不同的方法可以爬到楼顶
     *
     * @Author qinchenpu
     * @Date 2021年7月7日
     * @ReturnType char []
     */
    private static int climbStairs(int n) {
        /** 动态规划 */
        if (n <= 3) {
            return n;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
        /** 递归，效率太低 */
        /*
         * if (n <= 3) { return n; } else { return climbStairs(n - 1) + climbStairs(n -
         * 2); }
         */
    }

    /**
     * @Author qinchenpu
     * @Date 2021年7月6日
     * @ReturnType int
     */
    private static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int start = 0;
        int endNum = x;
        long temp = x / 2;
        while (start != endNum - 1) {
            if (temp * temp > x) {
                endNum = (int) temp;
            } else {
                start = (int) temp;
            }
            temp = (start + endNum) / 2;
        }
        return (int) temp;
    }

    /**
     * 罗马数字转整数 I-1, V-5, X-10, L-50, C-100, D-500, M-1000
     *
     * @Author qinchenpu
     * @Date 2021年7月6日
     * @ReturnType int
     */
    private static int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int total = getEnum(arr[arr.length - 1]);
        for (int i = 0; i < arr.length - 1; i++) {
            if (getEnum(arr[i]) < getEnum(arr[i + 1])) {
                // 通过switch查询，使用静态Map存储键值对空间利用率低
                total -= getEnum(arr[i]);
            } else {
                total += getEnum(arr[i]);
            }
        }
        return total;
    }

    /**
     * @Author qinchenpu
     * @Date 2021年7月6日
     * @ReturnType int
     */
    private static int getEnum(char c) {
        int value = 0;
        switch (c) {
            case 'I':
                value = 1;
                break;
            case 'V':
                value = 5;
                break;
            case 'X':
                value = 10;
                break;
            case 'L':
                value = 50;
                break;
            case 'C':
                value = 100;
                break;
            case 'D':
                value = 500;
                break;
            case 'M':
                value = 1000;
                break;
            default:
                break;
        }
        return value;
    }

    /**
     * 最小公倍数
     *
     * @Author qinchenpu
     * @Date 2021年7月1日
     * @ReturnType int
     */
    private static int minCommonMultiple(int m, int n) {
        // 方法一
        int result = m;
        while (result % n != 0) {
            result += m;
        }
        System.out.println(result);
        // 方法二
        result = m * n / maxCommonDivisor(m, n);
        return result;
    }

    /**
     * 求两数的最大公约数
     *
     * @Author qinchenpu
     * @Date 2021年7月1日
     * @ReturnType int
     */
    private static int maxCommonDivisor(int m, int n) {
        if (m % n == 0) {
            return n;
        } else {
            int temp = m % n;
            m = n;
            n = temp;
            return maxCommonDivisor(m, n);
        }
    }

}
