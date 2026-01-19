package interview;

/**
 * @author qinchenpu
 * @project leetcode
 * @Date 2022/7/5
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class TongHuaShun {
    public static void main(String[] args) {
        String str = "abcabbdacbefbac";
        //给定一个字符串，打印出不存在相同字符的最长子字符串，例如︰输入"abcabbdacbefbac",打印出最长子字符串为"dacbef";
        String subStr = longestSubStr(str);
        System.out.println(subStr);
    }

    private static String longestSubStr(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        String result = str.substring(0,1);
        String tmpStr = result;
        for (int i = 1; i < str.length(); i++) {
            char charStr = str.charAt(i);
            if (!tmpStr.contains(charStr+"")){
                tmpStr += charStr;
            } else {
                if (tmpStr.length()>result.length()){
                    result = tmpStr;
                }
                int index = tmpStr.indexOf(charStr);
                tmpStr = tmpStr.substring(index+1, tmpStr.length())+charStr;
            }
        }
        if (tmpStr.length()>result.length()){
            result = tmpStr;
        }
        return  result;
    }
}
