class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> rq = new PriorityQueue();
        int n = dist.length;
        for (int i=0; i<n; i++) {
            //dist - speed*t = 0
            //dist = speed*t
            //t = dist/speed
            rq.add((int)Math.ceil((double)dist[i]/(double)speed[i]));
        }
        System.out.println(rq);
        int t = 1;
        rq.poll();
        while (rq.size() > 0) {
            int monster = rq.poll();
            if (t >= monster) {
                return t;
            }
            t++;
        }
        return n;
    }
}

/*
[3,5,7,4,5]
[2,3,6,3,2]
->[2,2,2,2,3]
*/