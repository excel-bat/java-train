package algorithm.normal;

/**
 * 归并排序
 *
 * @author shanyb
 */
public class MergeSorted {
    
    public static void main(String[] args) {
        int[] a = {51, 24, 6, 83, 30, 57};
        mergeSort(a, 0, a.length - 1);
        System.out.println(a);
    }
    
    /**
     * 归并递归
     *
     * @param a
     * @param low
     * @param high
     */
    public static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            //递归合并左侧
            mergeSort(a, low, mid);
            //递归合并右侧
            mergeSort(a, mid + 1, high);
            //左右归并
            merge(a, low, mid, high);
        }
    }
    
    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        //左指针
        int i = low;
        //右指针
        int j = mid + 1;
        
        int k = 0;
        
        //把较小的数先移到数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[k++];
            }
        }
        
        //把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        //把右边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        
        //把新数组中多的数覆盖nums数组
        for (int l = 0; l < temp.length; l++) {
            a[l + low] = temp[l];
        }
    }
}
