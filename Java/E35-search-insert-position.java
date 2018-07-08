class Solution {
  public int bsearch(int[] nums, int target, int l, int r) {
      if (r < l) {
          return l;
      }
      if (l == r) {
          if (target > nums[l]) {
              return l + 1;
          } else {
              return l;
          }
      } else {
          int mid = (l + r) / 2;
          if (nums[mid] > target) {
              return bsearch(nums, target, l, mid - 1);
          } else if(nums[mid] < target) {
              return bsearch(nums, target, mid + 1, r);
          } else {
              return mid;
          }
      }
  }
  
  public int searchInsert(int[] nums, int target) {
      return bsearch(nums, target, 0, nums.length-1);
  }
}