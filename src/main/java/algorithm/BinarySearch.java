package algorithm;

/**
 * @author shanyb@uxsino.com
 * @title: BinarySearch
 * @ticketNO: #
 * @description: 二分查找
 * @create: 2019-10-26 16:25
 */
public class BinarySearch {
    static int target = 40;
    public static void main(String[] args) {
        int[] a = {3,4,7,8,10,20,40,1000,35500};

       int index =  binaryS(a,0,a.length+1);
        System.out.println(">>> res : " + index);

    }

    public static int  binaryS(int[] a,int start,int end){
        int mid =  (start+end)/2+1;
        if(a[mid] < target){
          return   binaryS(a,mid,end);
        }else if(a[mid] > target){
          return   binaryS(a,start,mid);
        }else{
            return mid;
        }
    }
    
    /**
     * 搜索旋转数组的目标值
     */
    public static int searchRotateArray(int[] nums, int target) {
        
        int low = 0, high = nums.length - 1, mid = 0;
        
        while (low < high) {
            //保证奇数个和偶数个数都可用
            mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            //先根据nums[mid]与nums[low]的关系判断mid 是在左段还是右段
            if (nums[mid] >= nums[low]) {
                //大于则左段有序
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[low] && target < nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                //否则右段有序
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
