class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int tank =  gas[start] - cost[start];
        while(start > end) {
            if (tank < 0) {
                start --;
                tank += gas[start] - cost[start];
            } else {
                tank += gas[end] - cost[end];
                end ++;
            }
        }
        return tank >= 0? start:-1;
    }
}