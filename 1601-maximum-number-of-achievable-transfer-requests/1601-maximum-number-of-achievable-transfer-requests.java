class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[][] matrix = new int[n][n];
        List<int[]> newReq = new ArrayList();
        int self = 0;
        for (int[] r : requests) {
            if (r[0] == r[1]) {
                self++;
            }
            else {
                newReq.add(r);
            }
        }
        
        int[] built = new int[n];
        return recursive(newReq, 0, built, 0) + self;
    }
    
    public int recursive(List<int[]> req, int cur, int[] built, int selected) {
        // System.out.println(String.format("cur: %d, built: %s, selected: %d", cur, Arrays.toString(built), selected));
        if (cur == req.size()) {
            for (int i=0; i<built.length; i++) {
                if (built[i] != 0) {
                    return -1;
                }
            }
            return selected;
        }
        
        int without = recursive(req, cur+1, built, selected);
        built[req.get(cur)[0]]--;
        built[req.get(cur)[1]]++;
        int with = recursive(req, cur+1, built, selected+1);
        built[req.get(cur)[0]]++;
        built[req.get(cur)[1]]--;
        
        return Math.max(without, with);
    }
}