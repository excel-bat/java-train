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
}
