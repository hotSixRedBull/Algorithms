class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap();
        Set<Integer> elemSet = new HashSet();
        for (int ticket : tickets) {
            freqMap.put(ticket, freqMap.getOrDefault(ticket, 0) + 1);
            elemSet.add(ticket);
        }
        
        Integer[] elems = elemSet.toArray(new Integer[0]);
        Arrays.sort(elems);
        System.out.println("elems: "+Arrays.toString(elems));
        int prev = 0;
        int time = 0;
        int len = tickets.length;
        for (int elem : elems) {
            if (elem == tickets[k]) {
                time += len*(elem-prev-1);
                for (int i=0; i<=k; i++) {
                    if (tickets[i] >= elem) {
                        time++;
                    }
                }
                break;
            }
            time += len*(elem-prev);
            len -= freqMap.get(elem);
            prev = elem;
            System.out.println("time: "+time);
        }
        return time;
    }
}
/*
[84,49,5,24,70,77,87,8]
3
*/