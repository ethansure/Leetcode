class Solution {
    public int[] singleNumber(int[] nums) {
        int diffb = 0;
        for (int num : nums) {
            diffb ^= num;
        }
        //get rightmost set bit
        diffb &= - diffb;
        
        int[] singleNums = new int[2];
        for (int num : nums) {
            if ((num & diffb) == 0) {
                singleNums[0] ^= num;
            } else {
                singleNums[1] ^= num;
            }
        }
        return singleNums;
    }
}