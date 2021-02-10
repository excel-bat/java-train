package algorithm.normal;

/**
 * 快排
 *
 * @author shanyb
 */
public class QuickSorted {
    
    public void quickSort(int[] a, int start, int end) {//递归快排
        if (start < end) {
            quickSort(a, start, partition(a, start, end) - 1);
            quickSort(a, partition(a, start, end) + 1, end);
        }
    }
    
    
    /**
     * 找到支点
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] a, int start, int end) {
        //找到支点
        int pivot = a[start];
        //把比pivot 大的移动到右边
        while (start < end) {
            while (start < end && a[end] <= pivot) {
                end--;
            }
            a[start] = a[end];
            
            while (start < end && a[start] >= pivot) {
                start++;
            }
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;
        
    }
}
