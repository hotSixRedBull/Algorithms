class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> indexes = new ArrayDeque();
        int n = deck.length;
        for (int i=0; i<n; i++) {
            indexes.add(i);
        }
        Queue<Integer> ansOrder = new ArrayDeque();
        while (indexes.size() > 0) {
            ansOrder.add(indexes.poll());
            if (indexes.size() > 0) {
                indexes.add(indexes.poll());
            }
        }
        // System.out.println(ansOrder);
        Arrays.sort(deck);
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            result[ansOrder.poll()] = deck[i];
        }
        return result;
    }
}