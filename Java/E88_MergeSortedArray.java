class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = nums1.length - 1; i >= 0; --i) {
            if(m > 0 && n > 0) {
                if(nums1[m - 1] > nums2[n - 1]) {
                    nums1[i] = nums1[m - 1];
                    m--;
                } else {
                    nums1[i] = nums2[n - 1];
                    n--;
                }
            } else {
                if (m == 0) {
                    nums1[i] = nums2[n - 1];
                    n --;
                } else {
                    nums1[i] = nums1[m- 1];
                    m --;
                }
            }
        }
    }
}
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n- 1, np = nums1.length -1;
        while (p1 >= 0 & p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[np--] = nums1[p1--];
            } else {
                nums1[np--] = nums2[p2--];
            }
        }
        while (p2 >= 0) {
            nums1[np--] = nums2[p2--];
        }
        
    }
}