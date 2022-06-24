class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }
        PriorityQueue<Long> pq = new PriorityQueue<Long>((a, b) -> b.compareTo(a));
        long sum = 0;
        for (int i=0; i<target.length; i++) {
            pq.add((long) target[i]);
            sum += target[i];
        }
        // System.out.println("sum: "+sum);
        return backtrack(pq, sum);
    }
    public boolean backtrack(PriorityQueue<Long> pq, long sum) {
        // System.out.println(String.format("pq: %s, sum: %d", pq, sum));
        if (pq.peek() == 1) {
            return true;
        }
        long top = pq.poll();
        long rest = sum - top;
        if (sum - top > top) {
            return false;
        }
        long newTop = rest == 1 ? 1 : top % rest;
        // System.out.println(String.format("top: %d, newTop: %d, rest: %d", top, newTop, rest));
        if (top == rest + 1) {
            newTop = 1;
        }
        if (newTop == 0) {
            return false;
        }
        pq.add(newTop);
        return backtrack(pq, rest+newTop);
    }
}

/*
[9,3,5]
[1,1,1,2]
[8,5]
[1,1,2]
[1,1000000000]
[1]
[2]
[3]
*/