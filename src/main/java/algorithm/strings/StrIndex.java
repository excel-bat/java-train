package algorithm.strings;

/**
 * 字符串索引
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * @author shanyb
 */

public class StrIndex {
    
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i < n - m + 1; i++) {
            String sub = haystack.substring(i, i + m);
            if (sub.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
    
    public int strIndexOf(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i < n - m + 1; i++) {
            String sub = haystack.substring(i, i + m);
            if (sub.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
