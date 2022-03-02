class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<seats.length; i++) {
            int index = 0;
            int local = 0;
            for (int j=i; j<seats.length; j++) {
                local += Math.abs(students[index++]-seats[j]);
            }
            for (int j=0; j<i; j++) {
                local += Math.abs(students[index++]-seats[j]);
            }
            ans = Math.min(ans, local);
        }
        return ans;
    }
}