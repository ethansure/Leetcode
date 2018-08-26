class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) -map.get(b));
        for(int num : map.keySet()) {
            pq.offer(num);
            if(pq.size() > k) pq.poll();
        }
        
        List<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        return res;
    }
}