class Solution {
    public int maxSubArray(int[] nums) {
        int cur = nums[0], end = nums[0];
        for (int i = 1;i < nums.length; i++){
            end = Math.max( end + nums[i], nums[i]);
            cur = Math.max(cur, end);	
        }
        return cur;
    }
}