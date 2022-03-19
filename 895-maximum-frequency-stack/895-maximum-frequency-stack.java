class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> stkMap;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap();
        stkMap = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq)
            maxfreq = f;

        stkMap.computeIfAbsent(f, z-> new Stack()).push(x);
    }

    public int pop() {
        int x = stkMap.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (stkMap.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }
}