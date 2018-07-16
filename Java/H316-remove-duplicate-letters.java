class Solution {
    public String removeDuplicateLetters(String s) {
        int[] counter = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> cstack = new Stack<>();
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            counter[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            
            char cp;
            while(!cstack.isEmpty() && (cp = cstack.peek()) > c &&  counter[cp -'a'] > 0) {
                cstack.pop();
                visited[cp - 'a'] = false;
            }
            
            cstack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder res = new StringBuilder();
        for(char c : cstack) {
            res.append(c);
        }
        return res.toString();
    }
}