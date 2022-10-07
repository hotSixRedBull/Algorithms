//saw solution..
class MyCalendarThree {
    private TreeMap<Integer, Integer> starts;
    private int res;

    public MyCalendarThree() {
        starts = new TreeMap<>();
        starts.put(0, 0);
        res = 0;
    }

    public void split(int x) {
        Integer prev = starts.floorKey(x);
        Integer next = starts.ceilingKey(x);
        if (next != null && next == x)
            return;
        starts.put(x, starts.get(prev));
    }

    public int book(int start, int end) {
        split(start);
        split(end);
        for (var interval : starts.subMap(start, true, end, false).entrySet()) {
            res = Math.max(res, interval.setValue(interval.getValue() + 1) + 1);
        }
        return res;
    }
}
/*
class MyCalendarThree {
    TreeSet<int[]> set;
    public MyCalendarThree() {
        set = new TreeMap<int[]>((a, b) -> a[1]-b[1]);
    }
    
    public int book(int start, int end) {
        int[] toPut = new int[]{start, end};
        if (set.size() == 0
                 || set.last()[1] <= start) {
            set.add(toPut);
        }
        else {
            int[] smaller = set.floor();
            int[] bigger = set.ceiling();
        }
        return set.size();
    }
}
*/
/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */