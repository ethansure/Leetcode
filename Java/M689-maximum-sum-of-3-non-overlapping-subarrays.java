class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[1];
        }
        
        int[] accsum = new int[nums.length];
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            accsum[i] = sum;
        }
        
        int[][] dp = new int[nums.length + 1][4];
        int[][] id = new int[nums.length + 1][4];
        
        for(int i = 1; i < 4; i ++) {
            for(int j = k - 1; j < nums.length; j++) {
                
                if (j > 0) {
                    dp[j][i] = dp[j - 1][i];
                    id[j][i] = id[j - 1][i];
                }
                
                int tempsum = 0;
                if (j - k < 0) {
                    tempsum = accsum[j];
                } else {
                    tempsum = accsum[j] - accsum[j - k] + dp[j - k][i - 1];
                }
                
                if(j >= 0 && tempsum > dp[j][i]) {
                    dp[j][i] = tempsum;
                    id[j][i] = j - k + 1;
                }
            }
        }
        
        int[] res = new int[3];
        res[2] = id[nums.length - 1][3];
        res[1] = id[res[2] -1][2];
        res[0] = id[res[1] -1][1];
        return res;
        
    }
    
}