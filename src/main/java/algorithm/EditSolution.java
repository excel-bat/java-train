package algorithm;

/**
 * @author shanyb@uxsino.com
 * @title: EditSolution
 * @ticketNO: #
 * @description: 编辑距离DP
 * @create: 2019-10-28 15:53
 */
public class EditSolution {
    
    
    /**
     * 递归版本
     *
     * @param x
     * @param y
     * @param xchar
     * @param ychar
     * @return
     */
    public static int editDistance(int x, int y, char[] xchar, char[] ychar) {
        
        if(x ==0 ){
            return y;
        }
        if(y == 0){
            return  x;
        }
        if(xchar[x]==ychar[y]){ return editDistance(x-1,y-1,xchar,ychar);}
        
        return Math.min(Math.min(editDistance(x-1,y,xchar,ychar)+1,editDistance(x,y-1,xchar,ychar)+1),editDistance(x-1,y-1,xchar,ychar)+1);
        
    }
    
    public static void main(String[] args) {


        char[] xchar = "25433adf".toCharArray();
        char[] ychar = "25436ad3".toCharArray();
        int[] result = new int[xchar.length+ychar.length];
        for (int i = 0; i < result.length-1; i++) {

            result[i] = -1;
        }
        System.out.println(editDistance(xchar.length-1,ychar.length-1,xchar,ychar));
    }
    
    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();
        
        //如果有一个字符串是空串
        if (n * m == 0) {
            return n + m;
        }
        int[][] dp = new int[m + 1][n + 1];
        
        //初始化
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        
        //计算所有的dp 值
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                
            }
        }
        //TODO 有问题
        return dp[m][n];
    }
}
