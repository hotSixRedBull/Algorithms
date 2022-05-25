class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        
        List<Integer> li = new ArrayList();
        for (int i=0; i < envelopes.length; i++) {
            int num = envelopes[i][1];
            if (li.size() == 0
                || li.get(li.size()-1) < num) {
                li.add(num);
            }
            else {
                int lo = 0;
                int hi = li.size()-1;
                int mid = 0;
                while (lo < hi) {
                    mid = lo - (lo - hi)/2;
                    if (li.get(mid) == num) {
                        lo = mid;
                        break;
                    }
                    if (li.get(mid) < num) {
                        lo = mid+1;
                    }
                    else {
                        hi = mid;
                    }
                }
                li.set(lo, num);
            }
        }
        return li.size();
    }
}