class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        } else {
            String ns = Integer.toString(n, 2);
            int oneCount = 0;
            for (int i = 0; i < ns.length(); i++) {
                if (ns.charAt(i) == '1') {
                    oneCount ++;
                }
                if (oneCount == 2) {
                    break;
                }
            }
            return oneCount == 1;
        }  
    }
}