package algorithm.strings;

/**
 * 最长回文子串
 *
 * @author shanyb
 */
public class LongestPalindrom {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        
        int maxLen = 1;
        int begin = 0;
        
        //s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();
        
        //枚举所有长度大于1的子串 charArray[i..j]
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    //重置begin 指针
                    begin = i;
                }
            }
        }
        
        return s.substring(begin, begin + maxLen);
    }
    
    /**
     * 校验是否是回文数,头尾指针
     * str[left...right]
     *
     * @param charArray
     * @param left
     * @param right
     * @return
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
