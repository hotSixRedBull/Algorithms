class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        // System.out.println(10001%14);
        HashMap<Integer, Integer> map = new HashMap();
        int[] cur = cells;
        map.put(toInteger(cur), 0);
        int duration = 0;
        int start = 0;
        for (int i=1; i<=n; i++) {
            int[] nextState = getNextState(cur);
            int next = toInteger(nextState);
            // System.out.println(String.format("cells: %s, sum: %d", Arrays.toString(nextState), next));
            cur = nextState;
            if (map.containsKey(next)) {
                start = map.get(next);
                duration = i-map.get(next);
                // System.out.println("start: "+start);
                // System.out.println("duration: "+duration);
                break;
            }
            map.put(next, i);
        }
        
        if (duration != 0) {
            int left = (n-start) % duration;
            // System.out.println("left: "+left);
            cur = cells;
            for (int i=0; i<start+left; i++) {
                int[] nextState = getNextState(cur);
                cur = nextState;
            }
        }
        return cur;
    }
    
    public int[] getNextState(int[] cells) {
        int[] ans = new int[8];
        ans[0] = 0;
        ans[7] = 0;
        for (int i=1; i<7; i++) {
            if (cells[i-1] == cells[i+1]) {
                ans[i] = 1;
            }
            else {
                ans[i] = 0;
            }
        }
        return ans;
    }
    
    public int toInteger(int[] cells) {
        int sum = 0;
        for (int i=0; i<8; i++) {
            sum *= 2;
            sum += cells[i];
        }
        // System.out.println(String.format("cells: %s, sum: %d", Arrays.toString(cells), sum));
        return sum;
    }
    
    public int[] toArray(int cellState) {
        int[] ans = new int[8];
        for (int i=0; i<8; i++) {
            ans[i] = cellState & (1 << 7-i);
        }
        
        // System.out.println(String.format("cellState: %s, cells: %s", Integer.toBinaryString(cellState),  Arrays.toString(ans)));
        return ans;
    }
}