class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(boxes);
        ArrayList<Integer> li = new ArrayList();
        for (int i=0; i<boxes.length; i++) {
            li.add(boxes[i]);
        }
        int cnt = 0;
        // System.out.println(li);
        for (int i=0; i<warehouse.length; i++) {
            if (li.size() == 0) {
                break;
            }
            min = Math.min(min, warehouse[i]);
            // System.out.println("find "+min);
            //find min in li and remove
            int lo = 0;
            int hi = li.size()-1;
            while (lo < hi) {
                int mid = (lo+hi+1)/2;
                if (li.get(mid) <= min) {
                    lo = mid;
                }
                else {
                    hi = mid-1;
                }
            }
            if (li.get(lo) <= min) {
                cnt++;
                li.remove(lo);
            }
            else {
                break;
            }
            // System.out.println(li);
        }
        return cnt;
    }
}