class Solution {
    private List<String> res = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        bt(n, 0, 0, "");
        return res;
    }
    
    public void bt(int n, int l, int r, String s) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        if (l < n) {
            bt(n, l + 1, r, s + "(");
        } 
        
        if (r < l) {
            bt(n, l, r + 1, s + ")");
        }
    }
}