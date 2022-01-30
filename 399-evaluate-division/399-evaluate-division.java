class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<String>> adjMap = new HashMap();
        HashMap<String, Double> valueMap = new HashMap();
        for (int i=0; i<equations.size(); i++) {
           List<String> equation = equations.get(i);
           if(!adjMap.containsKey(equation.get(0))) {
               adjMap.put(equation.get(0), new ArrayList());
           } 
           adjMap.get(equation.get(0)).add(equation.get(1));
           valueMap.put(String.format("%s,%s", equation.get(0), equation.get(1)), values[i]);
           if(!adjMap.containsKey(equation.get(1))) {
               adjMap.put(equation.get(1), new ArrayList());
           } 
           adjMap.get(equation.get(1)).add(equation.get(0));
           valueMap.put(String.format("%s,%s", equation.get(1), equation.get(0)), 1/values[i]);
            
        }
        
        List<Double> opResults = new ArrayList();
        for (List<String> query : queries) {
            // System.out.println("query: "+query);
            String target = query.get(1);
            String start = query.get(0);
            if (!adjMap.containsKey(start)) {
                opResults.add(-1.0);
                continue;
            }
            Queue<String> q = new ArrayDeque();
            Queue<Double> valQ = new ArrayDeque();
            Queue<Set<String>> visitedQ = new ArrayDeque();
            q.add(start);
            valQ.add(1.0);
            Set<String> set = new HashSet();
            set.add(start);
            visitedQ.add(set);
            double opResult = -1;
            while (q.size() > 0) {
                String cur = q.poll();
                double val = valQ.poll();
                Set<String> visited = visitedQ.poll();
                // System.out.println(cur);
                if (cur.equals(target)) {
                    opResult = val;
                    break;
                }
                if (!adjMap.containsKey(cur)) {
                    continue;
                }
                for (String candidate : adjMap.get(cur)) {
                    String key = String.format("%s,%s", cur, candidate);
                    if (valueMap.containsKey(key) && !visited.contains(candidate)) {
                        q.add(candidate);
                        valQ.add(val*valueMap.get(key));
                        visited.add(candidate);
                        visitedQ.add(visited);
                    }
                }
            }
            opResults.add(opResult);
        }
        return opResults.stream().mapToDouble(d -> d).toArray();
    }
}