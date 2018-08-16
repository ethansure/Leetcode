class NumArray {
    public HashMap<Integer, Integer> map = new HashMap<>();
    public NumArray(int[] nums) {
        int cur = 0;
        for(int i = 0; i < nums.length; i++) {
            cur += nums[i];
            map.put(i, cur);
        } 
    }
    
    public int sumRange(int i, int j) {
        if (i > 0) {
            return map.get(j) - map.get(i - 1);
        } else {
            return map.get(j);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */