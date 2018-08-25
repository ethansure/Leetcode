class Solution {
    public List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {
            return res;
        }
        backTracking(num, 0, target, "", 0 , 0);
        return res;
    }
    
    public void backTracking(String num, int index, int target, String evl, long pre, long result) {
        if (index == num.length()) {
            if (result == target) res.add(evl);
            return;
        }
        for(int i = index; i < num.length(); i ++) {
            if(i > index && num.charAt(index) == '0') break;
            long curn = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                backTracking(num, i + 1, target, evl + curn, curn, curn); 
            } else {
                // +
                backTracking(num, i + 1, target, evl + "+" + curn, curn,  result + curn); 
                // -
                backTracking(num, i + 1, target, evl + "-" + curn, -curn, result - curn); 
                // *
                backTracking(num, i + 1, target, evl + "*" + curn, pre * curn, result - pre + pre * curn); 
            }

        }
        
        return;
    }
}