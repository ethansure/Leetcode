import java.lang.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int maxIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0 ;i--) {
            if (nums[i] < nums[maxIndex]) {
                int j  = nums.length - 1;
                while(nums[j] <= nums[i]) j--;
                swap(nums, i, j);
                break;
            } else {
                maxIndex = i;
            }
        }
        reverse(nums, maxIndex, nums.length-1);
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int low, int high) {
        while(low < high) swap(nums, low++, high--);
    }
}