// class Solution {
//     public boolean isPalindrome(String s) {
//         String letterAndDigit = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
//         String revLetterAndDigit = new StringBuffer(letterAndDigit).reverse().toString();
//         return letterAndDigit.equals(revLetterAndDigit);
//     }
// }

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char leftStr, rightStr;
        String ss = s.toLowerCase();
        while (left < right) {
            leftStr = ss.charAt(left);
            rightStr = ss.charAt(right);
            if ( !Character.isLetterOrDigit(leftStr)) {
                left ++;
            } else if (!Character.isLetterOrDigit(rightStr)) {
                right --;
            } else {
                if ( leftStr != rightStr) {
                    return false;
                } else{
                    left ++;
                    right --;
                }
            }
        }
        return true;
    }
}