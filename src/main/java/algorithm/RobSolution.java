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
    
    private static int solveWithDp(int idx, int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        //初始化dp 数组
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        
        return dp[nums.length];
    }
    
    
    public static void main(String[] args) {
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        int[] nums1 = {2,7,9,3,1};
        System.out.println( rob(nums1));
    }
}
