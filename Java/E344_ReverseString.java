class Solution {
    public String reverseString(String s) {
        String rev = "";
        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();    
        while (l <= r) {
            char t = chars[l];
            chars[l] = chars[r];
            chars[r] = t;
            l ++;
            r --;
        }
        return String.valueOf(chars);
    }
}