class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int n:nums) {
            if(nums[j] != n) {
                nums[++j] = n;
            }
        }
        return ++j;
    }
}