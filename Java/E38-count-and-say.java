class Solution {
    public String countAndSay(int n) {
        String res = "1$";
        while(n > 1) {
            int count = 0;
            Character pre = res.charAt(0);
            String nextres = "";
            for (Character c:res.toCharArray()) {
                if (pre == c) {
                    count ++;
                } else {                    
                    nextres += String.valueOf(count) + String.valueOf(pre);
                    pre = c;
                    count = 1;
                }
            }
            res = nextres + "$";
            n --;
        }
        return res.substring(0, res.length() - 1);
    }
}