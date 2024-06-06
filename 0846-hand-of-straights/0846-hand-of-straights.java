class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer, List<Integer>> cnt = new HashMap();
        for (int i=0; i<hand.length; i++) {
            cnt.putIfAbsent(hand[i], new ArrayList());
            cnt.get(hand[i]).add(i);
        }
        boolean[] used = new boolean[hand.length];
        for (int i=0; i<hand.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            for (int offset=1; offset<groupSize; offset++) {
                boolean put = false;
                if (cnt.containsKey(hand[i]+offset) == false) {
                    return false;
                }
                for (int index : cnt.get(hand[i]+offset)) {
                    if (used[index] == false) {
                        used[index] = true;
                        put = true;
                        break;
                    }
                }
                if (!put) {
                    return false;
                }
            }
        }
        return true;
    }
}