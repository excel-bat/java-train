package algorithm;

/**
 * @author shanyb@uxsino.com
 * @title: RobSolution
 * @ticketNO: #198 leetcode
 * @description: 动态规划解决抢劫问题
 * @create: 2019-10-28 15:03
 */
public class RobSolution {


  public static int rob(int[] nums){
      return  solve(nums.length-1,nums);
  }

    private static int solve(int idx, int[] nums) {
      if(idx < 0){
          return 0;
      }





      return  Math.max(solve(idx-2,nums)+nums[idx],solve(idx-1,nums));
    }


    public static void main(String[] args) {
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        int[] nums1 = {2,7,9,3,1};
        System.out.println( rob(nums1));
    }
}
