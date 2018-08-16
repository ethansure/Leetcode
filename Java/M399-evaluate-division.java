class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> t = new HashMap<>();
        for(int i = 0; i < equations.length; i++) {
            String[] e = equations[i];
            if (!t.containsKey(e[0])) {
                t.put(e[0], new HashMap<>());
            }
            if (!t.containsKey(e[1])) {
                t.put(e[1], new HashMap<>());
            }
            t.get(e[0]).put(e[0], 1.0);
            t.get(e[1]).put(e[1], 1.0);
            t.get(e[0]).put(e[1], values[i]);
            t.get(e[1]).put(e[0], 1 / values[i]);
        }

        for(String midKey:t.keySet()) {
            for(String srcKey:t.get(midKey).keySet()) {
                for(String dstKey:t.get(midKey).keySet()) {
                    double val = t.get(srcKey).get(midKey) * t.get(midKey).get(dstKey);
                    t.get(srcKey).put(dstKey, val);
                }
            }
        }
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i ++){
            String[] q = queries[i];
            res[i] = t.getOrDefault(q[0],new HashMap<>()).getOrDefault(q[1],-1.0);
        }
        return res;
    }
}