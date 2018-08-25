import java.lang.*;
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int h = 0;
        int pre = 0;
        int minsub = nums.length + 1;
        while(h < nums.length) {
            pre += nums[h++];
            while(pre >= s) {
                minsub = Math.min(minsub, h - l);
                pre -= nums[l++];
            }
        }
        return minsub == nums.length + 1? 0: minsub;
    }
}