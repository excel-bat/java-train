package algorithm.strings;

/**
 * @author shanyb
 */
public class LongestSharePrefix {
    
    /**
     * 查找最长公共前缀
     * input = ["flower"，"flow","fly"]
     * output = ["fl"]
     *
     * @return
     */
    private static String queryLongestSharePrefixStr(String[] strs) {
        //边界
        if (strs.length <= 0) {
            return "";
        }
        
        //前缀匹配
        String prefix = strs[0];
        
        //遍历所有的子串
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
                
            }
        }
        return prefix;
        
    }
    
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "fly"};
        System.out.println(queryLongestSharePrefixStr(strs));
    }
}
