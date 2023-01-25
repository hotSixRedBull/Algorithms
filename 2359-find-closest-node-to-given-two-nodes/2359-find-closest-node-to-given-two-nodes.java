class Solution {
    int[] dist1;
    int[] dist2;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        dist1 = new int[n];
        dist2 = new int[n];
        Set<Integer> reachable1 = getReachable(edges, node1, dist1);
        Set<Integer> reachable2 = getReachable(edges, node2, dist2);
        // System.out.println(String.format("r1: %s, r2: %s", reachable1, reachable2));
        // System.out.println(String.format("dist1: %s, dist2: %s", Arrays.toString(dist1), Arrays.toString(dist2)));
        reachable1.retainAll(reachable2);
        List<Integer> li = new ArrayList(reachable1);
        Collections.sort(li, (a, b) -> {
            int diff1 = Math.max(dist1[a],dist2[a]);
            int diff2 = Math.max(dist1[b],dist2[b]);
            if (diff1 == diff2) {
                return a-b;
            }
            return diff1-diff2;
        });
        if (li.size() > 0) {
            return li.get(0);
        }
        return -1;
    }
    
    public Set<Integer> getReachable(int[] edges, int startNode, int[] dist) {
        // System.out.println(">>enter");
        Queue<Integer> q = new ArrayDeque();
        Queue<Integer> nq = new ArrayDeque();
        Set<Integer> visit = new HashSet();
        q.add(startNode);
        visit.add(startNode);
        int d = 0;
        while (q.size() > 0) {
            int cur = q.poll();
            // System.out.println(String.format(">>cur: %d",cur));
            dist[cur] = d;
            int next = edges[cur];
            if (next == -1) {
                if (q.size() == 0) {
                    d++;
                    q = nq;
                    nq = new ArrayDeque();
                }
                continue;
            }
            if (visit.contains(next)) {
                if (q.size() == 0) {
                    d++;
                    q = nq;
                    nq = new ArrayDeque();
                }
                continue;
            }
            nq.add(next);
            visit.add(next);
            if (q.size() == 0) {
                d++;
                q = nq;
                nq = new ArrayDeque();
            }
        }
        return visit;
    }
}
/*
[2,2,3,-1]
0
1
[1,2,-1]
0
2
[1,-1,1]
0
1
[1,-1,1]
2
0
[-1,-1,-1]
2
0
[1,2,3,4,0]
2
0
[1,2,3,4,0]
0
3
[1,2,3,4,0]
3
0
*/