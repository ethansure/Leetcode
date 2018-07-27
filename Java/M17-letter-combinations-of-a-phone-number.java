class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] m = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        res.add("");
        for(int i = 0; i < digits.length(); i++) {
            int index = Integer.valueOf(Character.toString(digits.charAt(i)));
            String cell = m[index];
            List<String> temp = new ArrayList<>();
            for(int j = 0; j < res.size(); j++) {
                for(int k = 0; k < cell.length(); k++)
                temp.add(res.get(j) + Character.toString(cell.charAt(k)));
            }
            res = temp;
        }
        return res;
    }
}