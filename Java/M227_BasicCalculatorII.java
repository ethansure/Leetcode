class Solution {
    public int calculate(String s) {
        if (s == null) return 0;
        s = s.trim().replaceAll(" +", "");
        int length = s.length();

        int res = 0;
        long preVal = 0; 
        char sign = '+'; 
        int i = 0;
        while (i < length) {
            long curVal = 0;
            while (i < length && (int)s.charAt(i) <= 57 && (int)s.charAt(i) >= 48) { 
                curVal = curVal*10 + (s.charAt(i) - '0');
                i++;
            }
            if (sign == '+') {
                res += preVal;  
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;  
                preVal = -curVal;
            } else if (sign == '*') {
                preVal = preVal * curVal; 
            } else if (sign == '/') {
                preVal = preVal / curVal; 
            }
            if (i < length) { 
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }
}