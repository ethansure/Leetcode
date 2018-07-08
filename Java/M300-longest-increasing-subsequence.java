import java.util.PriorityQueue;

class Solution {
    public int bsearch(int[] nums, int low, int high, int key) {
        while(low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if(nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    
    public int lengthOfLIS(int[] nums) {
        int[] ss = new int[nums.length];
        int maxlen = 0;
        for(int num:nums) {
            int index = bsearch(ss, 0, maxlen - 1, num);
            ss[index] = num;
            if (index == maxlen) maxlen ++;
        }
        return maxlen;
    }
}