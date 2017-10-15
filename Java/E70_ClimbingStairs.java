class Solution {
    public int climbStairs(int n) {
        int i = 1, j = 1;
        while (n-- > 0)
            i = (j += i) - i;
        return i;
    }
}-