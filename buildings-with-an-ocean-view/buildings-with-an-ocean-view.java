class Solution {
    public int[] findBuildings(int[] heights) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int maxHeight = 0;
        for (int i=heights.length-1; i>=0; i--) {
            if (heights[i] > maxHeight) {
                deque.addFirst(i);
                maxHeight = heights[i];
            }
        }
        return deque.stream().mapToInt(i->i).toArray();
    }
}