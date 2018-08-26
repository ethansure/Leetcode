class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> counterMap = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> counterMap.get(a) == counterMap.get(b)? b.compareTo(a) : counterMap.get(a) - counterMap.get(b)
        );
        
        for (String w:words) {
            counterMap.put(w, counterMap.getOrDefault(w,0) + 1);
        }
        
        for (String w: counterMap.keySet()) {
            pq.offer(w);
            if (pq.size() > k) pq.poll();
        }
        
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        return res;
    }
}