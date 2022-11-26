// Memory limit exceed..
// saw solution
class Solution {
    // maximum number of jobs are 50000
    int[] memo = new int[50001];
    
    private int findNextJob(int[] startTime, int lastEndingTime) {
        int start = 0, end = startTime.length - 1, nextIndex = startTime.length;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (startTime[mid] >= lastEndingTime) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }
    
    private int findMaxProfit(List<List<Integer>> jobs, int[] startTime, int n, int position) {
        // 0 profit if we have already iterated over all the jobs
        if (position == n) {
            return 0;
        }
        
        // return result directly if it's calculated 
        if (memo[position] != -1) {
            return memo[position];
        }
        
        // nextIndex is the index of next non-conflicting job
        int nextIndex = findNextJob(startTime, jobs.get(position).get(1));
        
        // find the maximum profit of our two options: skipping or scheduling the current job
        int maxProfit = Math.max(findMaxProfit(jobs, startTime, n, position + 1), 
                        jobs.get(position).get(2) + findMaxProfit(jobs, startTime, n, nextIndex));
        
        // return maximum profit and also store it for future reference (memoization)
        return memo[position] = maxProfit;
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        
        // marking all values to -1 so that we can differentiate 
        // if we have already calculated the answer or not
        Arrays.fill(memo, -1);
        
        // storing job's details into one list 
        // this will help in sorting the jobs while maintaining the other parameters
        int length = profit.length;
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            jobs.add(currJob);
        }
        jobs.sort(Comparator.comparingInt(a -> a.get(0)));
        
        // binary search will be used in startTime so store it as separate list
        for (int i = 0; i < length; i++) {
            startTime[i] = jobs.get(i).get(0);
        }
        
        return findMaxProfit(jobs, startTime, length, 0);
    }
}
/*
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        List<int[]> li = new ArrayList();
        for (int i=0; i<startTime.length; i++) {
            li.add(new int[]{startTime[i], endTime[i], profit[i]});
        }
        li.sort((a, b) -> {
            if (a[1] == b[1]) {
                if (a[0] == b[0]) {
                    return b[2]-a[2];
                }
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        
        int max = 0;
        Map<Integer, Integer> desirableMap = new HashMap();
        Queue<int[]> q = new ArrayDeque(); // [index, sum];
        q.add(new int[]{0, li.get(0)[2]});
        while (q.size()>0) {
            int[] cur = q.poll();
            int[] tuple = li.get(cur[0]);
            if (desirableMap.containsKey(cur[0])
               && desirableMap.get(cur[0]) > cur[1]) {
                continue;
            }
            // System.out.println(String.format("cur: %s, tuple: %s",
            //                                  Arrays.toString(cur),
            //                                 Arrays.toString(tuple)));
            max = Math.max(max, cur[1]);
            for (int i=cur[0]+1; i<li.size(); i++) {
                if (li.get(i)[0] < tuple[1]) {
                    // overlapped
                    q.add(new int[]{i, li.get(i)[2]});
                }
                else {
                    q.add(new int[]{i, cur[1]+li.get(i)[2]});
                }
            }
        }
        return max;
    }
}
*/