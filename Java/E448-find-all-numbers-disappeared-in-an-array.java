class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int index = nums[i] % n;
            nums[index] += n;
        }
        for(int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                if (i - 1 < 0) {
                    res.add(n);
                } else {
                    res.add(i);
                }
            }
        }
        return res;
    }
}