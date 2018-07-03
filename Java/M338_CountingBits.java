class Solution {
    public int[] countBits(int num) {
        int[] bcount = new int[num + 1];
        for (int i = 1; i<= num; i++) {
            int l = i & i - 1;
            bcount[i] = bcount[l] + 1;
        }
        return bcount;
    }
}