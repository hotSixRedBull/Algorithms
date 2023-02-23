class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> sortedItems = new ArrayList();
        for (int i=0; i<n; i++) {
            sortedItems.add(new int[]{capital[i], profits[i]});
        }
        Collections.sort(sortedItems, (a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int currentBudget = w;
        int sortedItemsIndex = 0;
        for (int i=0; i<k; i++) {
            while (sortedItemsIndex < sortedItems.size()) {
                int[] item = sortedItems.get(sortedItemsIndex);
                int itemCapital = item[0];
                int itemProfit = item[1];
                if (itemCapital > currentBudget) {
                    break;
                }
                pq.add(itemProfit);
                sortedItemsIndex++;
            }
            if (pq.size() == 0) {
                break;
            }
            currentBudget += pq.poll();
        }
        return currentBudget;
    }
}
/*
Tests i made

2
0
[100,2,3]
[0,1,1]
1
0
[100,2,3]
[1,1,1]
3
0
[1,2,3]
[0,1,2]
*/