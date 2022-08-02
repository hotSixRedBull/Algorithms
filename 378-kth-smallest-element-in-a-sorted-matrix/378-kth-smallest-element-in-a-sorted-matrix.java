class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder()); 
        for (int r=0; r<matrix.length; r++) {
            for (int c=0; c<matrix[r].length; c++) {
                if (pq.size() < k) {
                    pq.add(matrix[r][c]);
                }
                else if (pq.peek() > matrix[r][c]) {
                    pq.add(matrix[r][c]);
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}
/*
A1. sort, O(n^2logn)
A2. maxHeap, O(n^2logk)
A3. QuickSelect? -> I don't know exactly but changing input does matter i guess.
A4. BinarySearch? O(logn)
A5. BFS from the start?

Can my solution solve the example below?
k=4,
1 2 3
2 3 4
3 4 5

*/