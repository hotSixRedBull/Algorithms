class Solution {
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> stopToRoute = new HashMap();
        Map<Integer, Map<Integer, Integer>> routeToStopToIndex = new HashMap();
        for (int i=0; i<routes.length;i++) {
            int[] r = routes[i];
            routeToStopToIndex.put(i, new HashMap());
            for (int j=0; j<r.length; j++) {
                int stop = r[j];
                stopToRoute.putIfAbsent(stop, new ArrayList());
                stopToRoute.get(stop).add(i);
                routeToStopToIndex.get(i).put(stop, j);
            }
        }
        
        Queue<int[]> q = new ArrayDeque();
        Map<Integer, Integer> stopVisit = new HashMap();
        Set<Integer> routeVisit = new HashSet();
        stopVisit.put(source, 0);
        for (int route : stopToRoute.get(source)) {
            q.add(new int[]{route, source, 0});
            routeVisit.add(route);
        }
        
        int min = Integer.MAX_VALUE;
        while (q.size() > 0) {
            int[] cur = q.poll();
            int route = cur[0];
            int stop = cur[1];
            int dist = cur[2];
            // System.out.println(String.format("route: %d, stop: %d, dist: %d", route, stop, dist));
            if (stop == target) {
                min = Math.min(min, dist);
                continue;
            }
            int routeLen = routes[route].length;
            int start = routeToStopToIndex.get(route).get(stop);
            for (int i=start+1; i<routeLen; i++) {
                int nextStop = routes[route][i];
                int togo = 1;
                if (nextStop == target) {
                    min = Math.min(min, dist+togo);
                }
                if (stopVisit.containsKey(nextStop)
                   && stopVisit.get(nextStop) <= dist+togo) {
                    continue;
                }
                stopVisit.put(nextStop, dist+togo);
                for (int r : stopToRoute.get(nextStop)) {
                    if (routeVisit.contains(r)) {
                        continue;
                    }
                    routeVisit.add(r);
                    q.add(new int[]{r, nextStop, dist+togo});
                }
            }
            for (int i=0; i<start; i++) {
                int nextStop = routes[route][i];
                int togo = 1;
                if (nextStop == target) {
                    min = Math.min(min, dist+togo);
                }
                if (stopVisit.containsKey(nextStop)
                   && stopVisit.get(nextStop) <= dist+togo) {
                    continue;
                }
                stopVisit.put(nextStop, dist+togo);
                for (int r : stopToRoute.get(nextStop)) {
                    if (routeVisit.contains(r)) {
                        continue;
                    }
                    routeVisit.add(r);
                    q.add(new int[]{r, nextStop, dist+togo});
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}