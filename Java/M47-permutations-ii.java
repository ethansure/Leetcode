class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> pt = new ArrayList<>();
        Arrays.sort(nums);
        permute(nums, used, pt);
        return res;
    }
    
    public void permute(int[] nums, boolean[] used, List<Integer> pt) {
        if (pt.size() == nums.length) {
            res.add(new ArrayList<>(pt));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            pt.add(nums[i]);
            used[i] = true;
            permute(nums, used, pt);
            used[i] = false;
            pt.remove(pt.size() - 1);
        }
    }
}