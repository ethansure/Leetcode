import java.lang.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        for(int i = 0; i < nums.length - 2; i ++) {
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if ( sum > target) {
                    high --;
                } else {
                    low ++;
                }
                
                if (Math.abs(target - res) > Math.abs(target - sum)) {
                    res = sum;
                }
            }
        }
        return res;
    }
}