class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int windowsize = 0;
        int[] counter = new int[26];
        for(int i = 0; i < s2.length(); i ++) {
            if (windowsize < s1.length()) {
                counter[s1.charAt(i) - 'a'] ++;
                counter[s2.charAt(i) - 'a'] --;
                windowsize ++;
            } else {
                counter[s2.charAt(i) - 'a'] --;
                counter[s2.charAt(i - windowsize) - 'a'] ++;
            }
            if (windowsize == s1.length()) {
                 if(allZero(counter)) return true;
            } 
        }
        return false;
    }
    
    public boolean allZero(int[] nums) {
        for(int n:nums) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}