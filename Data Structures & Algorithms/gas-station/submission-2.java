class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length, total = 0, start = 0, tank = 0;
        for(int i = 0; i < n; i++){
            total += gas[i] - cost[i];
            tank += gas[i] - cost[i];
            if(total < 0){
                total = 0;
                start = i + 1;
            }
        }
        if(tank < 0) return -1;
        return start;
    }
}
