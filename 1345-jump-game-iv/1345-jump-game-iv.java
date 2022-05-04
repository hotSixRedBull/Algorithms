class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> adj = new HashMap();
        
        for (int i=0; i<arr.length; i++) {
            adj.putIfAbsent(arr[i], new ArrayList());
            adj.get(arr[i]).add(i);
        }
        
        Queue<Integer> q = new ArrayDeque();
        Queue<Integer> distq = new ArrayDeque();
        
        
        boolean[] visited = new boolean[arr.length];
        q.add(0);
        distq.add(0);
        visited[0] = true;
        while (q.size() > 0) {
            int cur = q.poll();
            int dist = distq.poll();
            
            if (cur == arr.length-1) {
                return dist;
            }
            if (adj.containsKey(arr[cur])) {
                for (int num : adj.get(arr[cur])) {
                    if (visited[num] == false) {
                        q.add(num);
                        distq.add(dist+1);
                        visited[num] = true;
                    }
                }
                adj.remove(arr[cur]);
            }
            if (cur < arr.length 
                && visited[cur+1] == false) {
                q.add(cur+1);
                distq.add(dist+1);
                visited[cur+1] = true;
            }
            if (cur > 0
               && visited[cur-1] == false) {
                q.add(cur-1);
                distq.add(dist+1);
                visited[cur-1] = true;
            }
        }
        
        return -1;
    }
}