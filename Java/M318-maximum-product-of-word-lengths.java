class Solution {
    public int maxProduct(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        int[] bits = new int[words.length];
        for(int i = 0; i < words.length; ++i) {
            String w = words[i];
            for(int j = 0; j < w.length(); j ++) {
                bits[i] = bits[i] | 1 << (w.charAt(j) - 'a');
            }
        }
        int m = 0;
        for(int i = 0; i < bits.length; ++i) {
            for(int j = i; j < bits.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    int mt = words[i].length() * words[j].length();
                    if (mt > m) {
                        m = mt;
                    }
                }
            }
        }
        return m;
    }
}