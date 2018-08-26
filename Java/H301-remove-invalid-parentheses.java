class Pair {
    public String s;
    public int i;
    public Pair(String s, int i) {
        this.s = s;
        this.i = i;
    }
}
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<Pair> queue = new LinkedList<>();
        Pair p = new Pair(s, 0);
        queue.offer(p);
        List<String> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            Pair curp = queue.poll();
            String ss = curp.s;
            if (isValid(ss)) {
                res.add(ss);
            } else {
                if (res.isEmpty()) {
                    for(int i = curp.i; i < ss.length(); i++) {
                        if ((ss.charAt(i) == '(' || ss.charAt(i) == ')') && 
                            (i == curp.i || ss.charAt(i - 1) != ss.charAt(i))) {
                            Pair np = new Pair(ss.substring(0, i) + ss.substring(i + 1), i);
                            queue.offer(np);
                        }
                    }
                }
                
            }
        }
        return res;
        
    }
    
    public boolean isValid(String s) {
        int count = 0;
        for(Character c:s.toCharArray()) {
            if(c == '(') {
                count ++;
            } else if (c == ')') {
                count --;
            }
            
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}