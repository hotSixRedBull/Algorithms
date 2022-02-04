class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Pair<Integer, Integer>> list = new ArrayList();
        for (int i=0; i<mat.length; i++) {
            list.add(new Pair(i, getPowerWithoutIndex(mat[i])));
        }
        // System.out.println("Before sort: "+list);
        Collections.sort(list, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> arg0, Pair<Integer, Integer> arg1) {
                if (arg0.getValue() < arg1.getValue()) {
                    return -1;
                }
                else if (arg0.getValue() > arg1.getValue()) {
                    return 1;
                }
                else {
                    if (arg0.getKey() < arg1.getKey()) {
                        return -1;
                    }
                    else if(arg0.getKey() > arg1.getKey()) {
                        return 1;
                    }
                    return 0;
                }
            }
        });
        int[] ans = new int[k];
        for (int i=0; i<k; i++) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
        
    }
    
    public int getPowerWithoutIndex(int[] arr) {
        int lo = 0;
        int hi = arr.length-1;
        while (lo < hi) {
            int mid = lo - (lo - hi) / 2;
            if (arr[mid] == 1) {
                lo = mid+1;
            }
            else {
                hi = mid;
            }
        }
        return arr[lo] == 1 ? lo+1 : lo;
    }
}