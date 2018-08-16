class Solution {
    public int maximumSwap(int num) {
        String numstr = String.valueOf(num);
        int nlen = numstr.length();
        int[] nums = new int[nlen];
        int[] dp = new int[nlen];
        for (int i = 0; i < nlen; i++){
            nums[i] = numstr.charAt(i) - '0';
            dp[i] = i;
        }
        
        for(int i = dp.length - 2; i >=0; --i) {
            int cur = nums[dp[i]];
            int pre = nums[dp[i + 1]];
            if(cur <= pre) {
                dp[i] = dp[i + 1];
            }
        }
        for(int i = 0; i < dp.length; ++i) {
            if(dp[i] != i && nums[dp[i]] != nums[i]) {
                int temp = nums[dp[i]];
                nums[dp[i]] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        StringBuffer b = new StringBuffer();
        for(int n:nums) {
            b.append(String.valueOf(n));
        }
        return Integer.valueOf(b.toString());
    }
}