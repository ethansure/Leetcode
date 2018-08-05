class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int p = 0;
        int ct = 0;
        for(int i = n-1;i >= p;i--){
            if(p < i && people[i] + people[p] <= limit){
                p++;
            }
            ct++;
        }
        return ct;
    }
}