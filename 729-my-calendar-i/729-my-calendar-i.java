//saw solution
class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
/*
class MyCalendar {
    TreeSet<int[]> set;
    public MyCalendar() {
        set = new TreeSet(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }
        });
    }
    
    public boolean book(int start, int end) {
        int[] schedule = new int[]{start, end};
        System.out.println(String.format(">>> cur: %s", Arrays.toString(schedule)));
        if (!set.isEmpty()) {
            if (set.contains(schedule)) {
                return false;
            }
            // find elem[0] <= start && elem[0] < end
            int[] higher = set.higher(schedule);
            System.out.println("higher: "+Arrays.toString(higher));
            //if exist, return false.
            if (higher != null
               && (
                   (start <= higher[0] && higher[0] < end)
                   ||(start < higher[1] && higher[1] <= end)
               )) {
                System.out.println("false");
                return false;
            }
            int[] lower = set.lower(schedule);
            System.out.println("lower: "+Arrays.toString(lower));
            if (lower != null
               && (
                   (start <= lower[0] && lower[0] < end)
                   ||(start < lower[1] && lower[1] <= end)
               )) {
                System.out.println("false");
                return false;
            }
        }
        set.add(schedule);
        System.out.println("true");
        return true;
    }
}

["MyCalendar","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
[[],[23,32],[42,50],[6,14],[0,7],[21,30],[26,31],[46,50],[28,36],[0,6],[27,36],[6,11],[20,25],[32,37],[14,20],[7,16],[13,22],[39,47],[37,46],[42,50],[9,17],[49,50],[31,37],[43,49],[2,10],[3,12],[8,14],[14,21],[42,47],[43,49],[36,43]]

*/
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
