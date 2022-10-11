class Solution {
    public boolean increasingTriplet(int[] nums) {
        List<Integer> li = new ArrayList();
        for (int num : nums) {
            if (li.size() == 0
               || li.get(li.size()-1) < num) {
                li.add(num);
                if (li.size() == 3) {
                    return true;
                }
            }
            else {
                int toPut = Collections.binarySearch(li, num);
                if (toPut >= 0) {
                    continue;
                }
                else {
                    // System.out.println(li);
                    // System.out.println(num);
                    int insertionPoint = -(toPut + 1);
                    li.set(insertionPoint, num);
                }
            }
        }
        return false;
    }
}

/*
find LIS longer than 3?
*/