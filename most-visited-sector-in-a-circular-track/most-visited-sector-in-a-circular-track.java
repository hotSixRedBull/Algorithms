class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> arr = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            arr.add(0);
        }
        int prev = rounds[0]-1;
        int max = 0;
        for (int round : rounds) {
            if (round >= prev) {
                for (int i=prev+1; i<=round; i++) {
                    //System.out.println("visit "+i);
                    int cnt = arr.get(i)+1;
                    arr.set(i, cnt);
                    max = Math.max(max, cnt);
                }
            }
            else {
                for (int i=prev+1; i<=n; i++) {
                    //System.out.println("[second case] visit "+i);
                    int cnt = arr.get(i)+1;
                    arr.set(i, cnt);
                    max = Math.max(max, cnt);
                }
                for (int i=1; i<=round; i++) {
                    //System.out.println("[second case] visit "+i);
                    int cnt = arr.get(i)+1;
                    arr.set(i, cnt);
                    max = Math.max(max, cnt);
                }
            }
            prev = round;
        }
        arr = arr.subList(1, n+1);
        List<Integer> ans = new ArrayList<>();
        int index = 1;
        for (int val : arr) {
            if (val == max) {
                ans.add(index);
            }
            index++;
        }
        return ans;
    }
}