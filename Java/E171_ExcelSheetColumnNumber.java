class Solution {
    public int titleToNumber(String s) {
        int length = s.length();
        int number = 0;
        for(int i = 0; i < length; i++) {
            number = number * 26 + (s.charAt(i) - 'A' + 1);
        }
        return number;
    }
}