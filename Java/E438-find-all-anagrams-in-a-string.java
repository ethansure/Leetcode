class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> idx = new ArrayList<>();
        if (s.length() == 0 || p.length() > s.length()) {
            return idx;
        }
        
        int[] m = new int[26];
        for(Character c:p.toCharArray()) {
            m[c -'a']++; 
        }
        int l = 0;
        int r = 0;
        int pcount = p.length();
        while(r < s.length()) {
            Character rc = s.charAt(r++);
            if (m[rc - 'a']-- >= 1) pcount--;
            if (pcount == 0 ) idx.add(l);
        
            if (r - l == p.length()){
                Character lc = s.charAt(l++);
                if (m[lc - 'a'] ++ >= 0) pcount++;
            }
        }
        return idx;
    }
}