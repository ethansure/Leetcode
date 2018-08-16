import java.lang.*;

class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 1) {
            return 0;
        }
        
        Character pre = s.charAt(0);
        int tot = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        for(Character c:s.toCharArray()) {
            if (c == pre) {
                m.put(c, m.getOrDefault(c,0) + 1);
            } else {
                tot += Math.min(m.getOrDefault('1',0), m.getOrDefault('0',0));
                pre = c;
                m.put(c, 1);
            }
        }
        tot += Math.min(m.getOrDefault('1',0), m.getOrDefault('0',0));
        return tot;
    }
}