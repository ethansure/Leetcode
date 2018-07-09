
import java.lang.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxlength = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            maxlength = Math.max(i - left + 1, maxlength);
            map.put(c, i);
        }
        return maxlength;
        
    }
}