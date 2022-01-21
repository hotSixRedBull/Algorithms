class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] gasAcc = new int[gas.length];
        int gasSum = 0;
        int[] costAcc = new int[cost.length];
        int costSum = 0;
        Queue<Integer> candidates = new ArrayDeque<>();
        for (int i=0; i<gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            gasAcc[i] = gasSum;
            costAcc[i] = costSum;
            if (gas[i] > cost[i] || (gas[i] == cost[i] && gas[i] != 0)) {
                candidates.add(i);
            }
        }
        
        if (gasSum < costSum) {
            return -1;
        }
        //System.out.println("candidates: "+candidates);
        int ans = -1;
        for (int candidate : candidates) {
            int curGas = 0;
            boolean hasEnoughGas = true;
            for (int i = candidate; i<gas.length; i++) {
                curGas += gas[i];
                curGas -= cost[i];
                if (curGas < 0) {
                    hasEnoughGas = false;
                    break;
                }
            }
            if (!hasEnoughGas) {
                continue;
            }
            for (int i = 0; i<candidate; i++) {
                curGas += gas[i];
                curGas -= cost[i];
                if (curGas < 0) {
                    hasEnoughGas = false;
                    break;
                }
            }
            if (!hasEnoughGas) {
                continue;
            }
            ans = candidate;
            break;
        }
        return ans;
    }
}