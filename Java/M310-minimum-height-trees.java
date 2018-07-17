class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        } 

        List<Set<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) graph.add(new HashSet<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (graph.get(i).size() == 1) leaves.add(i);
        }
        
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = graph.get(i).iterator().next();
                graph.get(j).remove(i);
                if (graph.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
        
    }
}