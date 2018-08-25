class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
                int low = i + 1;
                int high = nums.length - 1;
                while(low < high) {
                    int total = nums[i] + nums[low] + nums[high];
                    if (total == 0) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low + 1]) low++;
                        while(low < high && nums[high] == nums[high - 1]) high--;
                        low ++;
                        high --;
                    } else if (total < 0) {
                        low++;
                    } else if (total > 0) {
                        high--;
                    }
                }
            }
            
            
        }
        return res;
    }
}

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);
      for(int i = 0; i < nums.length - 2; i++) {
          if (i > 0 && nums[i - 1] == nums[i]) {
              continue;
          }
          int l = i + 1;
          int r = nums.length - 1;
          while (l < r) {
              int tot = nums[i] + nums[l] + nums[r];
              if (tot < 0) {
                  l += 1;
              } else if (tot > 0) {
                  r -= 1;
              } else {
                  List<Integer> triple = new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
                  res.add(triple);
                  do {
                      l += 1;
                  } while(l < r && nums[l] == nums[l-1]);
                  
                  do {
                      r -= 1;
                  } while(l < r && nums[r] == nums[r + 1]);
                 
              }
          }
      }
      return res;
  }
}