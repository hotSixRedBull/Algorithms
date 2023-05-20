class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adj = new HashMap();
        for (int i=0; i<equations.size(); i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            adj.putIfAbsent(a, new HashMap());
            adj.putIfAbsent(b, new HashMap());
            adj.get(a).put(b, values[i]);
            adj.get(b).put(a, 1/values[i]);
        }
        
        double[] results = new double[queries.size()];
        Arrays.fill(results, -1);
        for (int i=0; i<queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            if (adj.containsKey(start) == false) {
                continue;
            }
            Queue<String> q = new ArrayDeque();
            Queue<Double> rq = new ArrayDeque();
            Set<String> visit = new HashSet();
            q.add(start);
            rq.add((double) 1);
            visit.add(start);
            while (q.size() > 0) {
                String cur = q.poll();
                double result = rq.poll();
                if (cur.equals(end)) {
                    results[i] = result;
                    break;
                }
                for (Map.Entry<String, Double> nei : adj.get(cur).entrySet()) {
                    if (visit.contains(nei.getKey())) {
                        continue;
                    }
                    visit.add(nei.getKey());
                    q.add(nei.getKey());
                    rq.add(result*nei.getValue());
                }
            }
        }
        return results;
    }
}