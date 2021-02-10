package algorithm.dp;

import java.util.Arrays;

/**
 * @author shanyb
 */
public class UniquePathWithCache {
    
    private int[][] cache;
    
    public int searchPath(int m, int n) {
        cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            Arrays.fill(temp, -1);
            cache[i] = temp;
        }
        return cacheRecursize(m, n, 0, 0);
    }
    
    
    private int cacheRecursize(int m, int n, int i, int j) {
        if (i == m - 1 || j == n - 1) {
            return 1;
        }
        
        if (cache[i][j] == -1) {
            cache[i][j] = cacheRecursize(m, n, i + 1, j) + cacheRecursize(m, n, i, j + 1);
        }
        return cache[i][j];
    }
}
