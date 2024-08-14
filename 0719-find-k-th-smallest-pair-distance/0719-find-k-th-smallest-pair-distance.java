//OOM
//saw solution
class Solution {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int arraySize = nums.length;

        // Initialize binary search range
        int low = 0;
        int high = nums[arraySize - 1] - nums[0];

        while (low < high) {
            int mid = (low + high) / 2;

            // Count pairs with distance <= mid
            int count = countPairsWithMaxDistance(nums, mid);

            // Adjust binary search bounds based on count
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Count number of pairs with distance <= maxDistance using a moving window
    private int countPairsWithMaxDistance(int[] nums, int maxDistance) {
        int count = 0;
        int arraySize = nums.length;
        int left = 0;

        for (int right = 0; right < arraySize; ++right) {
            // Adjust the left pointer to maintain the window with distances <=
            // maxDistance
            while (nums[right] - nums[left] > maxDistance) {
                ++left;
            }
            // Add the number of valid pairs ending at the current right index
            count += right - left;
        }
        return count;
    }
}
/*

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                pq.add((int)Math.abs(nums[j]-nums[i]));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        // System.out.println(pq);
        int result = pq.poll();
        // while (pq.size() > 0) {
        //     result = pq.poll();
        // }
        return result;
    }
}

/*
[62,100,4]
2


*/