class Solution {
  public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> map = new HashMap<>();
      int[] res = new int[2];
      for(int i = 0; i < nums.length; i ++) {
          int diff = target - nums[i];
          if (map.containsKey(nums[i])) {
              res[0] = map.get(nums[i]);
              res[1] = i;
              break;
          } else {
              map.put(diff, i);
          }
      }
      return res;
  }
}