package algorithm.normal;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * top k 问题解决
 *
 * @author shanyb
 */
public class TopKSolution {
    
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 6};
        
    }
    
    public int[] findTopkWithSort(int a[], int k) {
        Arrays.sort(a);
        int[] res = new int[k];
        
        for (int i = 0; i < 5; i++) {
            res[i] = a[i];
        }
        return res;
    }
    
    /**
     * 最小的k个数，大顶堆
     *
     * @param a
     * @param k
     * @return
     */
    public int[] findTopkWithQueue(int a[], int k) {
        int[] vec = new int[k];
        // 排除 0 的情况
        if (k == 0) {
            return vec;
        }
        //大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(a[i]);
        }
        
        for (int i = k; i < a.length - 1; i++) {
            if (priorityQueue.peek() > a[i]) {
                priorityQueue.poll();
                priorityQueue.offer(a[i]);
            }
        }
        
        for (int j = 0; j < k; j++) {
            vec[j] = priorityQueue.poll();
        }
        
        return vec;
    }
}
