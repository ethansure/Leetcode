class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] links = new int[n];
        Arrays.fill(links, -1);
        for (int i = 0; i < edges.length; i++) {
            int a = find(links,edges[i][0]);
            int b = find(links,edges[i][1]);
            if (a == b) {
                return false;
            }
            links[a] = b;
        }
        return edges.length == n - 1;
    }
    
    public int find(int links[], int num) {
        while (links[num] != -1) {
            num = links[num];
        }
        return num;
    }
}