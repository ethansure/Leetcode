class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
                for(int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || (j > i + 1 && nums[j - 1] != nums[j])) {
                        int low = j + 1;
                        int high = nums.length - 1;
                        while (low < high) {
                            int total = nums[i] + nums[j] + nums[low] + nums[high];
                            if (total == target) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while(low < high && (nums[low] == nums[low + 1])) low++;
                                while(low < high && (nums[high - 1] == nums[high])) high--;
                                low ++;
                                high --;
                            } else if (total < target) {
                                low ++;
                            } else if (total > target) {
                                high --;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}