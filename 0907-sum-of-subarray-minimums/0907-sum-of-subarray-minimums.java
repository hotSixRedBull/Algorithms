//saw soultion

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;

        Stack<Integer> stack = new Stack<>();
        long sumOfMinimums = 0;

        // building monotonically increasing stack
        for (int i = 0; i <= arr.length; i++) {

            // when i reaches the array length, it is an indication that
            // all the elements have been processed, and the remaining
            // elements in the stack should now be popped out.

            while (!stack.empty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {

                // Notice the sign ">=", This ensures that no contribution
                // is counted twice. rightBoundary takes equal or smaller 
                // elements into account while leftBoundary takes only the
                // strictly smaller elements into account

                int mid = stack.pop();
                int leftBoundary = stack.empty() ? -1 : stack.peek();
                int rightBoundary = i;

                // count of subarrays where mid is the minimum element
                long count = (mid - leftBoundary) * (rightBoundary - mid) % MOD;

                sumOfMinimums += (count * arr[mid]) % MOD;
                sumOfMinimums %= MOD;
            }
            stack.push(i);
        }

        return (int) (sumOfMinimums);
    }
}

/*
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int modulo = 1_000_000_007;
        for (int len=1; len<=arr.length; len++) {
            TreeMap<Integer, Integer> map= new TreeMap();
            for (int i=0; i<len; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            }
            // System.out.println(String.format("len: %d, map: %s", len, map));
            sum += map.firstKey();
            sum %= modulo;
            for (int i=len; i<arr.length; i++) {
                if (map.get(arr[i-len]) == 1) {
                    map.remove(arr[i-len]);
                }
                else {
                    map.put(arr[i-len], map.get(arr[i-len])-1);
                }
                map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
                sum += map.firstKey();
                sum %= modulo;
            }
        }
        return sum;
    }
}
*/
/*
A1. finding all subarray

A2. TreeMap

A3. Math
each element will appear  `n choice pos`

*/