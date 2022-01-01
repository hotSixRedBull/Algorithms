class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        HashMap<Integer, ArrayList<Integer>> nums1Map = new HashMap<>();
        for (int i=0; i<nums1.length; i++) {
            if (nums1Map.containsKey(nums1[i])) {
                ArrayList<Integer> arr = nums1Map.get(nums1[i]);
                arr.add(i);
                nums1Map.put(nums1[i], arr);
            }
            else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                nums1Map.put(nums1[i], arr);
            }
        }
        
        int max = 0;
        for (int i=0; i<nums2.length; i++) {
            if (nums1Map.containsKey(nums2[i])) {
                ArrayList<Integer> arr = nums1Map.get(nums2[i]);
                for (int a : arr) {
                    if (nums2.length - i < max) {
                        break;
                    }
                    int nums1Index = a;
                    int nums2Index = i;
                    while (nums1Index < nums1.length
                           && nums2Index < nums2.length 
                           && nums1[nums1Index] == nums2[nums2Index]) {
                        nums1Index++;
                        nums2Index++;
                    }
                    int length = nums2Index - i;
                    max = Math.max(max, length);
                }
            }
        }
        return max;
    }
}