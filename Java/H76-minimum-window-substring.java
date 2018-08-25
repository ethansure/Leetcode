class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) {
            return "";
        }
        
        Map<Character,Integer> m = new HashMap<>();
        for(Character c:t.toCharArray()) {
            m.put(c, m.getOrDefault(c,0) + 1);
        }
        int mw = s.length() + 1;
        String res = "";
        int counter = t.length();
        int l = 0;
        int r = 0;
        while(r < s.length()) {
            Character curc = s.charAt(r++);
            if (m.containsKey(curc)) {
                int c = m.get(curc);
                m.put(curc, --c);
                if (c >= 0) {
                    counter--;
                }
                while(counter == 0) {
                    if (r - l < mw) {
                        mw = r - l;
                        res = s.substring(l, r);
                    }
                    Character leftc = s.charAt(l++);
                    if (m.containsKey(leftc)) {
                        int lc = m.get(leftc);
                        m.put(leftc, ++lc);
                        if (lc > 0) {
                            counter ++;
                        }
                    }
                }
            }
            
        }
        return res;
    }
}