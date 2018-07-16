class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
           @Override
           public int compare(int[] a, int[] b){
               return a[0]==b[0]?a[1]-b[1]:b[0]-a[0];
           }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            System.out.print(cur[1]);
            res.add(cur[1],cur);       
        }
        return res.toArray(new int[people.length][]);
    }
}