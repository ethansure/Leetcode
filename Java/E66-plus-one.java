class Solution {
    public int[] plusOne(int[] digits) {
        int incre = 1;
        for(int i = digits.length - 1; i >= 0; --i) {
            int tot = digits[i] + incre;
            if (tot >= 10) {
                digits[i] = tot % 10;
            } else {
                digits[i] = tot;
            }
            incre = tot / 10;

        }
        if (incre > 0) {
            int[] newdigits = new int[digits.length + 1];
            newdigits[0] = incre;
            for (int i = 1; i < digits.length + 1; i ++) {
                newdigits[i] = digits[i-1];
            }
            return newdigits;
        } else {
            return digits;
        }
    }
}