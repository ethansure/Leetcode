class Solution {
    public boolean validPalindrome(String s) {
        return validRangePalindrome(s, 0, s.length() - 1, false);
    }
    
    public boolean validRangePalindrome(String s, int l, int h, boolean deleted) {
        if (l >= h) {
            return true;
        }
        
        if (s.charAt(l) == s.charAt(h)) {
            return validRangePalindrome(s, l + 1, h - 1, deleted);
        } else {
            if (deleted == true) {
                return false;
            } else {
                return (validRangePalindrome(s, l + 1, h, true) || validRangePalindrome(s, l, h - 1, true));
            }
        }
    }
}