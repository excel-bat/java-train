package algorithm.strings;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 无重复最长子串
 *
 * @author shanyb
 */
public class LongestSubstring {
    /**
     * 最长无重复公共子串
     *
     * @param s
     * @return
     */
    public int longestOfSubString(String s) {
        //边界情况
        if (s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> window = Maps.newHashMap();
        
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            //step2 滤重
            if (window.containsKey(s.charAt(i))) {
                //避免清空map 中的老数据
                left = Math.max(left, window.get(s.charAt(i) + 1));
            }
            //step 1 ,初始数据
            window.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
