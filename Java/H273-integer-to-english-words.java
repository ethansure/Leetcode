class Solution {
    public final String[] digits = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven" , "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public final String[] tens = {"", "Ten" , "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public final String[] hundreds = {"", "Thousand", "Million", "Billion"};
        
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int count = 0;
        String res = "";
        while (num > 0) {
            if (num % 1000 > 0) {
                res = threeDigits(num % 1000) + hundreds[count] + " " + res;
            }
            num = num / 1000;
            count ++;
        }
        return res.trim();
    }
    
    public String threeDigits(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return digits[num] + " ";
        } else if (num < 100) {
            return tens[ num / 10] + " " + threeDigits(num % 10);
        } else {
            return digits[num / 100] + " Hundred " + threeDigits(num % 100);
        }
    }
}