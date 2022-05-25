class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> li = new ArrayList();
        for (int num : nums) {
            if (li.size() == 0
                || li.get(li.size()-1) < num) {
                li.add(num);
            }
            else {
                int lo = 0;
                int hi = li.size()-1;
                while (lo < hi) {
                    int mid = lo - (lo - hi)/2;
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
            // System.out.println(li);
        }
        return li.size();
    }
}