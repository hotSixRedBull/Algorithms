//saw solution
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] indices = new int[n]; // record the index. we are going to sort this array
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        // sort indices with their corresponding values in nums, i.e., nums[indices[i]]
        mergeSort(indices, 0, n, result, nums);
        // change int[] to List to return
        List<Integer> resultToReturn = new ArrayList<Integer>(n);
        for (int i : result) {
            resultToReturn.add(i);
        }
        return resultToReturn;
    }

    private void mergeSort(int[] indices, int left, int right, int[] result, int[] nums) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(indices, left, mid, result, nums);
        mergeSort(indices, mid, right, result, nums);
        merge(indices, left, right, mid, result, nums);
    }

    private void merge(int[] indices, int left, int right, int mid, int[] result, int[] nums) {
        // merge [left, mid) and [mid, right)
        int i = left; // current index for the left array
        int j = mid; // current index for the right array
        // use temp to temporarily store sorted array
        List<Integer> temp = new ArrayList<Integer>(right - left);
        while (i < mid && j < right) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                // j - mid numbers jump to the left side of indices[i]
                result[indices[i]] += j - mid;
                temp.add(indices[i]);
                i++;
            } else {
                temp.add(indices[j]);
                j++;
            }
        }
        // when one of the subarrays is empty
        while (i < mid) {
            // j - mid numbers jump to the left side of indices[i]
            result[indices[i]] += j - mid;
            temp.add(indices[i]);
            i++;
        }
        while (j < right) {
            temp.add(indices[j]);
            j++;
        }
        // restore from temp
        for (int k = left; k < right; k++) {
            indices[k] = temp.get(k - left);
        }
    }
}
/*
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> answer = new ArrayList();
        List<Integer> sorted = new LinkedList();
                                                                                
        for (int i=nums.length-1; i>=0; i--) {
            int pos = addElement(sorted, nums[i]);
            answer.add(0, pos);
        }
        
        return answer;
    }
    
    public int addElement(List<Integer> li, int val) {
        int lo = 0;
        int hi = li.size()-1;
        System.out.println(String.format("[BEFORE] li: %s", li));
        while (lo <= hi) {
            int mid = lo - (lo - hi)/2;
            if (li.get(mid) < val) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        System.out.println(String.format("lo: %d", lo));
        li.add(lo, val);
        System.out.println(String.format("[AFTER] li: %s", li));
        return lo;
    }
}
*/