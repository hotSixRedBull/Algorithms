class Tuple {
    double q;
    double w;
    public Tuple(double quality, double wage) {
        q = quality;
        w = wage;
    }
}

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((t1, t2) -> {
            double compare = t1.w/t1.q - t2.w/t2.q;
            if (compare > 0) {
                return 1;
            }
            else if (compare < 0) {
                return -1;
            }
            return 0;
            });
        for (int i=0; i<quality.length; i++) {
            pq.add(new Tuple(quality[i], wage[i]));
        }
        
        double ans = Double.MAX_VALUE;
        PriorityQueue<Tuple> tupleQ = new PriorityQueue<>((t1, t2) -> Double.compare(t2.q, t1.q));
        double sum = 0;
        double maxRatio = 0;
        for (int i=0; i<k; i++) {
            Tuple popped = pq.poll();
            sum += popped.q;
            maxRatio = popped.w/popped.q;
            tupleQ.add(popped);
        }
            // System.out.println(String.format("sum: %f, maxRatio: %f, sum*maxRatio: %f", sum, maxRatio, sum*maxRatio));
        ans = Math.min(ans, sum*maxRatio);
        while (pq.size() > 0) {
            Tuple removed = tupleQ.poll();
            sum -= removed.q;
            Tuple popped = pq.poll();
            sum += popped.q;
            tupleQ.add(popped);
            maxRatio = popped.w/popped.q;
            // System.out.println(String.format("sum: %f, maxRatio: %f, sum*maxRatio: %f", sum, maxRatio, sum*maxRatio));
            ans = Math.min(ans, sum*maxRatio);
        }
        return ans;
    }
}