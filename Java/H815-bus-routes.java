class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> m = new HashMap<>();
        for(int i = 0 ; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j ++) {
                m.putIfAbsent(routes[i][j], new ArrayList<Integer>());
                m.get(routes[i][j]).add(i);
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(S);
        int numRoute = 0;
        while(!q.isEmpty()) {
            numRoute ++;
            int presize = q.size();
            for(int i = 0; i < presize; i++) {
                int station = q.poll();
                List<Integer> rs = m.getOrDefault(station, new ArrayList<Integer>());
                for(int bus:rs) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);                
                    int[] route = routes[bus];
                    for(int j = 0; j < route.length; j++) {
                        if (route[j] == T) {
                            return numRoute;
                        } else {
                            q.add(route[j]);
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}