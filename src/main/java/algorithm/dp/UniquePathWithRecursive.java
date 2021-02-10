package algorithm.dp;

/**
 * 暴力递归解决查询路径
 *
 * @author shanyb
 */
public class UniquePathWithRecursive {
    
    public int searchPath(int m, int n) {
        return recursivePath(m, n, 0, 0);
    }
    
    private int recursivePath(int m, int n, int i, int j) {
        //边界条件
        if (m == i && n == j) {
            return 0;
        }
        
        //badcase  如果到边界了，就只有一条路
        if (i == m - 1 || j == n - 1) {
            return 1;
        }
        return recursivePath(m, n, i + 1, j) + recursivePath(m, n, i, j + 1);
    }
}
